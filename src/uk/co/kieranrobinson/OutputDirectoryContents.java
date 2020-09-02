package uk.co.kieranrobinson;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class OutputDirectoryContents {
    public static void outputDirectoryContents(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of directory:");
        String dirPath = scan.nextLine();
        outputDirectoryContents(dirPath);
    }

    public static void outputDirectoryContents(String dirPath){
        try (Stream<Path> dir = Files.walk(Paths.get(dirPath),1)){
            dir
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch(NoSuchFileException ex){
            System.out.println("Folder doesn't exist");
        } catch(IOException ex){
            System.out.println("IOException Occurred");
        }
    }


    public static void outputDirectoryAndSubdirectoryContents(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of directory:");
        String dirPath = scan.nextLine();
        outputDirectoryAndSubdirectoryContents(dirPath);

    }

    public static void outputDirectoryAndSubdirectoryContents(String dirPath){
        Path testPath = FileSystems.getDefault().getPath(dirPath);

        try{
            Files.walkFileTree(testPath, new PrintDirectoryAndSubdirectory());
        } catch(IOException ex){
            System.out.println("Invalid input");
        }
    }
}
