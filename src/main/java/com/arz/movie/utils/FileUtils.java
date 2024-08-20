package com.arz.movie.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUtils {
    public  static   byte[] convertToBytes(MultipartFile file) {
        try {
            return file != null ? file.getBytes() : null;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert file to bytes", e);
        }
    }
}
