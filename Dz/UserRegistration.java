package DZ2;

import java.io.FileWriter;
import java.util.Scanner;

public class UserRegistration {
    public void registerUser() {

        Scanner scanner = new Scanner(System.in, "ibm866");

        System.out.println(
                "Введите данные: фамилия имя отчество дата рождения dd.mm.yyyy номер телефона пол (f или m)");
        String input = scanner.nextLine();

        try {
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new RuntimeException("Введено недостаточно или слишком много данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!checkDate(birthDate)) {
                throw new RuntimeException("Неверный формат даты рождения");
            }

            if (gender != 'f' && gender != 'm') {
                throw new RuntimeException("Неверный формат пола");
            }

            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);
            fileWriter.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " "
                    + gender + "\n");
            fileWriter.close();
            System.out.println("Данные успешно записаны в файл " + lastName + ".txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean checkDate(String date) {
        return date.matches("([0-2][0-9]|3[0-1]).(0[0-9]|1[0-2]).\\d{4}");
    }
}