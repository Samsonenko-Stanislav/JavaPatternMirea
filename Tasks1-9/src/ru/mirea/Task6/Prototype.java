package ru.mirea.Task6;

    public class Prototype {
        public static void main(String[] args) {
            Student original = new Student("Samsonenko Stanislav", 19, "IKBO-01-20");
            System.out.println(original);

            Student copy = (Student) original.copy();
            System.out.println(copy);
        }
    }

    interface Copyable {
        Object copy();
    }

    class Student implements Copyable {
        String name;
        int age;
        String group;
        public Student( String name, int age, String group){
            this.name = name;
            this.age = age;
            this.group = group;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", group='" + group + '\'' +
                    '}';
        }

        @Override
        public Object copy() {
            Student copy = new Student(name, age, group);
            return copy;
        }
    }
