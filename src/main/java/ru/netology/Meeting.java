package ru.netology;
/* Задача, описывающая назначенную встречу */

public class Meeting extends Task {
    protected String topic; // тема обсуждения
    protected String project; // название обсуждаемого проекта
    protected String start; // дата и время старта проекта

    public Meeting (int id, String topic, String project, String start) {
        super(id);  // вызов родительского конструктора
        this.topic = topic;  // заполнение своих полей
        this.project = project;  // заполнение своих полей
        this.start = start;  // заполнение своих полей
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public  String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}

