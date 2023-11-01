package SU23;

public class Main {

    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[]{new Teacher(5, 5), new Teacher(3, 3), new Teacher(2, 2), new Teacher(4, 4),
            new Teacher(7, 7), new Teacher(6, 6), new Teacher(8, 8), new Teacher(1, 1), new Teacher(9, 9)};

        BinarySearchTree bst = new BinarySearchTree();
        for (Teacher t : teachers) {
            bst.addNode(t);
        }
        bst.updateCoeff(bst.root);
        bst.printNodeWithLevel(bst.root, 0);
        bst.updateBal(bst.root);
        System.out.println("---------------------");
        bst.preOrder(bst.root);
        bubbleSort(teachers);
    }

    public static void bubbleSort(Teacher[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int y = 0; y < n - 1; y++) {
                if (array[y].compareTo(array[y + 1]) < 0) {
                    Teacher temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }
}
