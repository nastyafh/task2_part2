//В этом классе я пишу алгоритм для вывода нужной пользователю информации из json файла


//тут весь импорт
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class JsonParser { //создала класс
    public Root root_parse() { //создала метод для парсинга
        Scanner scanner = new Scanner(System.in); //обозначаем сканер
        Root root = new Root(); //создала экземпляр класса Root
        System.out.println("Введите курс цифрой: "); //Пишем пользователю, что вводить на данном этапе и сканируем введенное
        int your_course = scanner.nextInt();
        System.out.println("Введите группу цифрой: ");
        int your_group = scanner.nextInt();
        System.out.println("Введите название недели с маленькой буквы (числитель/знаменатель): ");
        String your_week = scanner.next();
        System.out.println("Введите название дня недели с маленькой буквы: ");
        String your_day = scanner.next();

        JSONParser parser = new JSONParser(); //создала экземпляр класса JSONParser

        try (FileReader reader = new FileReader("target/Shedule.json")) { //создаю try catch для обработки исключений
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader); //вызываю метод parse из добавленной бибилиотеки для работы с json

            String name = (String) rootJsonObject.get("name"); //инициализирую переменную и задаю ей значение из класса Root
            JSONArray shedJsonArray = (JSONArray) rootJsonObject.get("shed"); //аналогично, только для массива
            int shedSize = shedJsonArray.size(); //размер понадобится в дальнейшем
            int count1 = 0; // и это тоже
            List<Shed> shedList = new ArrayList<>(); //создаю список
            for (Object it1 : shedJsonArray) { //в цикле пробегаюсь по заданному массиву
                JSONObject shedJsonObject = (JSONObject) it1; //инициализирую объект из shedJsonArray и задаю его
                long course = (Long) shedJsonObject.get("course"); //иниицализация, присвоение значения. Тип long,так как int выдаст ошибку.
                //^ мы приобразуем лонг в инт позже
                count1+=1;
                if((int)course !=your_course){//при несовпадении курса из файла и нужного пользователю курса ищем нужный курс дальше
                    if(shedSize == count1){ // а если мы дошли до конца файла, но так и не нашли нужное
                        System.out.println("Для этого курса еще нет расписания");//пишем, что нет данных
                        break;
                    }
                    continue;
                }
                //Дальше код будет повторяться,только для других вложенных объектов: создание списков, считывание данных и прочее
                JSONArray groupsJsonArray = (JSONArray) shedJsonObject.get("groups");
                int groupsSize = groupsJsonArray.size();
                int count2 = 0;
                List<Groups> groupsList = new ArrayList<>();
                for(Object it2 : groupsJsonArray){
                    JSONObject groupsJsonObject = (JSONObject) it2;
                    long group = (Long) groupsJsonObject.get("group");
                    count2+=1;
                    if((int)group != your_group){
                        if(groupsSize == count2){
                            System.out.println("Для этого курса еще нет расписания");
                            break;
                        }
                        continue;
                    }
                    JSONArray weeksJsonArray = (JSONArray) groupsJsonObject.get("weeks");
                    int weeksSize = weeksJsonArray.size();
                    int count3 = 0;
                    List<Weeks> weeksList = new ArrayList<>();
                    for(Object it3 : weeksJsonArray){
                        JSONObject weeksJsonObject = (JSONObject) it3;
                        String week = (String) weeksJsonObject.get("week");
                        if((!week.equals(your_week))){
                            if(groupsSize == count2){
                                System.out.println("Для этой недели еще нет расписания");
                                break;
                            }
                            continue;
                        }
                        JSONArray daysJsonArray = (JSONArray) weeksJsonObject.get("days");
                        int daysSize = daysJsonArray.size();
                        int count4= 0;
                        List<Days> daysList = new ArrayList<>();
                        for(Object it4 : daysJsonArray){
                            JSONObject daysJsonObject = (JSONObject) it4;
                            String day = (String) daysJsonObject.get("day");
                            if((!day.equals(your_day))){
                                if(groupsSize == count2){
                                    System.out.println("Для этого дня еще нет расписания");
                                    break;
                                }
                                continue;
                            }
                            JSONArray sheduleJsonArray = (JSONArray) daysJsonObject.get("shedule");
                            List<String> sheduleList = new ArrayList<>();
                            for(Object it5 : sheduleJsonArray){
                                sheduleList.add((String) it5);
                            }
                            Days days = new Days((String) day, sheduleList);
                            daysList.add(days);
                        }
                        Weeks weeks = new Weeks((String) week, daysList);
                        weeksList.add(weeks);
                    }
                    Groups groups = new Groups((int) group, weeksList);
                    groupsList.add(groups);
                }
                Shed shed = new Shed((int) course, groupsList); //создаем экземпляр класса, куда сразу помещаем курс и группу

                shedList.add(shed); //добавляем shed в shedlist
            }

            root.setName(name); //устанавливаем имя (оно будет = "Расписание занятий")
            root.setShed(shedList); //и расписание
            return root; //и возвращаем root
        } catch (Exception e) { //если что-то пойдет не так, печатаем, что парсинг прошел неудачно
            System.out.println("Parsing error" + e.toString());
        }
        scanner.close();
        return null; //и возвращаем null, если что-то пошло не так
    }
}

//"^\\[|\\]$"