package br.com.projects.hotelreservationservice.exception;

public class ErrorRegisterNotFoundInDataBase extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public ErrorRegisterNotFoundInDataBase(String msg) {
		super(msg);
	}
}
