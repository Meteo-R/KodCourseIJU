package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Participant implements Observable {
    private Observer mentor;
    private final Deque<String> tasks;
    private final String name;

    public Participant(String name, Observer mentor) {
        this.mentor = mentor;
        tasks = new ArrayDeque<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        mentor.update(this);
    }

    @Override
    public void changeObserver(Observer newMentor) {
        this.mentor = newMentor;
    }

    public Observer getMentor() {
        return mentor;
    }

    public Deque<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
