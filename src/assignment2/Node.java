package com.company;


public class Node {
    Question question;
    Node yesNode; //YES
    Node noNode; //NO

    int id; //for debugging

    String decision;


    public Node(Question question) {
        this.question = question;
    }

    public Node() {

    }

    public Node getYesNode() {
        return yesNode;
    }

    public void setYesNode(Node yesNode) {
        this.yesNode = yesNode;
    }

    public Node getNoNode() {
        return noNode;
    }

    public void setNoNode(Node noNode) {
        this.noNode = noNode;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public boolean isTerminalNode() {
        if (yesNode == null && noNode == null) {
            return true;
        }
        return false;
    }
}