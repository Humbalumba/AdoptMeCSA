/**
 * Represents a pet in the shelter with basic attributes used by the
 * matching and scheduling systems.
 * @author Aarush P, Vidarth A
 */
public class Pet {

    //pet info
	private String name;
	private String species;
	private String breed;
	private int age;
	private String sizeCategory;
	private String energyLevel; 
	private boolean vaccinated;
	private boolean neutered;
	private boolean specialNeeds;
	private String specialNeedsDescription;
	private boolean goodWithKids;
	private boolean goodWithDogs;
	private boolean goodWithCats;
	private String experienceRequired;

	// Shelter-specific
	private int daysInShelter;
	private int urgencyScore; 

	//compatibility score 
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

	/**
	 * Makes a Pet from a CSV row with the following columns:
	 * name,species,breed,age,energyLevel,specialNeeds,daysInShelter,urgencyScore,
	 * isVaccinated,isNeutered,goodWithKids,goodWithDogs,goodWithCats,experienceRequired
	 */
	public Pet(String name,
			   String species,
			   String breed,
			   int age,
			   String energyLevel,
			   String specialNeedsDescription,
			   int daysInShelter,
			   int urgencyScore,
			   boolean isVaccinated,
			   boolean isNeutered,
			   boolean goodWithKids,
			   boolean goodWithDogs,
			   boolean goodWithCats,
			   String experienceRequired) {
		this();
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.energyLevel = energyLevel;
		this.specialNeedsDescription = specialNeedsDescription;
		this.specialNeeds = specialNeedsDescription != null && !specialNeedsDescription.equalsIgnoreCase("None");
		this.daysInShelter = daysInShelter;
		this.urgencyScore = urgencyScore;
		this.vaccinated = isVaccinated;
		this.neutered = isNeutered;
		this.goodWithKids = goodWithKids;
		this.goodWithDogs = goodWithDogs;
		this.goodWithCats = goodWithCats;
		this.experienceRequired = experienceRequired;
	}

	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSpecies() { return species; }
	public void setSpecies(String species) { this.species = species; }

	public String getBreed() { return breed; }
	public void setBreed(String breed) { this.breed = breed; }

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

	public String getSpecialNeedsDescription() { return specialNeedsDescription; }
	public void setSpecialNeedsDescription(String desc) {
		this.specialNeedsDescription = desc;
		this.specialNeeds = desc != null && !desc.equalsIgnoreCase("None");
	}

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
