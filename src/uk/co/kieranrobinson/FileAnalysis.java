package uk.co.kieranrobinson;

import java.io.File;
import java.util.Scanner;

public class FileAnalysis {

    //Searches the provided directory for the name corresponding with the provided filename, and if found, outputs where
    public static void searchForFile(String filename, File directory){
        File[] filelist = directory.listFiles();
        if(filelist != null){
            for(File file : filelist){
                if(file.isDirectory()){
                    searchForFile(filename,file);
                    return;
                }
                else if(filename.equalsIgnoreCase(file.getName())){
                    System.out.println("Found at " + file.getParentFile());
                    return;
                }
            }
        }
        System.out.println("File not found");
    }

    //Asks for filename and directory location before searching the provided directory for the name corresponding
    //with the provided filename, and if found, outputs where
    public static void searchForFile(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of file to search for (e.g. example.txt):");
        String filename = scan.nextLine();
        System.out.println("Enter name of directory to begin search from:");
        File directory = new File(scan.nextLine());
        searchForFile(filename, directory);
    }

    //Asks for a directory path and counts the number of folders and files stored within the directory
    public static void countFiles(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory path:");
        File directory = new File(scan.nextLine());
        countFiles(directory);
    }

    //Outputs the number of folders and files stored within the directory
    public static void countFiles(File directory){
        File[] filelist = directory.listFiles();
        int directoryCount = 0;
        int fileCount = 0;

        if(filelist != null){

            for(File file : filelist){
                if(file.isDirectory()){
                    directoryCount = directoryCount + 1;
                } else if(file.isFile()){
                    fileCount = fileCount + 1;
                }
            }
        }

        if(filelist != null){
            System.out.println(directoryCount + " Directories");
            System.out.println(fileCount + " Files");
        } else {
            System.out.println("No files stored");
        }
    }

    //Asks for a directory path and counts the number of folders and files stored within the directory and its subdirectories
    public static void countFilesIncludingSubdirectories(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory path:");
        File directory = new File(scan.nextLine());
        countFilesIncludingSubdirectories(directory);
    }

    //Outputs the number of folders and files stored within the directory and its subdirectories
    public static void countFilesIncludingSubdirectories(File directory){
        int fileCount = getFilesCount(directory);
        int directoryCount = getDirectoriesCount(directory);
        System.out.println("Files: " + fileCount);
        System.out.println("Directories " + directoryCount);
    }

    //Returns an int with the total number of files in the provided directory
    private static int getFilesCount(File directory){
        File[] filelist = directory.listFiles();
        int fileCount = 0;

        if(filelist != null){

            for(File file : filelist){
                if(file.isDirectory()){
                    fileCount += getFilesCount(file);
                } else if(file.isFile()){
                    fileCount++;
                }
            }

        }
        return fileCount;
    }

    //Returns an int with the total number of folders in the provided directory
    private static int getDirectoriesCount(File directory){
        File[] filelist = directory.listFiles();
        int directoryCount = 0;

        if(filelist != null){
            for(File file : filelist){
                if(file.isDirectory()){
                    directoryCount++;
                    directoryCount += getDirectoriesCount(file);
                }
            }
        }
        return directoryCount;
    }
}
