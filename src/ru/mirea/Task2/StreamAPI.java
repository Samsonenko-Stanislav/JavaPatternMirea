package ru.mirea.Task2;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI
{
    public static List<Human> getList()
    {
        return List.of(
                new Human(18, "Ivan", "Ivanov", LocalDate.of(2004,01,01), 53),
                new Human(25, "Maria", "Sidorova", LocalDate.of(1998,11,24), 50),
                new Human(21, "Anna", "Nikolaeva", LocalDate.of(2000,5,3),65),
                new Human(19, "Stanislav", "Samsonenko", LocalDate.of(2002,5,3),55)
        );
    }

    public static void printout(List<Human> hlist)
    {
    hlist.forEach(System.out::println);
    }

    //Фильтруем на старших 20
    public static List<Human> filterBy20Age(List<Human> hList)
    {
        return hList.stream().filter(human -> human.getAge()>20.).collect(Collectors.toList());
    }


    public static List<Human> sortByTheLastLetter(List<Human> hlist)
    {
      return hlist.stream().sorted((h1,h2) ->
              {
                char letter1 = h1.getFirstName().charAt(h1.getFirstName().length()-1);
                char letter2 = h2.getFirstName().charAt(h2.getFirstName().length()-1);
                    return (letter1 > letter2)? 1: -1;
              }).collect(Collectors.toList());
    }

    public static List<Human> incrBy3(List<Human> hlist)
    {
        hlist.stream().forEach(h -> h.age += 3);
        return hlist;
    }


    public static double averageAge(List<Human> hlist, int hListNumberOfElements)
    {
        double temp = hlist.stream().mapToInt(Human::getAge).sum();
        double x = temp / hListNumberOfElements;
        return x;
    }
}
