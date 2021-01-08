package demo.domain;

import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private Student monitor;
    private int[] grades;
    private List<Student> friends;
    private Map<Integer, String> map;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getMonitor() {
        return monitor;
    }

    public void setMonitor(Student monitor) {
        this.monitor = monitor;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public List<Student> getFriends() {
        return friends;
    }

    public void setFriends(List<Student> friends) {
        this.friends = friends;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
