package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradeEvaluationTest {

    private void testStudentGradeEvaluation(String input, String expectedOutput) {
        // Set up input and output streams
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        // Run the main method
        StudentGradeEvaluation.main(new String[]{});

        // Normalize the output
        String actualOutput = normalizeWhitespace(out.toString());
        String expectedNormalizedOutput = normalizeWhitespace(expectedOutput);

        // Check the output
        assertEquals(expectedNormalizedOutput, actualOutput);
    }

    private String normalizeWhitespace(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    @Test
    public void testHighScoreEligibleForScholarship() {
        String input = "Alice\n22\n95\n";
        String expectedOutput = """
                Enter your name: Enter your age: Enter your exam score: 
                Name: Alice
                Age: 22
                Score: 95
                Grade: A
                """;
        testStudentGradeEvaluation(input, expectedOutput);
    }

    @Test
    public void testMediumScoreEligibleForScholarship() {
        String input = "Bob\n23\n85\n";
        String expectedOutput = """
                Enter your name: Enter your age: Enter your exam score: 
                Name: Bob
                Age: 23
                Score: 85
                Grade: B
                """;
        testStudentGradeEvaluation(input, expectedOutput);
    }

    @Test
    public void testMediumScoreNotEligibleForScholarshipDueToAge() {
        String input = "Charlie\n26\n85\n";
        String expectedOutput = """
                Enter your name: Enter your age: Enter your exam score: 
                Name: Charlie
                Age: 26
                Score: 85
                Grade: B
                """;
        testStudentGradeEvaluation(input, expectedOutput);
    }

    @Test
    public void testLowScoreNotEligibleForScholarship() {
        String input = "David\n24\n65\n";
        String expectedOutput = """
                Enter your name: Enter your age: Enter your exam score: 
                Name: David
                Age: 24
                Score: 65
                Grade: D
                """;
        testStudentGradeEvaluation(input, expectedOutput);
    }

    @Test
    public void testFailingScoreNotEligibleForScholarship() {
        String input = "Eva\n20\n55\n";
        String expectedOutput = """
                Enter your name: Enter your age: Enter your exam score: 
                Name: Eva
                Age: 20
                Score: 55
                Grade: F
                """;
        testStudentGradeEvaluation(input, expectedOutput);
    }
}
