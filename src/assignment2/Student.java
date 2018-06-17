package com.company;

public class Student {
    private Question[] questions;
    private Node currentNode;


    public Student(Question[] questions, Node currentNode) {
        this.questions = questions;
        this.currentNode = currentNode;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }
}