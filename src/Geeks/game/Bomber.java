package Geeks.game;

public class Bomber extends Hero{
    public Bomber(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOMB, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() <= boss.getDamage()) {
            boss.setHealth(boss.getHealth() - 150);
            System.out.println("Bomber взорвался и нанес боссу 150 урона.");
        }
    }

}
