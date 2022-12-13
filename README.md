# This repository consists of homework tasks for advanced JAVA and solutions.

## _**HW1**_

**Ex1 (mandatory)**

**Task:** Calculate the sum of numbers from 1 to n.

**Solution:** Using Scanner to get int n and while cycle for calculation.

**Ex2 (mandatory)**

**Task:** Print all prime numbers from 1 to 1000.

**Solution:** Prime number are divisible by itself and 1. 
Using nested for cycles to check divisibility and StringBuilder to build String result.

**Ex3 (mandatory)**

**Task:** Implement a simple calculator.

**Solution:** Calculator asks from user first number, action and second number with help of Scanner.
Using switch/case cycle to calculate the result in separate method. Added Exception handler if division by zero or 
incorrect data is inserted.

**Ex4 (not mandatory, advanced)**

**Task:** An equation of the form q + w = e; q, w, e >= 0 is given.
Some numbers can be replaced with a question mark, such as 2? + ?5 = 69.
It is required to restore the expression to true equality. Suggest at least one solution or report that there is none.

**Solution:** First of all expression is read from console via Scanner. Next step is split it with regex "=". 
Right part is the result. Left part is the expression with question marks. Left part is split again with regex"+". 
With nested-for loops search for option where numbers instead of question marks give correct result.
If this result is found - it is printed out.

## _**HW2**_

**Ex1 (mandatory)**

**Task:** The sql query string "select * from students where" is given. Build the WHERE part of this query using StringBuilder.
The data for filtering is given below as a json string.
If the value is null, then the parameter should not be included in the request.
Filtering parameters: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

**Solution:** as we have one information line with different keys in the json string, I split it with regex"," 
to get all key:value parts as list. Then required value is found via key value. 
If value is not null, it is appended to result string.

**Ex2 (mandatory)**

**Task:** Implement the bubble sorting algorithm for a numerical array, write the result after each 
iteration to a log file.

**Solution:** the Logger class with INFO level is used to log to a file logArr.txt all iteration 
results in SimpleFormatter form.

**Ex3 (not mandatory, advanced)**

**Task:** given a json string (you can save to a file and read from a file). Write a method(s) that parses json and, 
using StringBuilder, creates strings like: Student [surname] received [grade] in the subject [subject].

**Solution:** I used input.json file to read (BufferedReader) from and output.txt file to write(PrintWriter) into. 
Given json string type contains of 2 nested lists. First it is split with regex "},"and received list of inner lists 
in String form. With for-each loop inner list is split again with regex"," and with key required value is added to 
resulting StringBuilder. StringBuilder is cast to String to modify final result. 

**Ex4 (not mandatory, advanced)**

**Task:** Add logging to the calculator from the previous Homework2 (Ex3).

**Solution:** the Logger class with INFO level is used to log to a file logCalc.txt every calculation result 
in SimpleFormatter form. If it was division by zero, WARNING level is used.

## _**HW3**_

**Ex1 (mandatory)** Implement merge sort algorithm.

**Solution:** Merge sort is one of the fastest and efficient sorting type with O(nlog n). 
The idea is to divide with recursion array by half until the simplest part is left - one number array, 
which is sorted. Next step is to built back smaller sorted arrays into full sorted array. 

