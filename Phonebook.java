import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (phonebook.containsKey(lastName)) {
            phonebook.get(lastName).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phonebook.put(lastName, phoneNumbers);
        }
    }

    public List<String> get(String lastName) {
        return phonebook.getOrDefault(lastName, new ArrayList<>());
    }

    public void printPhoneNumbers(String lastName) {
        List<String> phoneNumbers = get(lastName);
        if (phoneNumbers.isEmpty()) {
            System.out.println("Номер телефона для фамилии " + lastName + " не найден.");
        } else {
            System.out.println("Телефоны для фамилии " + lastName + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "123-456-7890");
        phonebook.add("Петров", "987-654-3210");
        phonebook.add("Иванов", "555-555-5555");

        phonebook.printPhoneNumbers("Иванов");
        phonebook.printPhoneNumbers("Петров");
        phonebook.printPhoneNumbers("Сидоров");
    }
}
