# BASIC-Line-Renumbering
Overview
--------------------------------------------------------------------
The BASIC Line Renumbering Utility is a Java program designed to renumber the lines of a valid BASIC program. The program accepts an input BASIC file and updates the line numbers based on a specified starting number and increment value. This utility ensures that the line numbers are renumbered sequentially and sorted in ascending order, while maintaining the integrity of GOTO, THEN, and GOSUB statements.

Features
--------------------------------------------------------------------
- Command-Line Arguments: The program accepts three command-line arguments:

  1. The input BASIC file containing the original code.
  2. The starting line number (non-negative integer).
  3. The increment value for line numbering (positive integer).
- Efficient Renumbering: The program handles BASIC programs of arbitrary size, using efficient Java Collections and Map classes to ensure scalability.

- Special Handling of Commands: The program accurately updates line numbers in GOTO, IF...THEN, and GOSUB statements to ensure the program logic remains intact after renumbering.

Example Usage
--------------------------------------------------------------------
- Assuming an input file test1.BAS with the following content:

>10 READ A1, A2, A3, A4
>
>15 LET D = A1 * A4 - A3 * A2
>
>20 IF D = 0 THEN 65
>
>30 READ B1, B2

- Run the program:
>\> java Project5 [input-file] [start-number] [increment]

>\> java Project5 test1.BAS 11 7

- Would produce the following output:
>11 READ A1, A2, A3, A4
>
>18 LET D = A1 * A4 - A3 * A2
>
>25 IF D = 0 THEN 67
>
>35 READ B1, B2

How It Works
--------------------------------------------------------------------
- The program reads the BASIC code from the input file.
- It renumbers each line sequentially, starting from the specified starting number and increasing by the given increment value.
- GOTO, IF...THEN, and GOSUB statements are also updated to reference the correct renumbered lines.
- The output is printed to the console in a valid BASIC format.

Error Handling
--------------------------------------------------------------------
If any of the command-line arguments are missing or invalid, the program displays an appropriate usage or error message.
If the input file does not exist, an error message is displayed.

