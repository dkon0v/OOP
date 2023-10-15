import java.util.ArrayList;
import java.util.List;

// Класс, представляющий отдельного человека
class Person {
    private String name;
    private List<Person> children; // Список детей

    // Конструктор класса
    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>(); // Инициализация списка детей
    }

    // Метод для получения имени человека
    public String getName() {
        return name;
    }

    // Метод для добавления ребенка
    public void addChild(Person child) {
        children.add(child);
    }

    // Метод для получения списка детей
    public List<Person> getChildren() {
        return children;
    }

    // Дополнительный метод для установки имени
    public void setName(String name) {
        this.name = name;
    }

    // Дополнительный метод для проверки наличия детей у человека
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    // Переопределение метода toString для вывода информации о человеке
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Класс, представляющий генеалогическое дерево
class FamilyTree {
    private Person rootPerson; // Корневой человек дерева

    // Конструктор класса
    public FamilyTree(Person rootPerson) {
        this.rootPerson = rootPerson;
    }

    // Метод для добавления ребенка к родителю
    public void addChild(Person parent, Person child) {
        parent.addChild(child);
    }

    // Метод для получения всех детей выбранного человека
    public List<Person> getAllChildren(Person person) {
        return person.getChildren();
    }

    // Дополнительный метод для получения корневого человека дерева
    public Person getRootPerson() {
        return rootPerson;
    }
}

// Класс для выполнения операций с генеалогическим древом
public class GenealogyResearchApp {
    public static void main(String[] args) {
        // Создание четырех человек
        Person person1 = new Person("John");
        Person person2 = new Person("Anna");
        Person person3 = new Person("Tom");
        Person person4 = new Person("Kate");

        // Создание генеалогического дерева с корневым человеком person1
        FamilyTree familyTree = new FamilyTree(person1);

        // Добавление детей к родителям
        familyTree.addChild(person1, person2);
        familyTree.addChild(person1, person3);
        familyTree.addChild(person2, person4);

        // Исследование: получение всех детей выбранного человека
        List<Person> children = familyTree.getAllChildren(person1);
        System.out.println("Children of " + person1.getName() + ": ");
        for (Person child : children) {
            System.out.println(child.getName());
        }

        // Дополнительные операции с классами Person и FamilyTree
        System.out.println("Root person: " + familyTree.getRootPerson());
        System.out.println("Does person1 have children? " + person1.hasChildren());
    }
}
