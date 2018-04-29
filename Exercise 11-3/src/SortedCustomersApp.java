import java.util.Arrays;

public class SortedCustomersApp {

    public static void main(String[] args) {

        Customer[] customers = new Customer[3];
        customers[0] = new Customer("Albert@Hotmail.com", "Albert", "Leon");
        customers[1] = new Customer("Alexander@Hotmail.com", "Alexander", "Leon");
        customers[2] = new Customer("Leon@Hotmail.com", "Leon", "King");
        Arrays.sort(customers);

        for (Customer c : customers) {
            System.out.println(
                    c.getEmail() + " " +
                            c.getFirstName() + " " +
                            c.getLastName());
        }
    }
}