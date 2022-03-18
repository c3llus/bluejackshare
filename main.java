
import java.io.File;  
import java.io.IOException;
import static java.lang.System.out;
import java.util.HashSet;  
import java.util.HashMap;  
import java.util.*;  

public class main {
 public static void main(String[] args) {

    // TODO: jadiin modular

    Scanner scanner = new Scanner(System.in);
    boolean isAppOpen = true;
    HashSet<String> usernameList = new HashSet();
    HashMap<String, Integer> shareList = new HashMap<String, Integer>();

    int menuOption=0;


    while (isAppOpen) {

        // MENU
        System.out.println("+=================================+");  
        System.out.println("+ 1. Start Sharing                +"); 
        System.out.println("+ 2. Update Participant           +"); 
        System.out.println("+ 3. Delete Participant           +"); 
        System.out.println("+ 4. Close App                    +");
        System.out.println("+=================================+"); 
        System.out.print("Choice >> ");
        menuOption = scanner.nextInt();  


        if (menuOption < 0 || menuOption > 4) {
            System.out.println("Input must be between 1-4");
            continue;
        }


        if (menuOption == 1) {
            boolean validated;
            int share = 0;
            String username = "";

            // SHARE INPUT
            validated = false;
            while (!validated){
                // TODO: jadiin modular
                System.out.print("Input a number [0-100]:");  
                
                // numeric validation
                if (!scanner.hasNextInt()){
                    System.out.println("Input must be numeric!"); 
                    continue ;
                }

                share = scanner.nextInt();  

                // 0-100 validation
                if (share < 0 || share > 100) {
                    share = 0;
                    continue;
                }
                validated = true;
            }

            // USERNAME INPUT
            validated = false;
            while(!validated){
                System.out.print("Username [5-20 characters]:");  
                username = scanner.nextLine();  


                // 5-20 char validation
                if (username.length() < 5 || username.length() > 20){
                    System.out.print("Username must be 5-20 chars!"); 
                    continue;
                }

                // unique validation
                if (usernameList.contains(username)) {
                    System.out.println("Username used, please choose another!"); 
                    continue ;
                }
                
                validated = true;
            }

            // Register username
            usernameList.add(username);

            // Input user's share
            shareList.put(username, share);

            System.out.println("You are of the "+ String.valueOf(usernameList.size()) +" player(s) that joins the game"); 
            System.out.println("Your share number: "+ String.valueOf(shareList.get(username)));

            continue; // back to menu
        }

        if (menuOption == 2) {
            
            // if there's no user, back to menu
            if (usernameList.size() <= 0) {
                continue;
            }

            boolean isDone = false;
            while (!isDone) {
                int share;
                // xxxxx
                // print menu; TODO: jadiin modular
                System.out.println("+=================================+");  
                System.out.println("+ User Share List                 +");  
                System.out.println("+=================================+");  

                Iterator<String> itrtr = usernameList.iterator();
                int itr = 1;
                String[] usernameTempList = new String[usernameList.size()];
                while(itrtr.hasNext()){
                    String username = itrtr.next();
                    usernameTempList[itr-1] = username;
                    System.out.println("|"+String.valueOf(itr)+"  | "+ username +" | "+ shareList.get(username)+ " |"); 
                    itr += 1; 
                }


                System.out.println("+=================================+"); 
                // xxxx

                System.out.println("Which user would you like to update? [1-"+String.valueOf(itr)+"][0 to exit]");
                int index = scanner.nextInt();

                if (index == 0) {
                    break; // isDone
                }
            
                // validate user option
                if (index > itr) {
                    continue;
                }

                // TODO: jadiin modular
                System.out.println("Input a number [0-100]:");  
                
                // numeric validation
                if (!scanner.hasNextInt()){
                    System.out.println("Input must be numeric!"); 
                    continue;
                }

                share = scanner.nextInt();  

                // 0-100 validation
                if (share < 0 || share > 100) {
                    share = 0;
                    continue;
                }

                // update share
                shareList.put(usernameTempList[index], share);

                isDone = true;
            }
            System.out.println("Update successful!"); 
            continue;   
        }

        if (menuOption == 3) {
            // if there's no user, back to menu
            if (usernameList.size() <= 0) {
                continue;
            }

            // xxxx
            // print menu; TODO: jadiin modular
            System.out.println("+=================================+");  
            System.out.println("+ User Share List                 +");  
            System.out.println("+=================================+");  

            Iterator<String> itrtr = usernameList.iterator();
            int itr = 1;
            String[] usernameTempList = new String[usernameList.size()];
            while(itrtr.hasNext()){
                String username = itrtr.next();
                usernameTempList[itr-1] = username;
                System.out.println("|"+String.valueOf(itr)+"  | "+ username +" | "+ shareList.get(username)+ " |");  
                itr += 1;
            }


            System.out.println("+=================================+"); 
            // xxxx

            System.out.println("Which user would you like to delete? [1-"+String.valueOf(itr)+"][0 to exit]");
            int index = scanner.nextInt();

            if (index == 0){
                break; // isDone
            }
        
            // validate user option
            if (index > itr) {
                continue;
            }


            usernameList.remove(usernameTempList[index]);
            shareList.remove(usernameTempList[index]);

            System.out.println("Delete successful!"); 
        }


        if (menuOption == 4) {
            break; // isAppOpen = false
        }

    }
    return;
 }
} 
