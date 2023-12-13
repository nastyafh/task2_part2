//Этот класс отвечает за день недели. Опираясь на json файл, в нем я создала поле day, обозначяющий день недели (уже
// известно, числитель это или знаменатель) и поле, обозначающее расписание (конечный итог, который будет нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.



import java.util.List;

public class Days {
    private String day;
    private List<String> shedule;

    public Days(String day,List<String> shedule) {
        this.day = day;
        this.shedule = shedule;
    }

    public List<String> getShedule() {
        return shedule;
    }

    public void setShedule(List<String> shedule) {
        this.shedule = shedule;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day +
                ": \n" + shedule;
    }
}
