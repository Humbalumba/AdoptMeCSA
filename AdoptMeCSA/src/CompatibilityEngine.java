/**
 * CompatibilityEngine — calculates match scores between a Pet and an Adopter.
 *
 * Score is out of 100. Hard disqualifiers return -1 (incompatible).
 * The shelter mood modifier scales final scores when mood is low.
 */
public class CompatibilityEngine {

    // Experience level rankings for comparison
    private static final String[] EXP_LEVELS = {"Beginner", "Intermediate", "Experienced"};

    /**
     * Main scoring method. Returns -1 if the pair is fundamentally incompatible,
     * otherwise returns a score from 0.0 to 100.0.
     *
     * @param pet          the pet being matched
     * @param adopter      the adopter being evaluated
     * @param shelterMood  current shelter mood (0.0–100.0), affects score scaling
     * @return compatibility score, or -1 if incompatible
     */
    public static double score(Pet pet, Adopter adopter, double shelterMood) {

        // ── Hard disqualifiers ────────────────────────────────────────────────
        // Allergy conflict
        if (adopter.hasAllergies() && adopter.getAllergyType().equalsIgnoreCase(pet.getSpecies())) {
            return -1;
        }
        // Pet needs more experience than adopter has
        if (experienceRank(pet.getExperienceRequired()) > experienceRank(adopter.getExperienceLevel())) {
            return -1;
        }
        // Special needs pet, adopter can't handle it
        if (pet.hasSpecialNeeds() && !adopter.canHandleSpecialNeeds()) {
            return -1;
        }
        // Adopter's age preference
        if (pet.getAge() > adopter.getPreferredAgeMax()) {
            return -1;
        }
        // Kids in home but pet isn't good with kids
        if (adopter.hasChildren() && !pet.isGoodWithKids()) {
            return -1;
        }
        // Adopter owns a dog but pet isn't good with dogs
        if (adopter.ownsDog() && !pet.isGoodWithDogs()) {
            return -1;
        }
        // Adopter owns a cat but pet isn't good with cats
        if (adopter.ownsCat() && !pet.isGoodWithCats()) {
            return -1;
        }

        // ── Base score ────────────────────────────────────────────────────────
        double score = 40.0; // starts at 40 for passing disqualifiers

        // Species match
        if (adopter.getPreferredSpecies().equalsIgnoreCase("Any") ||
            adopter.getPreferredSpecies().equalsIgnoreCase(pet.getSpecies())) {
            score += 15.0;
        }

        // Energy level match
        if (adopter.getPreferredEnergyLevel().equalsIgnoreCase("Any") ||
            adopter.getPreferredEnergyLevel().equalsIgnoreCase(pet.getEnergyLevel())) {
            score += 10.0;
        }

        // Size preference
        if (adopter.getPreferredSize().equalsIgnoreCase("Any") ||
            adopter.getPreferredSize().equalsIgnoreCase(pet.getSizeCategory())) {
            score += 8.0;
        }

        // Vaccinated bonus
        if (pet.isVaccinated()) score += 5.0;

        // Neutered bonus
        if (pet.isNeutered()) score += 3.0;

        // Subclass-specific bonus (polymorphism)
        score += pet.computeCompatibilityBonus(adopter);

        // ── Shelter mood modifier ─────────────────────────────────────────────
        // If mood is below 50, scale score down slightly (stressed shelter = worse outcomes)
        if (shelterMood < 50.0) {
            double moodPenalty = (50.0 - shelterMood) / 50.0 * 10.0;
            score -= moodPenalty;
        }

        return Math.max(0.0, Math.min(100.0, score));
    }

    /**
     * Estimates the probability that this match will result in a return.
     * Higher score = lower return risk.
     *
     * @param compatibilityScore from score()
     * @param shelterMood        current mood
     * @return return risk probability between 0.0 and 1.0
     */
    public static double estimateReturnRisk(double compatibilityScore, double shelterMood) {
        double base = 1.0 - (compatibilityScore / 100.0);
        double moodFactor = (100.0 - shelterMood) / 200.0; // mood adds up to 0.5 extra risk
        return Math.min(1.0, base + moodFactor);
    }

    /**
     * Converts experience level string to a numeric rank for comparison.
     */
    private static int experienceRank(String level) {
        for (int i = 0; i < EXP_LEVELS.length; i++) {
            if (EXP_LEVELS[i].equalsIgnoreCase(level)) return i;
        }
        return 0;
    }
}
