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

**Task:** The sql query string "select * from students where" is given. Build the WHERE part of this query using
StringBuilder.The data for filtering is given below as a json string.
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

## _**HW5**_

**Ex1 (mandatory)**Implement a phone book structure using a HashMap considering that 1 person can have multiple phones.

**Solution:** For this purpose I used HashMap <String, HashSet<Integer> collection with String as **key** and
HashSet of Integers as **values**. If we add same number to person, HashSet will ignore this addition. If inserted
Person exists in keys, new number will be added to set.

**Ex2 (mandatory)** Given a list of employees. Write a program to find and print duplicate names with
the number of repetitions. Sort in descending order of popularity.

**Solution:** First of all we build a Map with key - name, and value - number of repetition. As we have HashMap,
data is not sorted. Even using TreeMap will not help, because it is sorting data by keys. Fort this purpose I use
additionally LinkedHashMap and fill it up comparing data values. As LHM keeps insertion order, we'll get sorted by
values Map for the result.

From Java 8 there is Stream API function to arrange collection in necessary way. But This task does not suppose
to the use this possibility.

    Stream<Map.Entry<String, Integer>> sortedByValue = overlap.entrySet(). stream().sorted(Map.Entry.comparingByValue());
    sortedByValue.forEach(System.out::println);

**Ex3 (mandatory)** Implement the **HeapSort** algorithm.

The performance of this algorithm is **O(n*log n)** in every scenario. Firstly we build binary tree from the list
where every parent has 2 children. First main parent is the list[0] elem, it's children: left: list[1], right: list[2]
and so on. After it is built - the idea is that every parent must be bigger than its children. The main parent must
become the largest item of tree. With every compare and swap data also migrate in the position number of the list.
After the largest is found, its position list[0] - it is placed at the end of the list. Last item of the list
comes to the place of the main parent list[0] and finding new largest main parent starts from the beginning until
list is fully sorted.

**Ex4 (not mandatory, advanced)** Arrange 8 queens on a chessboard so that they do not hit each other.

## _**HW6**_

**Ex1 (mandatory)**

**Course final project.**

Think about the structure of the Laptop class for a hardware store - highlight
the fields and methods. Implement in java. Create many notebooks. Write a method that will ask the user for the filtering
criterion (or criteria) and will display laptops that match the filter. Filter criteria can be stored in Map.
For example: Enter the number corresponding to the required criterion. Next, you need to request the minimum values for
the specified criteria - save the parameters filtering is also possible in Map. Filter laptops from their original set
and display passing by conditions.

**Solution:**

Class Notebook has 6 instance variables. 5 of them are final, because they are not changed after creation in this program,
and 1 (qty) can be changed via method.

Hashset is used for keeping created Notebooks. Method equals() and hashCode() of Notebook class are overridden, so that they take in account
only (in our case final) certain fields. If in the set we have Notebook with the same data (final fields in our case),
then the qty is incremented by 1. It is like we add one more to the stock.

Method **findNotebook()** asks to insert data for search and using do-while and switch-case cycles to process data.
Inserted data is kept in the HashMap. Key - number of field, value - data to be found.
Map can contain up to 5 criteria for searching.

Only if all required criteria is matched (with ignored Case), Notebook gets to the result set. This result is showed to user.

Method toString() is overridden, so all Notebooks are printed in details.

*******************

Class Notebook имеет 6 переменных экземпляра. 5 из них final, так как не меняются после создания в данной программе,
а 1 (qty) можно изменить через метод.

Hashset используется для хранения созданных экземпляров Notebook. Метод equals() и hashCode() класса Notebook переопределены, так что они учитывают только
(в нашем случае final) определенные поля. Если в Set у нас Notebook с теми же данными (полями final в нашем случае),
то количество увеличивается на 1. Мы как бы добавляем к запасу еще один такой же.

Метод findNotebook() запрашивает с помощью Scanner данные для поиска и использует циклы do-while и switch-case для обработки данных.
Веденные данные хранятся в HashMap. Key - номер поля, Value - данные, которые нужно найти. Map может содержать
до 5 критериев для поиска.

Только если все требуемые критерии соблюдены (с игнорированием регистра), Notebook добавляется в новый Set реультатов.
Этот результат выводится пользователю.

Метод toString() переопределен, поэтому все Notebook печатаются в деталях.