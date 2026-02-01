import java.io.*;
import java.util.Scanner;

public class Main {

    static final String FILE_NAME = "app.json";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String json = "";
        String kurt = "";

        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            json = reader.readLine();
            reader.close();
        } catch (Exception e) {
            // default po kapag yung file is nag loloko or di mahanap mag lalabas lang po ng appname
            json = "{\"appName\":\"\"}";
        }

        
        kurt = json.replace("{\"appName\":\"", "");
        kurt = kurt.replace("\"}", "");

        String appName = kurt;
        int choice;

        do {
            System.out.println("\n--- SINGLE APP SYSTEM ---");
            System.out.println("1. Create app name");
            System.out.println("2. View app name");
            System.out.println("3. Update app name");
            System.out.println("4. Delete app name");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    if (appName.equals("")) {
                        System.out.print("Enter app name: ");
                        appName = input.nextLine();
                        System.out.println("App saved!");
                    } else {
                        System.out.println("App already exists.");
                    }
                    break;

                case 2:
                    System.out.println(appName.equals("")
                            ? "No app found."
                            : "App name: " + appName);
                    break;

                case 3:
                    if (!appName.equals("")) {
                        System.out.print("Enter new app name: ");
                        appName = input.nextLine();
                        System.out.println("App updated!");
                    } else {
                        System.out.println("No app to update.");
                    }
                    break;

                case 4:
                    appName = "";
                    System.out.println("App deleted!");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}
