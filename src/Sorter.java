// В классе реализована перегрузка методов, доступен вариант как сортировки части массива, так и сортировки массива целиком
public class Sorter {
    public int[] sort(int[] arr, int firstElement, int lastElement) throws RuntimeException, ArrayIndexOutOfBoundsException {
        if ((lastElement - firstElement) > 0) {
            int[] sortArray = new int[lastElement - firstElement + 1];
            int j = 0;
            for (int i = firstElement; i <= lastElement; i++) {
                sortArray[j] = arr[i];
                j++;
            }
            int i = firstElement;
            for (int element : sort(sortArray)) {
                arr[i] = element;
                i++;
            }

            return arr;
        } else if ((lastElement - firstElement) == 0) {
            throw new RuntimeException("Невозможно отсортировать по возраставнию последовательность из одного элемента");
        } else {
            throw new RuntimeException("Элементы индекс, с которого начинается сортировка должен быть меньше индексса, " +
                    "на котором она заканчивается");
        }
    }

    public int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int half;
        half = (int) Math.floor((arr.length) / 2); //округление в меньшую сторону
        int[] left = new int[half];
        int[] right = new int[arr.length - half];
        for (int i = 0; i < arr.length; i++) {
            if (i < half) {
                left[i] = arr[i];
            } else {
                right[i - half] = arr[i];
            }
        }
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] mergeResult = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < mergeResult.length; k++) {
            if (left.length == i) {
                mergeResult[k] = right[j];
                j++;
            } else if (right.length == j) {
                mergeResult[k] = left[i];
                i++;
            } else if (left[i] >= right[j]) {
                mergeResult[k] = right[j];
                j++;
            } else {
                mergeResult[k] = left[i];
                i++;
            }
        }
        return mergeResult;
    }
}
