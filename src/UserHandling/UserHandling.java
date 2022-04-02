package UserHandling;

import Chat.User;
import Datenbank.SQLConnection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UserHandling {

    final String stringPath = "C:\\Users\\pavel\\Desktop\\Filey\\users.txt";
    List<User> userList = new ArrayList<>();

    public UserHandling() {
        userList = getUserListFromFile(stringPath);
    }

    public String getStringPath() {
        return stringPath;
    }

    public void addUser(User user) {

        Path path = Path.of(stringPath);

        try {
            Files.write(path, convertUserToString(user).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException io) {
            System.out.println("Problem beim Schreiben in die Datei! " + io);
        }
    }

    public String convertUserToString(User user) {
        String userString;

        userString = user.getUserId() + ";";
        userString += user.getEmail() + ";";
        userString += user.getUsername() + ";";
        userString += user.getPassword() + "\n";

        return userString;
    }

    public List<User> getUserListFromFile(String stringPath) {

        Path path = Path.of(stringPath);

        if (Files.exists(path)) {
            try {
                return convertEachStringToUser(Files.readAllLines(path));

            } catch (IOException io) {
                System.out.println("Problem beim Lesen der Datei!" + io);
            }
        } else {
            System.out.println("Die Datei exisitiert nicht!");
        }
        return null;
    }

    public List<String> getStringUserList(String stringPath) {
        List<String> stringUserList = new ArrayList<>();

        Path path = Path.of(stringPath);

        try {
            stringUserList = Files.readAllLines(path);
        } catch (IOException io) {
            System.out.println("Problem with reading the file! " + io);
        }
        return stringUserList;
    }

    public User convertStringToUser(String csvString) {

        String[] userString;
        userString = csvString.split(";");

        User user = new User();

        user.setUserId(Integer.parseInt(userString[0]));
        user.setEmail(userString[1]);
        user.setUsername(userString[2]);
        user.setPassword(userString[3]);

        return user;
    }

    public List<User> convertEachStringToUser(List<String> csvStringList) {

        List<User> userList = new ArrayList<>();

        for (String s : csvStringList) {
            userList.add(convertStringToUser(s));
        }

        return userList;
    }

    public boolean checkIfUserAlreadyRegistered(User user, List<User> userListNew) {

        for(User comparisonUser : userListNew) {
            if(user.getUsername().equals(comparisonUser.getUsername())){
                System.out.println("This username already exists! ");
                return true;
            }
            else if(user.getEmail().equals(comparisonUser.getEmail())){
                System.out.println("This email already existst! ");
                return true;
            }
        }
        return false;
    }

    public boolean checkIfUserAlreadyExists(User user, List<User> userListNew) {
        // Going through all the users until the right login data is provided
        for(User comparisonUser : userListNew) {
            if(user.getUsername().equals(comparisonUser.getUsername())){
                return true;
            }
            else if(user.getEmail().equals(comparisonUser.getEmail())){
                return true;
            }
        }
        return false;
    }

    public int getLastUserId() {
        return userList.get(userList.size()-1).getUserId();
    }

    public User getUserFromValidLoginData(User user) {

        System.out.println(userList.size());
        System.out.println(user.getEmail() + user.getPassword());
        User newUser = null;
        for(User u : userList) {
            if(user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
                newUser = u;
            }
        }
        return newUser;
    }

    public void syncUserList(){
        this.userList = getUserListFromFile(stringPath);
    }




        // User u1 = new User(handling.getLastUserId(), "paul@mail.ru", "Vostok", "12345");
        // User u2 = new User(handling.getLastUserId(), "rahul@mail.ru", "Andreas", "rahul52");



        //handling.addUser(u1);
        //handling.addUser(u2);

        // List<User> userList = new ArrayList<>();

        // userList = handling.getUserListFromFile(handling.stringPath);

        // for (User u : userList) {
        //    System.out.println(u);
        //}

        // SQLConnection sqlConnection = new SQLConnection();

        // sqlConnection.openConnection();

        // sqlConnection.insertUserToSql(u1);
        // sqlConnection.insertUserToSql(u2);

        // sqlConnection.closeConnection();






}


