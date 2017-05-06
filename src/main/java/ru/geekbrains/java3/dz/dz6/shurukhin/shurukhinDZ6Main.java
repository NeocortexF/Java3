package ru.geekbrains.java3.dz.dz6.shurukhin;

import ru.geekbrains.java3.dz.dz6.shurukhin.DB.Student;

import java.util.Arrays;

/**
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный
 * целочисленный массив, метод должен вернуть новый массив, который получен путем
 * вытаскивания элементов из исходного массива, идущих после последней четверки. Входной
 * массив должен содержать хотя бы одну четверку, в противном случае в методе необходимо
 * выбросить RuntimeException.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 * 2. Написать метод, который проверяет что массив состоит только из чисел 1 и 4. Если в массиве
 * нет хоть одной 4 или 1, то метод вернет false;
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * 3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для
 * проверки того, что при работе с базой корректно добавляются, обновляются и читаются
 * записи. Следует учесть что в базе есть заранее добавленные записи, и после проведения
 * тестов эти записи не должны быть удалены/именены/добавлены.
 */
class shurukhinDZ6Main {
    public static void main(String[] args) {
        //Задание 1
        //System.out.println(Arrays.toString(cutAfterFour(new Integer[]{1, 2, 1, 3, 2, 3, 8, 1, 7})));

        //Задание 2
        //System.out.println(isFoursAndOnes(new Integer[]{1, 2, 1, 3, 3, 3, 8, 1, 7}));

        //Задание 3
        //Заполняем таблицу
        Student stud1 = new Student(1L, "Тест1", 5);
        stud1.save();

        Student stud2 = new Student(2L, "Тест2", 3);
        stud2.save();

        Student stud3 = new Student(1L); //Поиск уже существующего студента в базе
        System.out.println(stud3.getLastName());

        stud2.delete();
    }

    static Integer[] cutAfterFour(Integer[] arr) {
        if (Arrays.stream(arr).noneMatch(e -> e == 4)) throw new RuntimeException("Входной массив не содержит четверок");
        return Arrays.copyOfRange(arr, Arrays.asList(arr).lastIndexOf(4) + 1, arr.length);
    }

    static boolean isFoursAndOnes(Integer[] arr) {
        return !(Arrays.stream(arr).noneMatch(e -> e == 4) || Arrays.stream(arr).noneMatch(e -> e == 1));
    }


}
