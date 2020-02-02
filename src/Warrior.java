import java.util.ArrayList;
import java.util.List;

public class Warrior {

    /* See resources/WarriorRequirements.txt for full problem description */

    public enum Rank {

        Default(-1),
        Pushover(0),
        Novice(10),
        Fighter(20),
        Warrior(30),
        Veteran(40),
        Sage(50),
        Elite(60),
        Conqueror(70),
        Champion(80),
        Master(90),
        Greatest(100);

        private Integer level;

        Rank(final Integer level) {
            this.level = level;
        }

        private int getLevel() {
            return this.level;
        }

        public Rank setRankByLevel(int level) {
            Rank newLevel = Default;
            for (Rank r : this.values()) {

                if (r.getLevel() == level - (level % 10)) {
                    newLevel = r;
                }
            }
            return newLevel;
        }
    }

    private int level = 1;
    private int experience = 100;
    private Rank rank = Rank.Pushover;
    private List<String> achievements = new ArrayList<>();

    public Warrior() {
    }

    public String training(String desc, int exp, int minLevel) {
        if (level <= 100 && level >= minLevel && minLevel > 0) {
            achievements.add(desc);
            experience = experience + exp > 10000 ? 10000 : experience + exp;
            level = experience / 100;
            rank = rank.setRankByLevel(level);
            return desc;
        } else {
            return "Not strong enough";
        }
    }

    public String battle(int enemyLevel) {

        String out = "";
        int diff = enemyLevel > level ? enemyLevel - level : level - enemyLevel;

        if (enemyLevel > 0 && enemyLevel <= 100) {
            if (level > enemyLevel && diff >= 2) {
                out = "Easy fight";
            } else if (level >= enemyLevel && (diff == 1 || diff == 0)) {
                out = "A good fight";
                rankUp(enemyLevel, diff);

            } else if (level < enemyLevel) {
                if (enemyLevel - (enemyLevel % 10) != rank.getLevel() && diff >= 5) {
                    out = "You've been defeated";
                } else if (enemyLevel - (enemyLevel % 10) != rank.getLevel() && diff < 5) {
                    out = "An intense fight";
                    rankUp(enemyLevel, diff);
                } else {
                    out = "An intense fight";
                    rankUp(enemyLevel, diff);
                }
            }
        } else {
            out = "Invalid level";
        }
        return out;
    }

    private void rankUp(int enemyLevel, int diff) {
        if (level <= 100) {
            if (level == enemyLevel) {
                experience = experience + 10 > 10000 ? 10000 : experience + 10;
                level = experience / 100;
                rank = rank.setRankByLevel(level);
            } else if (level - enemyLevel == 1) {
                experience = experience + 5 > 10000 ? 10000 : experience + 5;
                level = experience / 100;
                rank = rank.setRankByLevel(level);
            } else if (level + 1 <= enemyLevel) {
                experience = experience + (20 * (diff * diff)) > 10000 ? 10000 : experience + (20 * (diff * diff));
                level = experience / 100;
                rank = rank.setRankByLevel(level);
            }
        }
    }

    public int level() {
        return this.level;
    }

    public int experience() {
        return this.experience;
    }

    public String rank() {
        return rank.toString();
    }

    public List<String> achievements() {
        return this.achievements;
    }

}