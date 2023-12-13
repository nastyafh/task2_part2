//Этот класс отвечает за курс. Опираясь на json файл, в нем я создала поле course, обозначяющее номер курса
// и поле, обозначающее номер группы (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.



import java.util.List;

public class Shed {
    private int course;
    private List<Groups> groups;

    public Shed(int course, List<Groups> groups) {
        this.course = course;
        this.groups = groups;
    }

    public Shed() {
    }

    public void setGroup(List<Groups> group) {
        this.groups = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Groups> getGroup() {
        return groups;
    }

    public int getCourse() {
        return course;
    }
    public String toString(){
        return course + " курса " +
                  groups;
    }
}
