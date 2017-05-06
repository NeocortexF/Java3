package ru.geekbrains.java3.dz.dz6.shurukhin.DB;

import org.hibernate.ObjectNotFoundException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentTest {
    private static Student stud1;
    private static Student stud2;
    private static Student stud3;


    @BeforeClass
    public static void initTest() {
        stud1 = new Student(231234214L, "Тестовый студент1", 4);
        stud2 = new Student(243243242L, "Тестовый студент2", 2);
        stud3 = new Student(578349754L, "Тестовый студент3", 5);
    }

    @Test
    public void save() throws Exception {
        stud1.save();
        List<Map<String, Object>> result = SQLExec.execute(new DbDriver(), ExecStatement.SQL_SELECT_STUDENTS_ALL_BYID, stud1.getId());
        Assert.assertEquals(result.get(0).get("last_name"), stud1.getLastName());
        Assert.assertEquals(result.get(0).get("score"), stud1.getScore());
    }

    @Test
    public void delete() throws Exception {
        stud2.save();
        stud2.delete();
        List<Map<String, Object>> result = SQLExec.execute(new DbDriver(), ExecStatement.SQL_SELECT_STUDENTS_ALL_BYID, stud2.getId());
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void update() throws Exception {
        stud3.save();
        stud3.setLastName("Измененный тестовый студент3");
        stud3.setScore(1);
        stud3.save();
        List<Map<String, Object>> result = SQLExec.execute(new DbDriver(), ExecStatement.SQL_SELECT_STUDENTS_ALL_BYID, stud3.getId());
        Assert.assertEquals(result.get(0).get("last_name"), stud3.getLastName());
        Assert.assertEquals(result.get(0).get("score"), stud3.getScore());
    }

    @Test(expected = ObjectNotFoundException.class)
    public void notFoundExceptionTest() throws Exception {
        new Student(4723847832487327L);
    }

    @AfterClass
    public static void endTest() {
        stud1.delete();
        stud2.delete();
        stud3.delete();
    }
}