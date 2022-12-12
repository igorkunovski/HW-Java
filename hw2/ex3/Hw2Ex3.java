/*
3.** Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия]
получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

package ex3;

import java.io.*;

public class Hw2Ex3 {
    public static void main(String[] args) {

        String dataStr;
        StringBuilder dataSB = new StringBuilder();

        try (FileReader fr = new FileReader("hw2/ex3/input.json");
             BufferedReader br = new BufferedReader(fr);

             FileWriter fw = new FileWriter("hw2/ex3/output.txt");
             PrintWriter pw = new PrintWriter(fw)
        )
        {
            String str;
            while ((str = br.readLine()) != null){
                dataSB.append(str.trim());
            }
            dataStr = String.valueOf(dataSB);
            String [] dataList = dataStr.split("},");

            fromJsonToString(pw, dataList);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fromJsonToString(PrintWriter pw, String[] dataList) {
        for (String line: dataList) {
            String [] lineList = line.split(",");

            StringBuilder resultSB = new StringBuilder();
            String resultSTR;

            buildResult(lineList, resultSB);

            resultSTR = String.valueOf(resultSB);
            resultSTR = resultSTR.replace("\"", "").replace("[","")
                    .replace("]","").replace("{","").replace("}", "");
            pw.write(resultSTR + "." + "\n" );
        }
    }


    private static void buildResult(String[] lineList, StringBuilder resultSB) {
        for (String linePart: lineList) {
            if (linePart.contains("фамилия")){
                String family = linePart.replace("\"фамилия\":", "");
                resultSB.append("Студент ").append(family);
            } else if (linePart.contains("оценка")) {
                String mark = linePart.replace("\"оценка\":", "");
                resultSB.append(" получил ").append(mark);
            } else if (linePart.contains("предмет")) {
                String subj = linePart.replace("\"предмет\":", "");
                resultSB.append(" по предмету ").append(subj);
            }
            else {
                System.out.println("Another type of JSON file information!");
            }
        }
    }
}
