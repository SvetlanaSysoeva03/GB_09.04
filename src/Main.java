import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: Неверное количество данных. Введите данные в нужном формате.");
            return;
        }

        try {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Ошибка: Неверный формат данных для пола.");
            }

            String fileName = lastName + ".txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат данных для номера телефона.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

        /*try{
            String lastName = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            String firstName = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            String middleName = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


         */



