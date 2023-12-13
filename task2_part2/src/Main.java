//Это класс Main. Здесь можно запустить мой проект
public class Main {
    public static void main(String[] args) {

        JsonParser parser = new JsonParser();
        Root root = parser.root_parse();
        System.out.println(root.toString());
    }
}