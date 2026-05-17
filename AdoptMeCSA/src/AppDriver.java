import java.util.*;

public class AppDriver {
    
    private ShelterDayManager dayManager;
    private ArrayList<Pet> pets;
    private ArrayList<Adopter> adopters;

    public AppDriver() {
        this.dayManager = new ShelterDayManager();
        this.pets = new ArrayList<>();
        this.adopters = new ArrayList<>();
    }

        public void readPetsFromFile(String filename) {


            try (Scanner fileScanner = new Scanner(new java.io.File(filename))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine().trim();
                    if (line.isEmpty()) {
                        continue;
                    }

                    String[] parts = line.split(",");
                    if (parts.length < 14) {
                            Pet pet = new Pet(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2]),
                            parts[3],
                            parts[4]
                        );
                        pets.add(pet);
                    } else if (parts.length == 14) {
                         Pet pet = new Pet(
                            parts[0],
                            parts[1],
                            parts[2],
                            Integer.parseInt(parts[3]),
                            parts[4],
                            parts[5],
                            Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[7]),
                            Boolean.parseBoolean(parts[8]),
                            Boolean.parseBoolean(parts[9]),
                            Boolean.parseBoolean(parts[10]),
                            Boolean.parseBoolean(parts[11]),
                            Boolean.parseBoolean(parts[12]),
                            parts[13]
                        );
                        pets.add(pet);
                    } else {
                        System.out.println("Skipping line with unexpected number of columns: " + line);
                    }

                    try {

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping line with invalid format: " + line);
                    }
                }

                System.out.println("Loaded " + pets.size() + " pets from file.");
            } catch (Exception e) {
                System.out.println("Error reading pet data: " + e.getMessage());
            }
            pets = MergeSortHelper.sortByUrgency(pets);

            
        }
    }