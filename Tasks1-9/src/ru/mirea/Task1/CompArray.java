package ru.mirea.Task1;
import java.util.Comparator;

public class CompArray<T> implements Comparator<T[]> {
        public int compare(T[] a, T[] b) {
            return Integer.compare(a.length, b.length);
        }

    }

