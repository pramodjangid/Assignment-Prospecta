# API Implementation and CSV File Reader

## Overview

This repository contains two projects: an API implementation and a CSV file reader. The API implementation includes endpoints for retrieving data from external sources and saving new entries. The CSV file reader is designed to parse CSV files containing formulas and values, evaluate the formulas, and output the results to a new CSV file.

## API Implementation

### Description

The API implementation is a Java-based RESTful API that retrieves data from external sources and allows users to save new entries.

### Usage

1. Ensure you have Java and a servlet container (e.g., Apache Tomcat) installed on your system.
2. Compile the Java program and deploy it to the servlet container.
3. Access the API endpoints using HTTP requests, such as GET and POST, to interact with the API.

### Features

- Provides endpoints for retrieving data from external sources based on user input parameters.
- Supports saving new entries with relevant properties retrieved from external sources.
- Offers comprehensive documentation for API endpoints and usage instructions using swagger api.

## CSV File Reader

### Description

The CSV file reader is a Java program that reads input from a CSV file, evaluates formulas, and writes the results to an output CSV file.

### Usage

1. Ensure you have Java installed on your system.
2. Compile the Java program using your preferred IDE or command line.
3. Run the compiled program, providing the input CSV file path as a command-line argument.

### Features

- Supports evaluation of formulas and values in the CSV file.
- Handles formula recursion and circular dependencies.
- Provides clear error messages for invalid input or formula evaluation errors.

## Additional Notes

- Both projects are written in Java and can be extended or modified according to specific requirements.
- Feel free to explore the source code and contribute to further enhancements or bug fixes.

