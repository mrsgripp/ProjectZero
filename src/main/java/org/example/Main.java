package org.example;
import org.example.Exception.CLIException;
import org.example.View.CLIParser;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Scanner;

public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CLIParser cliparser = new CLIParser();

        System.out.println("Welcome to the Office Microwave.");
        System.out.println("Office Policy is not to reheat Fish in the Microwave.");

        while(true){

            System.out.println("Reheat / View History");
            String input = sc.nextLine();
            try{
                String output = cliparser.parseCommandReturnOutput(input);
                System.out.println(output);
            }catch(CLIException exception){
                System.out.println("Error");
                exception.printStackTrace();
            }

        }



    }
}