package com.example;

import java.util.Scanner;

public class StudentGradeEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Prompt the user to enter their exam score
        System.out.print("Enter your score: ");
        int score = scanner.nextInt();

        // Determine the grade
        String grade;
            if (score >=90){
                grade = "A";
        }
            else if (score >=80 && score <90){
                grade = "B";
        }
            else if (score >=70 && score <80){
                grade = "C";
        }
            else if (score >=60 && score <70){
                grade = "D";
        }
            else {
                grade = "F";
        }
            

        // Print the student's details
        System.out.println("\nStudent Details: ");
        System.out.println("Name: "+ name);
        System.out.println("Age: "+ age);
        System.out.println("Score: "+ score);
        System.out.println("Grade: "+ grade);

       
        // Determining if the student is eligible for scholarship//
        boolean isEligibleForScholarship = age < 25 && (grade.equals("A") || grade.equals("B"));


        //Printing the scholarship eligibility mmessage//
        if (isEligibleForScholarship) {
            System.out.println("Congratulations!! You are eligible for scholarship.");
        }
        else {
            System.out.println("Sorry!! You are not eligible for scholarship.");
        }
        scanner.close();
    }
}
