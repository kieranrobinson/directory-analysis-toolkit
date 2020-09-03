package uk.co.kieranrobinson;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userInput;

        //Loop will run until program closes
        while(true){
            //Print UI options and take user input
            printUI();
            userInput = scan.nextLine();

            //Handle user input and perform corresponding action
            switch (userInput) {
                case "1":
                    //List all folders and files stored within a directory
                    OutputDirectoryContents.outputDirectoryContents();
                    break;
                case "2":
                    //List all folders and files stored within a directory and its subdirectories
                   OutputDirectoryContents.outputDirectoryAndSubdirectoryContents();
                   break;
                case "3":
                    //Search for a specific file within a directory and its subdirectories and if found, return where it was stored
                    FileAnalysis.searchForFile();
                    break;
                case "4":
                    //Count how many files and folders are stored within a directory
                    FileAnalysis.countFiles();
                    break;
                case "5":
                    //Count how many files and folders are stored within a directory and its subdirectories
                    FileAnalysis.countFilesIncludingSubdirectories();
                    break;
                case "6":
                    //Return from while loop, causing program to exit
                    System.out.println("Exiting Program");
                    return;
                default:
                    //User input did not match available functionality, alert user to invalid input
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void printUI() {
        System.out.println("\n" +
                "1. View contents of a directory \n" +
                        "2. View contents of a directory and contained subdirectories \n" +
                        "3. Search for specific file in a directory its subdirectories \n" +
                        "4. Retrieve number of folders and files in a directory \n" +
                        "5. Retrieve number of folders and files in a directory and its subdirectories \n" +
                        "6. Exit");
    }
}
