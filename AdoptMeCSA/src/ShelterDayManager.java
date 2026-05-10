/**
 * Manages the shelter's daily resources and progression system.
 * Responsibilities:
 * - Track and consume staff time as matches are processed each day.
 * - Advance the simulation to the next day, resetting resources and updating pet urgency.
 *
 * @author Sumedh K
 */
public class ShelterDayManager {

    // ── Constants  ───────────────────────────────
    private static final int MAX_DAILY_TIME     = 100; // total staff time per day
    private static final int BASE_MATCH_COST    = 20;  // base time cost per match
    private static final int SPECIAL_NEEDS_COST = 15;  // extra cost for special needs pets
    private static final int HIGH_ENERGY_COST   = 10;  // extra cost for high energy pets
    private static final int MAX_DAYS           = 7;   // simulation runs for 7 days

    // ── State ─────────────────────────────────────────────────────────────────
    private int timeRemaining;
    private int currentDay;
    private boolean shelterClosed;

    /**
     * Constructs a DailyResourceManager at the start of a new run.
     * Preconditions:  none.
     * Postconditions: timeRemaining is set to MAX_DAILY_TIME, currentDay is 1.
     *
     * @author Sumedh K
     */
    public ShelterDayManager() {
        this.timeRemaining  = MAX_DAILY_TIME;
        this.currentDay     = 1;
        this.shelterClosed  = false;
    }

    /**
     * Consumes staff time when a match is processed.
     * Special needs pets and high energy pets cost extra time.
     * Preconditions:  pet is not null; timeRemaining >= 0.
     * Postconditions: timeRemaining is reduced by the match cost; returns false if
     *                 there is not enough time remaining to process this match.
     *
     * @author Sumedh K
     * @param pet the pet being matched
     * @return true if the match was processed successfully, false if out of time
     */
    public boolean consumeTime(Pet pet) {
        int cost = BASE_MATCH_COST;

        // Special needs pets take more staff time
        if (pet.hasSpecialNeeds()) {
            cost += SPECIAL_NEEDS_COST;
        }

        // High energy pets take more handling time
        if (pet.getEnergyLevel().equalsIgnoreCase("High")) {
            cost += HIGH_ENERGY_COST;
        }

        // Check if enough time remains
        if (timeRemaining < cost) {
            return false; // not enough time left today
        }

        timeRemaining -= cost;
        return true;
    }

    /**
     * Advances the simulation to the next day.
     * Resets daily staff time, increments the day counter, and updates
     * urgency scores for all pets still in the shelter.
     * Preconditions:  pets is not null; currentDay >= 1.
     * Postconditions: timeRemaining resets to MAX_DAILY_TIME; currentDay increments
     *                 by 1; each pet's urgency score increases by 1; shelterClosed
     *                 is set to true if MAX_DAYS is reached.
     *
     * @author Sumedh K
     * @param pets the current list of pets still in the shelter
     */
    public void nextDay(ArrayList<Pet> pets) {
        currentDay++;
        timeRemaining = MAX_DAILY_TIME;

        // Each day that passes increases urgency for remaining pets
        for (Pet pet : pets) {
            pet.incrementDaysInShelter();
            // Urgency increases by 1 per day, capped at 10
            int newUrgency = Math.min(10, pet.getUrgencyScore() + 1);
            pet.setUrgencyScore(newUrgency);
        }

        // Check if simulation is over
        if (currentDay > MAX_DAYS) {
            shelterClosed = true;
        }
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    /**
     * Returns the staff time remaining today.
     * @author Sumedh K
     * @return timeRemaining as an int
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * Returns the current day of the simulation.
     * @author Sumedh K
     * @return currentDay as an int
     */
    public int getCurrentDay() {
        return currentDay;
    }

    /**
     * Returns whether the shelter simulation has ended.
     * @author Sumedh K
     * @return true if MAX_DAYS has been reached
     */
    public boolean isShelterClosed() {
        return shelterClosed;
    }
}
