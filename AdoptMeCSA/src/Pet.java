/**
 * Represents a pet in the shelter with basic attributes used by the
 * matching and scheduling systems.
 * @author Aarush P, Vidarth A
 */
public class Pet {

    //pet info
	private String name;
	private String species;
	private int age;
	private String sizeCategory;
	private String energyLevel; 
	private boolean vaccinated;
	private boolean neutered;
	private boolean specialNeeds;
	private boolean goodWithKids;
	private boolean goodWithDogs;
	private boolean goodWithCats;
	private String experienceRequired;

	// Shelter-specific
	private int daysInShelter;
	private int urgencyScore; // 0-10

	//compatibility score (0.0 - 100.0)
	private double compatibilityScore;

	public Pet() {
		this.name = "";
		this.species = "Unknown";
		this.age = 0;
		this.sizeCategory = "Medium";
		this.energyLevel = "Medium";
		this.vaccinated = false;
		this.neutered = false;
		this.specialNeeds = false;
		this.goodWithKids = true;
		this.goodWithDogs = true;
		this.goodWithCats = true;
		this.experienceRequired = "Beginner";
		this.daysInShelter = 0;
		this.urgencyScore = 0;
		this.compatibilityScore = 0.0;
	}

	public Pet(String name, String species, int age, String sizeCategory, String energyLevel) {
		this();
		this.name = name;
		this.species = species;
		this.age = age;
		this.sizeCategory = sizeCategory;
		this.energyLevel = energyLevel;
	}

	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSpecies() { return species; }
	public void setSpecies(String species) { this.species = species; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	public String getSizeCategory() { return sizeCategory; }
	public void setSizeCategory(String sizeCategory) { this.sizeCategory = sizeCategory; }

	public String getEnergyLevel() { return energyLevel; }
	public void setEnergyLevel(String energyLevel) { this.energyLevel = energyLevel; }

	public boolean isVaccinated() { return vaccinated; }
	public void setVaccinated(boolean vaccinated) { this.vaccinated = vaccinated; }

	public boolean isNeutered() { return neutered; }
	public void setNeutered(boolean neutered) { this.neutered = neutered; }

	public boolean hasSpecialNeeds() { return specialNeeds; }
	public void setSpecialNeeds(boolean specialNeeds) { this.specialNeeds = specialNeeds; }

	public boolean isGoodWithKids() { return goodWithKids; }
	public void setGoodWithKids(boolean goodWithKids) { this.goodWithKids = goodWithKids; }

	public boolean isGoodWithDogs() { return goodWithDogs; }
	public void setGoodWithDogs(boolean goodWithDogs) { this.goodWithDogs = goodWithDogs; }

	public boolean isGoodWithCats() { return goodWithCats; }
	public void setGoodWithCats(boolean goodWithCats) { this.goodWithCats = goodWithCats; }

	public String getExperienceRequired() { return experienceRequired; }
	public void setExperienceRequired(String experienceRequired) { this.experienceRequired = experienceRequired; }

	public int getDaysInShelter() { return daysInShelter; }
	public void setDaysInShelter(int days) { this.daysInShelter = days; }
	public void incrementDaysInShelter() { this.daysInShelter++; }

	public int getUrgencyScore() { return urgencyScore; }
	public void setUrgencyScore(int score) { this.urgencyScore = score; }


	public double getCompatibilityScore() { return compatibilityScore; }
	public void setCompatibilityScore(double score) { this.compatibilityScore = score; }

	public double computeCompatibilityBonus(Adopter adopter) {
		return 0.0;
	}

	public String toString() {
		return String.format( "Name: " + name + ", Species: " + species + ", Age: " + age);
	}
}
