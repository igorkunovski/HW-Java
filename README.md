# This repository consists of homework tasks for advanced JAVA fundamentals and solutions.

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


**Ex2 (mandatory)** Given an arbitrary list of integers, remove even numbers from it.

**Solution:** as the rule for list is not strict I used randomly generated ArrayList of 20 Integers and build it in a 
separate method. Using for-each loop for checking the non-odd numbers and add them to resulting arrayList. Iterator is
not help full it this task, because we need to check and remove (or add to a new list) - 2 using of .next(). 

**Ex3 (mandatory)** Given an integer ArrayList. Find the minimum, maximum and average from this list.

**Solution:** as the rule for list is not strict I used randomly generated ArrayList of 20 Integers and build it in a
separate method. Min and max are set to the first element of the arrayList. Using for-each loop I compare element 
with maximum and if this is not new maximum then with minimum. And if one of them is true, min or max value is 
updated. I need one round O(n) to get the result. There is also solution to use quick sort for this ArrayList and take 
first and last elements, but it is O(n*log n).

## _**HW4**_

**Ex1 (mandatory)** Given a LinkedList with multiple elements. Implement a method that will return a "flipped" 
list of the one in the list.

**Solution:** First I generate LinkedList with 10 random integers. Implemented method uses for-each loop to walk 
through the members of generated list and add these members to a new LinkedList from head. In the return the new 
filled list is "flipped". 

**Ex2 (mandatory)** Implement a queue using a LinkedList with the following methods:
enqueue() - places an element at the end of the queue,
dequeue() - returns the first element from the queue and removes it,
first() - returns the first element from the queue without removing it.

**Solution:** using available methods of LinkedList for our required methods.

**Ex3 (not mandatory, advanced)** Add the ability to undo the last operation to the calculator.

**Solution:** I used my simplest calculator program from previous homework. LinkedList is perfect tool for this 
exercise, because we can add new items from Head, and remove from head and list keeps insertion order. 
We don't need quick access to the middle elements. In the while cycle with the switch/case program reads command and
acts accordingly. There are commands: calc - for calculation, log - for printing history of operations, remove - removes
the last operation from the log, exit - terminates the while cycle and quits program.
