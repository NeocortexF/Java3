package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл).
 * Написать тесты для проверки того, что при работе с базой корректно добавляются,
 * обновляются и читаются записи. Следует учесть что в базе есть заранее добавленные записи,
 * и после проведения тестов эти записи не должны быть удалены/именены/добавлены.
 */
public class Task3 {

    Students studentsDataBase = new Students();
    private static final Logger logger = Logger.getLogger(Task3.class.getName());

    final private void addDataToDB(int id, String name, int grade) {
        studentsDataBase.setId(id);
        studentsDataBase.setName(name);
        studentsDataBase.setGrade(grade);
        try {
            Handler h = new FileHandler("studentsDatabaseLog.log");
            h.setFormatter(new SimpleFormatter());
            logger.addHandler(h);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // хотел без БД сделать... что то нагородил огород =))
   //     logger.log(id, name, grade);
    }

    final private void updateDataIntoDB() {

    }

    final private void readDataFromDB() {

    }

}
