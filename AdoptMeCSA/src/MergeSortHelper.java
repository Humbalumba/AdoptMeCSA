import java.util.ArrayList;

/**
 * Description: Utility class providing merge sort implementations for lists of Pet.
 */
public class MergeSortHelper {
    /**
     * Description: Sorts the given list of pets in ascending order by urgency
     * using the merge sort algorithm.
     *
     * Precondition: The input list must not be null.
     *
     * Postcondition: The input list is rearranged in ascending order by
     * urgency. The method performs the sort in-place.
     *
     * @author Aarush P
     * @param list the ArrayList of Pet objects to sort (must not be null)
     * @return the same list instance sorted in ascending order by urgency
     */
    public static ArrayList<Pet> sortByUrgency(ArrayList<Pet> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        ArrayList<Pet> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Pet> right = new ArrayList<>(list.subList(mid, list.size()));
        left =sortByUrgency(left);
        right = sortByUrgency(right);
        return merge(list, left, right);
    }
    /**
     * Description: Merges two sorted sublists into the destination list,
     * ordering elements by urgency.
     *
     * Precondition: Both left and right lists are sorted in ascending order by
     * urgency. The destination list has the same total size as left+right.
     *
     * Postcondition: The destination list contains all elements from left and
     * right in ascending order by urgency.
     * 
     * @author Aarush P
     * @param list  destination ArrayList to receive merged elements
     * @param left  left sorted sublist
     * @param right right sorted sublist
     * @return the destination list containing merged elements in order by urgency
     */
    public static ArrayList<Pet> merge(ArrayList<Pet> list, ArrayList<Pet> left, ArrayList<Pet> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getUrgency() <= right.get(j).getUrgency()) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
        return list;
    }

    /**
     * Description: Sorts the given list of pets in ascending order by
     * compatibility score using the merge sort algorithm.
     *
     * Precondition: The input list must not be null.
     *
     * Postcondition: The input list is rearranged in ascending order by
     * compatibility score. The method performs the sort in-place.
     * @author Aarush P
     * @param list the ArrayList of Pet objects to sort (must not be null)
     * @return the same list instance sorted in ascending order by compatibility score
     */
    public static ArrayList<Pet> sortByCompatibilityScore(ArrayList<Pet> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        ArrayList<Pet> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Pet> right = new ArrayList<>(list.subList(mid, list.size()));
        left = sortByCompatibilityScore(left);
        right = sortByCompatibilityScore(right);
        return mergeByCompatibilityScore(list, left, right);
    }
    /**
     * Description: Merges two sorted sublists into the destination list,
     * ordering elements by compatibility score.
     *
     * Precondition: Both left and right lists are sorted in ascending order by
     * compatibility score. The destination list has the same total size as left+right.
     *
     * Postcondition: The destination list contains all elements from left and
     * right in ascending order by compatibility score.
     *
     * @author Aarush P
     * @param list  destination ArrayList to receive merged elements
     * @param left  left sorted sublist
     * @param right right sorted sublist
     * @return the destination list containing merged elements in order by compatibility score
     */
    public static ArrayList<Pet> mergeByCompatibilityScore(ArrayList<Pet> list, ArrayList<Pet> left, ArrayList<Pet> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getCompatibilityScore() <= right.get(j).getCompatibilityScore()) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
        return list;
    }
}