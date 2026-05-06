import java.util.List;

public class Rabbit extends Organism {

    public Rabbit(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void act(List<Organism> world, List<Organism> newBorns) {

        for (Organism organism : world) {
            
            if (organism instanceof Grass && organism.isAlive()) {
                this.setEnergy(this.getEnergy() + 5); // Gain energy from eating grass
                organism.setAlive(false); // Grass is eaten and dies
                break;
            }
        }

        this.setEnergy(this.getEnergy() - 1); // Lose energy from moving

        if (this.getEnergy() >= 18) { // Reproduce if energy is high enough

            this.setEnergy(this.getEnergy() - 6); // Lose energy from reproducing

            Rabbit offspring = new Rabbit(this.getName() + "_offspring", 10); // Create offspring with initial energy

            newBorns.add(offspring); // Add offspring to the list of new organisms
            
        }

        if (this.getEnergy() <= 0) {
                this.setAlive(false); // Rabbit dies if energy drops to 0 or below
            }

    }



































}   



