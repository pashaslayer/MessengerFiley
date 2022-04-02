import Chat.User;
import UserHandling.UserHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner readInput = new Scanner(System.in);

    public static final char LOG_IN = 'l';
    public static final char SIGN_IN = 's';
    public static final char EXIT = 'e';

    public static void main(String[] args) {

        UserHandling userH = new UserHandling();

        // Saving all the users into the List right at the beginning
        List<User> userlist = new ArrayList<>();

        char mainChoice;

        do {
            userlist = userH.getUserListFromFile(userH.getStringPath());
            mainChoice = mainMenuChoice();

            switch (mainChoice) {
                case LOG_IN:
                    // getUserFromValidLoginData macht schon die Verifizierung ob user existiert oder nicht
                    User userLogin = userH.getUserFromValidLoginData(loginData());

                    if(userLogin != null) {
                        System.out.println("Successfully logged in! \n");
                        break;
                    }
                    else{
                        System.out.println("Failed to log in! \n");
                        break;
                    }

                case SIGN_IN:
                    User userSignIn = createUser(userlist);

                    if(userH.checkIfUserAlreadyRegistered(userSignIn, userlist)) {
                        System.out.println("This user already exists! ");
                        System.out.println("Try again! \n");
                    }
                    else {
                        userH.addUser(userSignIn);
                        System.out.println("User succesfully added! ");
                        // Getting new data from file
                        userH.syncUserList();
                    }
                    break;
            }

        } while (mainChoice != EXIT);

    }

    public static char mainMenuChoice() {
        char yourChoice;
        System.out.println("Hello Chat.User!\n");
        System.out.println("Do you want to log in? [press l]");
        System.out.println("Do you want to sign in? [press s]");
        System.out.println("Exit? [press e]");
        yourChoice = readInput.next().toLowerCase().charAt(0);
        return yourChoice;
    }

    public static User createUser(List<User> userList) {
        User createdUser = new User();
        Scanner reader = new Scanner(System.in);

        System.out.println("--Registration--");

        createdUser.setUserId(userList.get(userList.size()-1).getUserId()+1);

        System.out.println("Email: ");
        createdUser.setEmail(reader.nextLine());

        System.out.println("Nickname: ");
        createdUser.setUsername(reader.nextLine());

        System.out.println("Password: ");
        createdUser.setPassword(reader.nextLine());

        return createdUser;
    }

    public static User loginData() {
        User loginUser = new User();
        Scanner reader = new Scanner(System.in);

        System.out.println("--Login-- \n");
        System.out.println("Email:");
        loginUser.setEmail(reader.nextLine());
        System.out.println("Password: ");
        loginUser.setPassword(reader.nextLine());

        return loginUser;
    }

    public static char messageChoice() {
        Scanner reader = new Scanner(System.in);

        return 'n';
    }

}
