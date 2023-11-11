package com.example.authdemo.model.enums;

public enum UserRole {
    STUDENTE,
    TUTORE;

    @Override
    public String toString() {
        return this.name();
    }
}
