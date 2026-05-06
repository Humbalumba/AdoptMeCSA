import java.util.ArrayList;
public class MergeSortHelper {
    public static void sortByUrgency(ArrayList<Pet> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Pet> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Pet> right = new ArrayList<>(list.subList(mid, list.size()));
        sortByUrgency(left);
        sortByUrgency(right);
        merge(list, left, right);
    }
    public static void merge(ArrayList<Pet> list, ArrayList<Pet> left, ArrayList<Pet> right) {
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
    }

    public static void sortByCompatibilityScore(ArrayList<Pet> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Pet> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Pet> right = new ArrayList<>(list.subList(mid, list.size()));
        sortByCompatibilityScore(left);
        sortByCompatibilityScore(right);
        mergeByCompatibilityScore(list, left, right);
    }
    public static void mergeByCompatibilityScore(ArrayList<Pet> list, ArrayList<Pet> left, ArrayList<Pet> right) {
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
    }
}