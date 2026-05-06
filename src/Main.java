import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Organism> world = new ArrayList<>();

        
        world.add(new Grass("Grass1", 5));
        world.add(new Grass("Grass2", 5));
        world.add(new Grass("Grass3", 5));
        world.add(new Grass("Grass4", 5));
        world.add(new Grass("Grass5", 5));   
        world.add(new Grass("Grass6", 5));
        world.add(new Grass("Grass7", 5));
        world.add(new Grass("Grass8", 5));
        world.add(new Grass("Grass9", 5));
        world.add(new Grass("Grass10", 5));   

        world.add(new Rabbit("Rabbit1", 10));
        world.add(new Rabbit("Rabbit2", 10));
        world.add(new Rabbit("Rabbit3", 10));
        world.add(new Rabbit("Rabbit4", 10));
        world.add(new Rabbit("Rabbit5", 10));

        world.add(new Fox("Fox1", 12));
        world.add(new Fox("Fox2", 12));

        int round = 1;
        

        while (!world.isEmpty() && round < 20) {

             int rabbitCount = 0;
             int foxCount = 0;
             int grassCount = 0;
           
            System.out.println("Round " + round);

            List<Organism> newBorns = new ArrayList<>();
            List<Organism> toRemove = new ArrayList<>();

            for (Organism organism : world) {

                organism.act(world, newBorns);



                if (!organism.isAlive()) {
                    toRemove.add(organism);
                } else {
                    if (organism instanceof Rabbit) {
                        rabbitCount++;
                    }
                    if (organism instanceof Fox) {
                        foxCount++;
                    }
                    if (organism instanceof Grass) {
                        grassCount++;
                    }
                }
            }

           
            world.addAll(newBorns); 
            world.removeAll(toRemove);

            System.out.println("End of round " + round);
            System.out.println("Rabbits currently: " + rabbitCount);
            System.out.println("Foxes currently: " + foxCount);  
            System.out.println("Grass currently: " + grassCount); 
                
            round++;

        }
        int finalRabbitCount = 0;
        int finalFoxCount = 0;
        int finalGrassCount = 0;

        for (Organism organism : world) {
            if (organism instanceof Rabbit) {
                finalRabbitCount++;
            }
            if (organism instanceof Fox) {
                finalFoxCount++;
            }
            if (organism instanceof Grass) {
                finalGrassCount++;
            }
        }
        System.out.println("Simulation Summary after " + round + " rounds.");
        System.out.println("Final Rabbit Count: " + finalRabbitCount);
        System.out.println("Final Fox Count: " + finalFoxCount);
        System.out.println("Final Grass Count: " + finalGrassCount);
    }
}