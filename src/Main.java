
public class Main {
    public static void main(String[] args) {
        int[] array = {89, 4, 32, 73, 1, 1, 19, 5, 75};
        Sorter sorter = new Sorter();
        try {
            System.out.print("Отформатированный массив: [");
            int i = 0;
            for (int element : sorter.sort(array, 2, 8)) {
                if (i == array.length - 1) {
                    System.out.print(element + "]");
                    break;
                }
                i++;
                System.out.print(element + ",");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индексы выходят за пределы массива");
        } catch (RuntimeException e) {
            System.out.println("Индексы введены некорректно");
        }
    }
}