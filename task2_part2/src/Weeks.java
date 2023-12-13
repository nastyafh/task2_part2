//Этот класс отвечает за расписание конкретной группы конкретного курса.
//Опираясь на json файл, в нем я создала поле week, обозначяющее название недели (числитель или знаменатель)
// и поле, обозначающее день недели, для которого ищется расписание (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.





import java.util.List;

public class Weeks {
    private String week;
    private List<Days> days;

    public Weeks(String week, List<Days> days) {
        this.week = week;
        this.days = days;
    }

    public Weeks() {
    }

    @Override
    public String toString() {
        return week +
                " на день " + days;
    }

    public List<Days> getDay() {
        return days;
    }

    public void setDay(List<Days> day) {
        this.days = days;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
