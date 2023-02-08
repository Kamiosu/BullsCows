import java.util.Scanner;

class EmployeeManagement {

    public static String createEmail(String name, String surname) { //Static meaning no instance is needed

        StringBuilder email = new StringBuilder(name);
        StringBuilder emailComplete = email.append(surname).append("@work.net");


        return  emailComplete.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String surname = scanner.next();

        String completeEmail = createEmail(name, surname);

        System.out.println(completeEmail);
    }
}