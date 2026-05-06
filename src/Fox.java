import java.util.List;
public class Fox extends Organism {

    public Fox(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void act(List<Organism> world, List<Organism> newBorns) {

        Rabbit rabbit = null;

        this.setEnergy(this.getEnergy() - 2);

        for (Organism organism : world) {
            if (organism instanceof Rabbit && organism.isAlive()) {
                rabbit = (Rabbit) organism;
                break;
            }
        }

        if (rabbit != null) {
            this.setEnergy(this.getEnergy() + 5); // Gain energy from eating rabbit

            rabbit.setAlive(false); // Rabbit is eaten and dies
        } else {
            this.setEnergy(this.getEnergy() - 3); // Lose energy from moving    
        }

        if (this.getEnergy() <= 0) {
            
            this.setAlive(false);
        }
    }

}
