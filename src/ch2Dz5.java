 class Character {
    protected String name;
    protected int strength;
    protected int health;
    protected int defense;

    public Character(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name + ".");
    }

    public void attack(Character target) {
        int damage = strength - target.defense;
        target.health -= damage;
        System.out.println(name + " attacked " + target.name + " for " + damage + " damage.");
        System.out.println("Now " + target.name + " health = " + target.health);
    }
}

class Wizard extends Character {
    private int mana;
    private int intelligence;

    protected int manaCost;
    public Wizard(String name, int mana) {
        super(name);
        this.mana = mana;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void greet() {
        System.out.println("Greetings, I am " + name + " the wizard.");
    }

    @Override
    public void attack(Character target) {
        int damage = intelligence * 2 - target.defense;
        target.health -= damage;
        mana -= manaCost;
        System.out.println(name + " cast a spell on " + target.name + " for " + damage + " damage.");
    }
}
class Archer extends Character {
    private int archerySkill;

    public Archer(String name, int archerySkill) {
        super(name);
        this.archerySkill = archerySkill;
    }

    public int getArcherySkill() {
        return archerySkill;
    }

    public void setArcherySkill(int archerySkill) {
        this.archerySkill = archerySkill;
    }

    @Override
    public void greet() {
        System.out.println("Hail, I am " + name + " the archer.");
    }

    @Override
    public void attack(Character target) {
        int damage = archerySkill + strength - target.defense;
        target.health -= damage;
        System.out.println(name + " fired an arrow at " + target.name + " for " + damage + " damage.");
    }
}

class CharacterCreationException extends RuntimeException {
    public CharacterCreationException(String message) {
        super(message);
    }
}

class Tester extends Character {
    public Tester(String name) {
        super(name);
        if (!"Test".equals(name)) {
            throw new CharacterCreationException("Only testers can create tester characters with name 'Test'.");
        }
    }

    @Override
    public void greet() {
        System.out.println("I'm " + name + " and I'm testing this game.");
    }

    @Override
    public void attack(Character target) {
        System.out.println("I'm not supposed to attack anyone. I'm just testing.");
    }
}


public class ch2Dz5 {
    public static void main(String[] args) {
        Archer Legolas = new Archer("Legolas", 15);
            Legolas.setStrength(10);
            Legolas.setDefense(12);
            Legolas.setHealth(100);
            Legolas.greet();
        Character Orc = new Character("Orc") ;
            Orc.setStrength(30);
            Orc.setDefense(15);
            Orc.setHealth(50);
        Wizard Merlin = new Wizard("Merlin", 50);
            Merlin.setHealth(100);
            Merlin.setDefense(5);
            Merlin.setIntelligence(20);
            Merlin.setManaCost(10);
            Merlin.greet();
        Legolas.attack(Orc);
        Merlin.attack(Orc);
        Orc.attack(Merlin);
        Tester Guy = new Tester("Test");
        Guy.greet();
        Tester NoName = new Tester("TasteR");
    }
}
