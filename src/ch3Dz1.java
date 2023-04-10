abstract class Metal {
    abstract int getEndurance();
}

class Steel extends Metal {
    @Override
    int getEndurance() {
        return 50;
    }
}

class Copper extends Metal {
    @Override
    int getEndurance() {
        return 20;
    }
}

class Iron extends Metal {
    @Override
    int getEndurance() {
        return 30;
    }
}

class Plastic {}

class Sword<T extends Metal> {
    private final T material;

    Sword(T material) {
        this.material = material;
    }

    boolean checkEndurance() {
        return material.getEndurance() > 49;
    }
}

public class ch3Dz1 {
    public static void main(String[] args) {
        // Меч из пластика создать не удастся
        // Sword<Plastic> plasticSword = new Sword<>(new Plastic());

        Sword<Steel> steelSword = new Sword<>(new Steel());
        System.out.println("Endurance check result: " + steelSword.checkEndurance());
        Sword<Copper> copperSword = new Sword<>(new Copper());
        System.out.println("Endurance check result: " + copperSword.checkEndurance());
    }
}
