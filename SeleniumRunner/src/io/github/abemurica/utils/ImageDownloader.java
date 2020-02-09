package io.github.abemurica.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageDownloader {
    public static void saveImage(String path, String name) {
        try (InputStream in = new URL(path).openStream()) {
            Files.copy(in, Paths.get("temp" + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
