package ru.mirea.Task6;

public class BuilderClass {
    public static void main(String[] args) {
        Person person = new PersonBuilderImp().setName("Ivan Ivanov").setAge(20).setSalary(80000).build();
        System.out.println(person);
    }

    static class Person
    {
        String name;
        int age;
        double salary;

        @Override
        public String toString() {
            return  name + ' ' + age + " years " + salary + "$";
        }
    }
    interface PersonBuilder
    {
        PersonBuilder setName(String name);
        PersonBuilder setSalary(double salary);
        PersonBuilder setAge(int age);
        Person build();
    }
    static class PersonBuilderImp implements PersonBuilder
    {
        Person person = new Person();
        @Override
        public PersonBuilder setName(String name) {
            person.name = name;
            return this;
        }

        @Override
        public PersonBuilder setSalary(double salary) {
            person.salary = salary;
            return this;
        }

        @Override
        public PersonBuilder setAge(int age) {
            person.age = age;
            return this;
        }

        @Override
        public Person build() {
            return person;
        }
    }
}