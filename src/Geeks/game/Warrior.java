package Geeks.game;

public class Warrior extends Hero{
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_game.random.nextInt(9) + 2;
        boss.setHealth(boss.getHealth() - coeff * this.getDamage());
        System.out.println("Warrior " + this.getName() + " hits critically " +
                coeff * this.getDamage());
    }
}
