package com.example.game;

public abstract class CharacterDecorator implements Character{
    private Character ch;
    public CharacterDecorator(Character ch){
        this.ch = ch;
    }

    @Override
    public void move() {
        ch.move();
    }

    @Override
    public void attack() {
        ch.attack();
    }

    @Override
    public int getSpeed() {
        return ch.getSpeed();
    }

    @Override
    public int getDamage() {
        return ch.getDamage();
    }

    @Override
    public String getSprite() {
        return ch.getSprite();
    }
}