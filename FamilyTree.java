import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Person> tree= new ArrayList<>();      // Список всех людей в семье

    // 1 Добавление человека
    public void addPerson(Person person){
        if (!tree.contains(person)){tree.add(person);}
    }

    // 3 Добавление детей (ссылки на родителей уже внутри класса) (у родителей прописать так же детей)
    public void addChild(Person child){
        if (!tree.contains(child)){
            addPerson(child);
            child.getMother().addChild(child);
            child.getFather().addChild(child);
        }
    }
    // 4 Свадьба
    public void Marriadge(Person spouse1, Person spouse2, LocalDate marriageDate ){
        if (!tree.contains(spouse1)) { addPerson(spouse1); }
        if (!tree.contains(spouse2)) { addPerson(spouse2); }
        spouse1.Marriadge(spouse2, marriageDate);
        spouse2.Marriadge(spouse1, marriageDate);
    }
    // 5 Развод
    public void Divarce(Person spouse1, Person spouse2, LocalDate divorceDate ){
        if (tree.contains(spouse1) && tree.contains(spouse2)) {
            spouse1.Divorce(spouse2, divorceDate);
            spouse2.Divorce(spouse1, divorceDate);
        }
    }
    // 6 Смерть
    public void Death(Person person, LocalDate deathDate){
        if (tree.contains(person)){person.Dead(deathDate);}
    }
    // 7 Напечатать дерево
    // 8 Найти человека

}