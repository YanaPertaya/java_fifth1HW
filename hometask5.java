import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class hometask5 {
    
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.


public static void main(String[] args) {
    HashMap<String, String> phonebook = new HashMap<>(0, 0);
    ArrayList<Integer> telephone = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    HashMap<String, String> newphonebook = new HashMap<>();
    HashSet<String> Set = new HashSet<>();
    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    Scanner scanner3 = new Scanner(System.in);

    System.out.println("Количество номеров телефона для ввода: ");
    int n = scanner1.nextInt();
    System.out.println("Введите номер/а "+ n +" телефона и владельца/цев");
    int s = 0;
    while (s<n) {
        System.out.println("Введите 8ми значный номер телефона: ");
        String str1 = scanner2.nextLine();
        System.out.println("Введите ФИО владельца телефона: ");
        String str2 = scanner3.nextLine();
        phonebook.put(str1, str2);
        s++;
    }
    for (String i : phonebook.values()) {
        Set.add(i);
    }

    for (String i : phonebook.values()) {
        if (Set.contains(i)) {
            newphonebook.put(i, null);
            Set.remove(i);
        }
    }

    for (String j: phonebook.keySet()) {
        if (phonebook.containsValue(phonebook.get(j))) {
            newphonebook.replace(phonebook.get(j), newphonebook.get(phonebook.get(j)), newphonebook.get(phonebook.get(j)) + ";" + j);

        }
    }

    for (String i: newphonebook.keySet()) {
        newphonebook.replace(i, newphonebook.get(i), newphonebook.get(i).substring(5, newphonebook.get(i).length()));

    }

    System.out.println("Введены следующие имена с номера: ");
    for (String i : newphonebook.keySet()) {
        name.add(i);
        telephone.add(newphonebook.get(i).length());

    }

    for (int i = 0; i < telephone.size() - 1; i++) {
        for (int j = i +1; j < telephone.size(); j++) {
            if (Integer.parseInt(String.valueOf(telephone.get(j))) > Integer.parseInt(String.valueOf(telephone.get(i)))) {
                Collection.swap(name, i, j);

            }
        }
    }
    for (int j = 0; j < telephone.size(); j++) {
        for (String i : newphonebook.keySet()) {
            if (i == name.get(j)) {
                System.out.println(" " + i + " с номерами " + newphonebook.get(i));
            }
        }
    }
}





}
