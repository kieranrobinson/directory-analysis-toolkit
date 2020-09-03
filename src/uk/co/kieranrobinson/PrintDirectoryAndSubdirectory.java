package uk.co.kieranrobinson;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintDirectoryAndSubdirectory extends SimpleFileVisitor<Path> {

    //When each file is visited print its absolute path
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    //Before each directory is visited print the absolute path of the directory
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    //If a file cannot be accessed output an error message and continue
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.out.println("File access failed at " + file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }
}
