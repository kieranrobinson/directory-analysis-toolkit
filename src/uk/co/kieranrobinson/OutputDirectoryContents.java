package uk.co.kieranrobinson;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class OutputDirectoryContents {
    //Asks user for a directory location and if it exists lists the contents of the directory
    public static void outputDirectoryContents(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of directory:");
        String dirPath = scan.nextLine();
        outputDirectoryContents(dirPath);
    }

    //Lists the contents of the provided directory to the user
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

    //Asks user for a directory location and if it exists lists the contents of the directory and its subdirectories
    public static void outputDirectoryAndSubdirectoryContents(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of directory:");
        String dirPath = scan.nextLine();
        outputDirectoryAndSubdirectoryContents(dirPath);

    }

    //Lists the contents of the provided directory and its subdirectories to the user
    public static void outputDirectoryAndSubdirectoryContents(String dirPath){
        Path testPath = FileSystems.getDefault().getPath(dirPath);

        try{
            Files.walkFileTree(testPath, new PrintDirectoryAndSubdirectory());
        } catch(IOException ex){
            System.out.println("Invalid input");
        }
    }
}
