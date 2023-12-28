package Geeks.game;

import java.util.Random;

public class RPG_game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Amir");
        Warrior warrior1 = new Warrior(50, 15, "Timur");
        Warrior warrior2 = new Warrior(270, 15, "Raatbek");
        Medic doc = new Medic(250, 0, 15, "Leyla");
        Magic magic = new Magic(260, 20, "Bermet");
        Berserk berserk = new Berserk(260, 15, "Islam");
        Medic assistant = new Medic(300, 0, 5, "Imin");
        Witcher witcher = new Witcher(300,0,"Witcher");
        Thor imran = new Thor(200, 15, "Imran");
        Lucky lucky = new Lucky(200,5,"Lucky");
        Reaper lenora = new Reaper(300,10,"Lenora");
        Bomber bomber = new Bomber(100, 15,"Bomber");
        Hero[] heroes = {warrior1, warrior2,  magic, berserk, witcher ,imran, lenora, bomber, lucky, doc, assistant };

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}

