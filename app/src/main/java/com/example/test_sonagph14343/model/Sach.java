package com.example.test_sonagph14343.model;

public class Sach {
    private  int ID;
    private String Name;
    private String Email;

    public Sach() {
    }

    public Sach(int ID, String name, String email) {
        this.ID = ID;
        Name = name;
        Email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
