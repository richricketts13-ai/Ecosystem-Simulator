import java.util.List;

public class Rabbit extends Organism {

    private final String trait;

    public Rabbit(String name, int energy, String trait) {
        super(name, energy);
        this.trait = trait;
    }

    @Override
    public void act(List<Organism> world, List<Organism> newBorns) {

        for (Organism organism : world) {
            
            if (organism instanceof Grass && organism.isAlive()) { 

                if (this.trait.equals("Efficient")) {

                    this.setEnergy(this.getEnergy() + 7); // Gain more energy from eating grass if efficient
                    System.out.println(this.getName() + " efficiently eats " + organism.getName() + " and gains more energy!");
                    
                } else {
                    this.setEnergy(this.getEnergy() + 5); // Gain energy from eating grass
                    System.out.println(this.getName() + " eats " + organism.getName() + " and gains energy!");

                }
                organism.setAlive(false); // Grass is eaten and dies
                break;
            }
        }


        if (this.trait.equals("Cautious")) {

            this.setEnergy(this.getEnergy() - 0); // Lose less energy from moving if cautious
            System.out.println("" + this.getName() + " cautiously moves and loses less energy. Current energy: " + this.getEnergy());
        } else {

        this.setEnergy(this.getEnergy() - 1); // Lose energy from moving
        System.out.println("" + this.getName() + " moves and loses energy. Current energy: " + this.getEnergy());
        }

        if (this.getEnergy() >= 18) { // Reproduce if energy is high enough

            this.setEnergy(this.getEnergy() - 6); // Lose energy from reproducing
            System.out.println("" + this.getName() + " reproduces and loses energy. Current energy: " + this.getEnergy());

            Rabbit offspring = new Rabbit(this.getName() + "_offspring", 10, this.trait); // Create offspring with initial energy
            System.out.println("" + this.getName() + " produces an offspring: " + offspring.getName() + " with trait: " + offspring.trait);

            newBorns.add(offspring); // Add offspring to the list of new organisms
            
        }

        if (this.getEnergy() <= 0) {
                this.setAlive(false); // Rabbit dies if energy drops to 0 or below  
                System.out.println(this.getName() + " has died due to lack of energy.");
            }
    }


    public String getTrait() {
        return trait;
    }



































}   



