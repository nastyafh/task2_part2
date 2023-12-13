//С этого класса я начинаю работу с файлом. Опираясь на json файл, в нем я создала поле name
// и поле, в котором хранится расписание для всех курсов (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.




import java.util.List;

public class Root {
    private String name;
    private List<Shed> shed;

    public String getName() {
        return name;
    }

    public List<Shed> getShed() {
        return shed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShed(List<Shed> shed) {
        this.shed = shed;
    }

    public String toString(){
        return name +
                " для " + shed;
    }
}
