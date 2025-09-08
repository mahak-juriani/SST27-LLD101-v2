package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private int speed = 5;
    private int damage = 10;
    public GoldenAura(Character ch) {
        super(ch);
    }

    @Override
    public void move() {
        System.out.println("Golden Aura Moving at speed: " + getSpeed() + " with sprite: " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("Golden Aura Attacking with damage: " + getDamage() + " using sprite: " + getSprite());
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + this.speed;
    }

    @Override
    public int getDamage() {
        return super.getDamage()+this.damage;
    }

    @Override
    public String getSprite() {
        return super.getSprite();
    }
}