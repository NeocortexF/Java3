package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

/**
 * Небольшая БД (таблица: студенты; поля: id, фамилия, балл).
 */
public class Students {

    private int id;
    private String name;

    public Students() {
    }

    private int grade;

    public Students(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
