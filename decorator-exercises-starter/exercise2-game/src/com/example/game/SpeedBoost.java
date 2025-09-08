package com.example.game;

public class SpeedBoost extends CharacterDecorator{
    private int speed;
    public SpeedBoost(Character ch, int speed) {
        super(ch);
        this.speed = speed;
    }

    @Override
    public void move() {
        System.out.println("SpeedBoost Activated!!! " + getSpeed());

    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + this.speed;
    }
}