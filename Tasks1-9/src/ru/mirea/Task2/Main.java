package ru.mirea.Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> hList = new ArrayList<>();
        hList = StreamAPI.getList();

        List<Human> FilteredBy20List = StreamAPI.filterBy20Age(hList);
        System.out.println("Старше 20 лет");
        StreamAPI.printout(FilteredBy20List);


        List<Human> SortedByTheLastLetter = StreamAPI.sortByTheLastLetter(hList);
        System.out.println("Сортировка по последней букве");
        StreamAPI.printout(SortedByTheLastLetter);


        List<Human> IncrBy3 = StreamAPI.incrBy3(hList);
        System.out.println("Увеличение возраста");
        StreamAPI.printout(IncrBy3);


        System.out.println("Средний возраст");
        System.out.println(StreamAPI.averageAge(hList, hList.size()));
    }
}
