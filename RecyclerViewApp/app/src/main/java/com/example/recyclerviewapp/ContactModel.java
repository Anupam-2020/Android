package com.example.recyclerviewapp;

public class ContactModel {
    int img;
    String name, number;

    public ContactModel(int image, String name, String number) {
        this.name = name;
        this.number = number;
        img = image;
    }
}
