import java.util.List;
//Этот класс отвечает за группу. Опираясь на json файл, в нем я создала поле group, обозначяющее номер группы
// и поле, обозначающее расписание для группы (это еще не конечный итог, который нужен пользователю).
//Создаю класс, прописываю в нем конструктор, геттеры, сеттеры, а также метод toString.
public class Groups {
    private int group;
    private List<Weeks> weeks;

    public Groups(int group,List<Weeks> weeks) {
        this.group = group;
        this.weeks = weeks;
    }

    public List<Weeks> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Weeks> weeks) {
        this.weeks = weeks;
    }

    public int getGroups() {
        return group;
    }

    public void setGroups(int group) {
        this.group = group;
    }


    public String toString() {
        return group +
                " группы на неделю " + weeks;
    }
}
