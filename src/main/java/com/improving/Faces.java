package com.improving;

public enum Faces {
    Zero(0),
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Reverse(20),
    Skip(20),
    DrawTwo(20),
    WILD(50),
    WILD_DrawFour(50);

    private final int value;

    Faces(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
