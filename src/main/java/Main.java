import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userLogin = new Login();
        
        //for our menue loop system//
        boolean isRunning = true; 
        
        while (isRunning) {
            System.out.println("Please select an option between 1, 2 or 3");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
            String choice = scanner.nextLine();
        
        //dealing with the first option which is registration//
        if (choice.equals("1")) {
            System.out.println("Create an account");
        
        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();
        
        String user;
        while (true){
        System.out.print("Enter a Username with max 5 chars, must contain '_': ");
        user = scanner.nextLine();
        
        if (userLogin.checkUsername(user)){
            System.out.println("Username succssefully captured.\n");
            break;
        } else {
            System.out.println("Error: Username is not formatted correvtly");
        }
        }
        //Password loop//
        String pass;
        while (true){
        System.out.print("Enter a Password.. min of 8 chars, 1 uppercase, 1 number, 1 special:  ");
        pass = scanner.nextLine();
        
        if (userLogin.checkPasswordComplexity(pass)) {
            System.out.println("Password successfully captured.\n");
            break;
        } else {
            System.out.println("Error: Password is not correctly formatted.\n");
            }
        }
        
        //cellphone number loop
        String cell;
        while (true) {
        System.out.print("Enter an SA NO include the international code +27: ");
        cell = scanner.nextLine();
        if (cell.startsWith("0") && cell.length() == 10) {
            cell = "+27" + cell.substring(1); //if the user ever writes the number starting with 0 instead of +27 this method will change 
        }
        
        if (userLogin.checkCellPhoneNumber(cell)) {
            System.out.println("Cell number successfully captured.\n");
            break;
        } else {
            System.out.println("Error: Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.\n");
        }
    }
        
 
        //Registration attemption//
        String registrationResult = userLogin.registerUser(user, pass, cell, fName, lName);
        System.out.println("\n" + registrationResult);
        
        //we need to have a loop system that takes us back to the main menu//
        
        //login theory//
    }else if (choice.equals("2")) {
        System.out.println("\n Login ");
        
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();
        
        //we need to tally the data stored in the login class//
        boolean isLoggedIn = userLogin.loginUser(loginUser, loginPass);
        
        //mesage to show success login or failed attemot to login//
        String loginMessage = userLogin.returnLoginStatus(isLoggedIn);
        System.out.println("\n" + loginMessage);
        
        //an exit system option//
    }else if (choice.equals("3")) {
                System.out.println("\nExiting bye!");
                isRunning = false; //this will allow us to break the loop and end the program//
                
    }else {
                    System.out.println("\nIvalid, please type 1, 2 0r 3.");
                }
                }
        
        scanner.close();
    }}
        


        
