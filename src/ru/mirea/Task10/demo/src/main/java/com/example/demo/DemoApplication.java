package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        SortingAlgorithm is = (SortingAlgorithm) applicationContext.getBean("InsertionSort");
        SortingAlgorithm qs = applicationContext.getBean(QuickSort.class);
        SortingAlgorithm ms = (SortingAlgorithm) applicationContext.getBean("MergeSort");

        is.doSort();
        qs.doSort();
        ms.doSort();


    }

}
