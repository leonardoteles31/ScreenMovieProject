package br.com.leodev.screenmovie.Exception;

public class ExceptionYearConversionError extends RuntimeException {
    private String message;

    public ExceptionYearConversionError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
