package com.akhtaraf.assignment2.model;

public enum PetType {
    DOG, CAT, RABBIT;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
