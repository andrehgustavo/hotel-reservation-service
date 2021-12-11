package br.com.projects.hotelreservationservice.exception;

public class IncompleteHotelException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public IncompleteHotelException(String msg) {
		super(msg);
	}
}
