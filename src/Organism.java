import java.util.List;

public class Organism {

    private final String name;
    private int energy;
    private boolean alive;

    public Organism(String name, int energy) {
        this.name = name;
        this.energy = energy;
        this.alive = true;
    }

    //Methods
    public void act(List<Organism> world, List<Organism> newBorns) {

    }

    public boolean isAlive() {
        return alive;
    }


    //Getters and Setters

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }



    
}
