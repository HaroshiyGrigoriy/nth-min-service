package com.grishiya.nth_min_service.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String path) {
        super("Файл не найден" + path);
    }
}
