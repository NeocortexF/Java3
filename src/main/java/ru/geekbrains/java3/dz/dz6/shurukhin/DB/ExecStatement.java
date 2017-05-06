package ru.geekbrains.java3.dz.dz6.shurukhin.DB;

/**
 * Интерфес списка запросов
 */
interface ExecStatement {
    DbDriver driver = new DbDriver();
    String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS students_ksh\n" +
            "(\n" +
            "  id bigint NOT NULL,\n" +
            "  last_name character varying(255),\n" +
            "  score integer,\n" +
            "  CONSTRAINT students_ksh_pkey PRIMARY KEY (id)\n" +
            ")\n" +
            "WITH (\n" +
            "  OIDS=FALSE\n" +
            ");\n" +
            "ALTER TABLE students_ksh\n" +
            "  OWNER TO postgres;";
    String SQL_SELECT_STUDENTS_ALL_BYID = "SELECT * FROM students_ksh WHERE id = ?";
    String SQL_INSERT_STUDENTS = "INSERT INTO students_ksh(id, last_name, score) VALUES(?, ?, ?)";
    String SQL_UPDATE_STUDENTS = "UPDATE students_ksh SET last_name = ?, score = ? where id = ?";
    String SQL_DELETE_STUDENT = "DELETE FROM students_ksh WHERE id = ?";
}
