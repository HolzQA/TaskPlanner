package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentTypes() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(14, "Поздравить папу с днем рождения");
        String query = "с днем рождения";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInEpic() {
        String[] subtasks = { "Оплатить счета", "Забрать вещи из ремонта", "Позвонить Юле" };
        Epic epic = new Epic(23, subtasks);
        String query = "Забрать вещи";

        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInMeeting() {
        Meeting meeting = new Meeting(
                45,
                "Петя - поступление в ВУЗ",
                "Образование детей",
                "Суббота в 16");
        String query = "Петя";

        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByQueryInAllTasksList() {
        SimpleTask simpleTask = new SimpleTask(15, "Купить продукты");

        String[] subtasks = { "Убраться", "Помыться", "Приготовить еду" };
        Epic epic = new Epic(24, subtasks);

        Meeting meeting = new Meeting(
                46,
                "Выбираем марку и цвет машины",
                "Купить новую машину",
                "Воскрсенье с 18 до 20"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Купить";

        Task[] expected = { simpleTask, meeting };
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}
