package uk.co.kieranrobinson;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userInput;

        while(true){
            printUI();
            userInput = scan.nextLine();

            switch (userInput) {
                case "1":
                    OutputDirectoryContents.outputDirectoryContents();
                    break;
                case "2":
                   OutputDirectoryContents.outputDirectoryAndSubdirectoryContents();
                   break;
                case "3":
                    FileAnalysis.searchForFile();
                    break;
                case "4":
                    FileAnalysis.countFiles();
                    break;
                case "5":
                    FileAnalysis.countFilesIncludingSubdirectories();
                    break;
                case "6":
                    System.out.println("Exiting Program");
                    return;
                default:
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
