import java.time.LocalDate;

public class GenealogyResearchApp {
    public static void main(String[] args) {
        // Создание генеалогического дерева с корневым человеком person1
        FamilyTree familyTree = new FamilyTree();

        Person per1 = new Person("Sveta", "Komal", LocalDate.of(1989, 10, 2));
        Person per2 = new Person("Petr", "Komal", LocalDate.of(1988, 1, 15));
        Person ch1 = new Person("Ivan", "Komal", LocalDate.of(2020, 4, 11), per1, per2);
        familyTree.addPerson(per1);
        familyTree.addPerson(per2);

        familyTree.addChild(ch1);

        familyTree.addPerson(new Person("Maria", "Permyakova", LocalDate.of(2008, 6, 24)));

    }
}