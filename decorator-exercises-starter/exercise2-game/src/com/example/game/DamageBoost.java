package com.example.game;

public class DamageBoost extends CharacterDecorator{
    private int damage;
    public DamageBoost(Character ch, int damage) {
        super(ch);
        this.damage = damage;
    }

    @Override
    public void attack() {
        System.out.println("Damage Boosted Attack!!! " + getDamage());
    }


    @Override
    public int getDamage() {
        return super.getDamage()+ this.damage;
    }

    
}