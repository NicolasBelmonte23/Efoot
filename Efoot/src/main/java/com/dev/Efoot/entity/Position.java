package com.dev.Efoot.entity;

public enum Position {

    GOALKEEPER("GoalKeeper"),
    DEFENDER("Defender"),
    FULLBACK("Fullback"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward");

    private final String label;

    Position(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

}
