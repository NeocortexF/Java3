package ru.geekbrains.java3.dz.dz6.shurukhin.DB;

import org.hibernate.ObjectNotFoundException;

import java.util.List;
import java.util.Map;

/**
 * Сущность студента. Довольно примитивная -_-
 * Таблица создается автоматически.
 *
 CREATE TABLE students_ksh
 (
 id bigint NOT NULL,
 last_name character varying(255),
 score integer,
 CONSTRAINT students_ksh_pkey PRIMARY KEY (id)
 )
 WITH (
 OIDS=FALSE
 );
 ALTER TABLE students_ksh
 OWNER TO postgres;
 */
public class Student implements ExecStatement{
    private Long id;
    private String lastName;
    private int score;

    public Student(Long id, String lastName, int score) {
        this.id = id;
        this.lastName = lastName;
        this.score = score;
        SQLExec.execute(driver, SQL_CREATE_TABLE);
    }

    public Student(Long id) {
        this.id = id;
        SQLExec.execute(driver, SQL_CREATE_TABLE);
        List<Map<String, Object>> result = SQLExec.execute(driver, SQL_SELECT_STUDENTS_ALL_BYID, id);
        if (result.size() < 1) throw new ObjectNotFoundException(id, Student.class.getName());
        this.lastName = (String) result.get(0).get("last_name");
        this.score = (int) result.get(0).get("score");

    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void save() {
        if (SQLExec.execute(driver, SQL_SELECT_STUDENTS_ALL_BYID, id).size() == 1)
            SQLExec.execute(driver, SQL_UPDATE_STUDENTS, lastName, score, id);
        else
            SQLExec.execute(driver, SQL_INSERT_STUDENTS, id, lastName, score);
    }

    public void delete() {
//        if (SQLExec.execute(driver, SQL_SELECT_STUDENTS_ALL_BYID, id).size() == 1)
            SQLExec.execute(driver, SQL_DELETE_STUDENT, id);
    }
}
