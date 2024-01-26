package org.example.View;
import org.example.Main;
import org.example.Model.Food;
import org.example.Model.UserHistory;
import org.example.Service.HistoryService;
import org.example.Exception.CLIException;
import org.example.Exception.FishException;
import org.example.Exception.FoodSelectionException;
import org.example.Service.ReHeat;
import java.util.List;
import java.util.Scanner;

public class CLIParser {

    HistoryService historyService;

    public CLIParser() {
        historyService = new HistoryService();
    }

    public String parseCommandReturnOutput(String command) throws CLIException {
        if (command.equals("Reheat")) {
            return interpretReheatAction();
        } else if (command.equals("View History")) {
            return interpretHistoryAction();
        } else {
            Main.log.warn("Throwing CLI Exception, due to not inputting a Valid Choice into CLI");
            throw new CLIException("Not a valid option");
        }
    }

    public String interpretReheatAction() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Input Your Username");
        String username = sc.nextLine();
        System.out.println("Hello, " + username);
        System.out.println("Please Input Your Food Category");
        boolean valid = false;
        int choice;

        Food newuser = new Food();
        ReHeat reheat = new ReHeat();
        //System.out.println(reheat.getSuggestedHeatingTime(Food));
        do {
            newuser.getFoodCategories();
            String input1 = sc.nextLine();
            newuser.SetFoodSelection(input1);
            System.out.println("You Selected " + newuser.GetFoodSelection());
            String Food = newuser.GetFoodSelection();
            //ReHeat reheat = new ReHeat();
            try {
                System.out.println(reheat.getSuggestedHeatingTime(Food));
                valid = true;
            } catch (FishException exception) {
                System.out.println("Office Policy is not to ReHeat Fish. Please Eat Your Fish Cold");
                historyService.addUserHistory(username, Food, 0);
                exception.printStackTrace();
            } catch (FoodSelectionException exception) {
                System.out.println("Please Select A Valid Food Category");
                exception.printStackTrace();
                //newuser.getFoodCategories();
            }
        } while (!valid);

        System.out.println("Use This Heating Time? Yes/No");
        String Food = newuser.GetFoodSelection();
        String input2 = sc.nextLine();
        if (input2.equals("Yes")) {

            choice = reheat.SuggestedSeconds(Food);
            historyService.addUserHistory(username, Food, choice);
            for (; choice > 0; choice--) {
                System.out.println(choice);
            }
        } else {
            System.out.println("How many seconds do you want to heat your food for?");
            choice = Integer.parseInt(sc.nextLine());
            historyService.addUserHistory(username, Food, choice);
            for (; choice > 0; choice--) {
                System.out.println(choice);
            }
        }
        return "BEEEEEEEEEEEEEP";

    }

    public String interpretHistoryAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select All for All History." + "\n" + "Select User For Specific User" + "\n" + "All / User");
        String input = sc.nextLine();

        if (input.equals("All")) {
            List<UserHistory> userHistory = historyService.getAllHistory();
            return "User History: " + userHistory.toString();
        } else if (input.equals("User")) {
            System.out.println("Please Input The User's Name You Wish to Search");
            String userName = sc.nextLine();
            List<UserHistory> userHistory = historyService.getAllHistory();
            for (UserHistory element : userHistory) {
                if (element.toString().contains(userName)) {
                    return element.toString();
                } else {
                    return "There is no history for this user";
                }
            }
        }
        return "";
    }
}


