#!/usr/bin/env bash
set -x
set -eo pipefail

DB_USER=${POSTGRES_USER:=postgres}
DB_PASSWORD="${POSTGRES_PASSWORD:=postgres}"
DB_NAME="${POSTGRES_DB:=hotel-reservation-db}"
DB_PORT="${POSTGRES_PORT:=5432}"
DB_SCRIPT=$(<./Scripts/db_script.sql)

# Allow to skip Docker if a dockerized Postgres database is already running
if [[ -z "${SKIP_DOCKER}" ]]
then
  docker run \
      -e POSTGRES_USER=${DB_USER} \
      -e POSTGRES_PASSWORD=${DB_PASSWORD} \
      -e POSTGRES_DB=${DB_NAME} \
      -p "${DB_PORT}":5432 \
      -d postgres \
      postgres -N 1000
fi

export PGPASSWORD="${DB_PASSWORD}"
until psql -h "localhost" -U "${DB_USER}" -p "${DB_PORT}" -d "postgres" -c '\q'; do
  >&2 echo "Postgres is still unavailable - sleeping"
  sleep 1
done

>&2 echo "Creating tables..."

psql -h "localhost" -U "${DB_USER}" -p "${DB_PORT}" -d "hotel-reservation-db" -c "${DB_SCRIPT}"

>&2 echo "Tables created"

>&2 echo "Postgres is up and running on port ${DB_PORT}"