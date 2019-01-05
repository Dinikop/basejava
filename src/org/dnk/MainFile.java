package org.dnk;

import java.io.File;
import java.util.Objects;

public class MainFile {

    public static void main(String[] args) {
        File directory = new File(args[0]);
        if (directory.isDirectory()) {
            printAllFilesInDirectory(directory);
        } else {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
    }

    private static void printAllFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            if (file.isDirectory()) {
                printAllFilesInDirectory(file);
            } else {
                System.out.println(file.getName());
            }
        }

    }
}
