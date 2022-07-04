package fr.univlyon.tianegociation.model;

import java.util.Objects;

public class Message {

    private int idSender;
    private int idReceiver;
    private String subject;

    private Position toFree;

    public Message(int idSender, int idReceiver, String subject, Position toFree) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.subject = subject;
        this.toFree = toFree;
    }

    public Message() {
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Position getToFree() {
        return toFree;
    }

    public void setToFree(Position toFree) {
        this.toFree = toFree;
    }

    @Override
    public String toString() {
        return "Message{" +
                "idSender=" + idSender +
                ", idReceiver=" + idReceiver +
                ", subject='" + subject + '\'' +
                ", toFree=" + toFree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getIdSender() == message.getIdSender() && getIdReceiver() == message.getIdReceiver() && Objects.equals(getSubject(), message.getSubject()) && Objects.equals(getToFree(), message.getToFree());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSender(), getIdReceiver(), getSubject(), getToFree());
    }
}
