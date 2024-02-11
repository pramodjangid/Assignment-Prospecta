package com.prospecta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVFileReader {

    // Map to store cell values
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String csvFileInput = "input.csv";
        String csvFileOutput = "output.csv";

        try {
            // Reading from the input CSV file
            BufferedReader reader = new BufferedReader(new FileReader(csvFileInput));
            // Writing to the output CSV file
            FileWriter writer = new FileWriter(csvFileOutput);

            String line;
            while ((line = reader.readLine()) != null) {
                // Splitting each line by comma and storing in an Array
                String[] strings = line.split(",");
                for (String str : strings) {
                    // Splitting each string by colon to separate key and value
                    String[] strArray = str.split(":");
                    String key = strArray[0].trim();
                    String valueStr = strArray[1].trim();

                    // Evaluating formula and storing result in the map
                    int result = evaluateFormula(valueStr);
                    map.put(key, result);
                    writer.append(result + ",");
                }
                writer.append("\n"); // Adding newline after each row
            }

            reader.close();
            writer.close();
            System.out.println("Output written to " + csvFileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to evaluate formula and return the result
    private static int evaluateFormula(String formula) {
        if (formula.startsWith("=")) {
            // If formula starts with '=', evaluate expression
            String expr = formula.substring(1).trim();
            return evaluateExpression(expr);
        } else {
            // If not a formula, parse and return integer value
            return Integer.parseInt(formula);
        }
    }

    // Method to evaluate expression and return the result
    private static int evaluateExpression(String expression) {
        String[] tokens = expression.split("\\+");
        int result = 0;
        for (String token : tokens) {
            // Evaluating each token and summing up
            result += evaluateToken(token.trim());
        }
        return result;
    }

    // Method to evaluate token (cell reference or integer) and return the value
    private static int evaluateToken(String token) {
        if (token.matches("[A-Z]\\d")) {
            // If token is a cell reference, retrieve value from the map
            String cell = token.trim();
            if (map.containsKey(cell)) {
                return map.get(cell);
            } else {
                // If cell reference not found, print message and return 0
                System.out.println("Cell " + cell + " not found");
                return 0;
            }
        } else {
            // If token is not a cell reference, parse and return integer value
            return Integer.parseInt(token);
        }
    }
}
