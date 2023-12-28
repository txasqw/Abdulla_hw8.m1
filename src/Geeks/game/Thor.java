package Geeks.game;

import java.util.Random;

public class Thor extends Hero{
    public Thor(int health, int damage,  String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random imran = new Random();
        boolean amir = imran.nextBoolean();
        if (amir){
            boss.setDamage(0);
            System.out.println("Тор оглушил босса");
        } else {
            boss.setDamage(50);
        }
    }
}

