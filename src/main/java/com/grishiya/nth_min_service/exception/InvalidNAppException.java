package com.grishiya.nth_min_service.exception;

public class InvalidNAppException extends RuntimeException {
    public InvalidNAppException(int n, int size) {
        super("N должно быть в диапазоне 1.." + size + ", пришло " + n);
    }
}
