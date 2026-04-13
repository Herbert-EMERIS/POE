import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userLogin = new Login();
        
        System.out.println("Rgistration");
        
        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();
        
        System.out.print("Enter a Username with max 5 chars, must contain '_': ");
        String user = scanner.nextLine();
        
        System.out.print("Enter a Password.. min of 8 chars, 1 uppercase, 1 number, 1 special:  ");
        String pass = scanner.nextLine();
        
        System.out.print("Enter an SA NO include the international code +27: ");
        String cell = scanner.nextLine();
        if (cell.startsWith("0") && cell.length() == 10) {
            cell = "+27" + cell.substring(1);
        }
 
        
        String registrationResult = userLogin.registerUser(user, pass, cell, fName, lName);
        System.out.println("\n" + registrationResult);
        
        
        //if successfull proceed//
        if (registrationResult.equals("User successfully registered!")) {
            System.out.println("\n LOGIN");
            
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            // Attempt Login
            boolean isLoggedIn = userLogin.loginUser(loginUser, loginPass);
            String loginMessage = userLogin.returnLoginStatus(isLoggedIn);
            
            System.out.println("\n" + loginMessage);
        }
        
        scanner.close();
    }}
        


        
