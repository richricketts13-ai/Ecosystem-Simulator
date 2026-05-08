import java.util.List;
import java.util.Random;
public class Grass extends Organism {

    private static final Random random = new Random();

    public Grass(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void act(List<Organism> world, List<Organism> newBorns) {

        int growthChance = random.nextInt(100);

        if (growthChance < 15) { // 15% chance to grow
            Grass newGrass = new Grass(this.getName() + "_offspring", 5); // Create new grass with initial energy
            newBorns.add(newGrass); // Add new grass to the list of new organisms
        }

    }
    
}