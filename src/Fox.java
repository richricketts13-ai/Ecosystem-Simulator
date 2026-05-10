import java.util.List;
import java.util.Random;
public class Fox extends Organism {

    private static final Random random = new Random();

    public Fox(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void act(List<Organism> world, List<Organism> newBorns) {

        Rabbit rabbit = null;
        
        move();
        this.setEnergy(this.getEnergy() - 2);
        System.out.println(this.getName() + " moves to (" + this.getX() + ", " + this.getY() + ") and loses energy. Current energy: " + this.getEnergy());
       

        for (Organism organism : world) {
            if (organism instanceof Rabbit && organism.isAlive() && nearby(organism)) {
                rabbit = (Rabbit) organism;
                break;
            }
        }
         
        if (rabbit != null) {
        int successChance = random.nextInt(100);

         if (successChance < 70) { // 70% chance to successfully catch the rabbit
            this.setEnergy(this.getEnergy() + 3); // Gain energy from eating rabbit
            rabbit.setAlive(false); // Rabbit is eaten and dies
            System.out.println(this.getName() + " successfully catches and eats " + rabbit.getName() +"at (" + rabbit.getX() + ", " + rabbit.getY() + ") and gains energy! Current energy: " + this.getEnergy()); 
         } else {
            System.out.println(this.getName() + " fails to catch " + rabbit.getName() + ".");
            this.setEnergy(this.getEnergy() - 1); // Lose additional energy from failing to catch the rabbit
         }
         
     }  else {
            System.out.println(this.getName() + " fails to find a rabbit to eat.");
            this.setEnergy(this.getEnergy() - 1); // Lose additional energy from failing to find food
        }
     if (this.getEnergy() <= 0) {

        this.setAlive(false);
        System.out.println(this.getName() + " has died due to lack of energy.");

        }
    }

}
