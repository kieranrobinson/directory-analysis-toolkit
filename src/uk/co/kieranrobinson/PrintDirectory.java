//package uk.co.kieranrobinson;
//
//import java.io.IOException;
//import java.nio.file.FileVisitResult;
//import java.nio.file.Path;
//import java.nio.file.SimpleFileVisitor;
//import java.nio.file.attribute.BasicFileAttributes;
//
//public class PrintDirectory extends SimpleFileVisitor<Path> {
//
//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        System.out.println(file.toAbsolutePath());
//        return FileVisitResult.CONTINUE;
//    }
//
//    @Override
//    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//        System.out.println(dir.toAbsolutePath());
//        return FileVisitResult.CONTINUE;
//    }
//
//    @Override
//    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//        System.out.println("File access failed at + " + file.toAbsolutePath());
//        return FileVisitResult.CONTINUE;
//    }
//}
