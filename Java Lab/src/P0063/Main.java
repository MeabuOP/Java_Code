package P0063;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            Person[] personArray = new Person[3];
            System.out.println("=====Management Person programer=====");
            for (int i = 0; i < 3; i++) {
                personArray[i] = inputPersonInfo();
            }
            System.out.println("");
            sortBySalary(personArray);
            for (int i = 0; i < 3; i++) {
                displayPersonInfo(personArray[i]);
            }
        }

    }

    public static Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        String name = Validator.inputName();
        String address = Validator.inputAddress();
        double salary = Validator.inputSalary();
        return new Person(name, address, salary);
    }

    public static void sortBySalary(Person[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int y = 0; y < n - 1; y++) {
                if (array[y].getSalary() > array[y + 1].getSalary()) {
                    Person temp = array[y];
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

    public static void displayPersonInfo(Person p) {
        System.out.println("Information of Person you have entered:");
        System.out.println("Name:" + p.getName());
        System.out.println("Address" + p.getAddress());
        System.out.println("Salary:" + p.getSalary());
        System.out.println("");
    }
}
