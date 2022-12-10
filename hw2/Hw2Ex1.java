/*
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

result -> name = "Ivanov"; country = "Russia"; city = "Moscow";
*/

public class Hw2Ex1 {
    public static void main(String[] args) {

        String command = "SELECT * FROM students WHERE ";

        String data = "{\"name\":\"Ivanov\", \"country\":\"null\", \"city\":\"Moscow\", \"age\":\"20\"}";

        System.out.println(getCommand(command, data));
    }

    private static String getCommand(String command, String data) {
        StringBuilder query = new StringBuilder();

        String name = parseResult(data, "name");
        if (notNull(name)) query.append("name = ").append(name).append("; ");

        String country = parseResult(data, "country");
        if (notNull(country)) query.append("country = ").append(country).append("; ");

        String city = parseResult(data, "city");
        if (notNull(city)) query.append("city = ").append(city).append("; ");

        String age = parseResult(data, "age");
        if (notNull(age)) query.append("age = ").append(age).append("; ");

        int resLength = (command + query).length();
        return (command + query).substring(0,resLength -1);
    }

    private static boolean notNull(String name) {
        return !name.equals("\"null\"");
    }

    private static String parseResult(String data, String part) {
        String res = "";
        String [] data_list = data.split(",");

        for (String item: data_list) {
            if (item.contains(part)){
                res = item.replace(("\"" + part + "\":"),"" ).trim();
            }
        }
        return res;
    }
}
