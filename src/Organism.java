import java.util.List;
import java.util.Random;

public class Organism {

    private final String name;
    private int energy;
    private boolean alive;
    private final Random random;
    private  int x; // X-coordinate for movement
    private  int y; // Y-coordinate for movement
   

    public Organism(String name, int energy) {
        this.name = name;
        this.energy = energy;
        this.alive = true;
        this.random = new Random();
        this.x = this.random.nextInt(21); // Random initial X position 0-20
        this.y = this.random.nextInt(21); // Random initial Y position 0-20
    }

    //Methods
    public void act(List<Organism> world, List<Organism> newBorns) {

    }

    public boolean isAlive() {
        return alive;
    }

    public void move() {
        this.x = x + random.nextInt(3) - 1; // Random movement in the X direction
        this.y = y + random.nextInt(3) - 1; // Random movement in the Y direction

        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x > 20) {
            x = 20;
        }
        if (y > 20) {
            y = 20;
        }
    }


    public boolean nearby(Organism other) {
       if (Math.abs(this.x - other.getX()) <= 1 && Math.abs(this.y - other.getY()) <= 1) {
           return true;
       } else {
           return false;
       }
    }



    //Getters and Setters

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }
    public int getX() {
        return x;
    } 
    public int getY() {
        return y;
    }   

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

       

    
}
