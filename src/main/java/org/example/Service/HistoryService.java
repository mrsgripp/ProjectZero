package org.example.Service;
import org.example.Main;
import org.example.Model.UserHistory;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class HistoryService {
    List<UserHistory> userhistory;

    public HistoryService() {
        userhistory = new ArrayList<>();
    }

    public void addUserHistory(String username, String foodselection, int heatingtime) {
        Main.log.info("Adding User History");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        UserHistory history = new UserHistory(username, foodselection, heatingtime, currentTime);
        userhistory.add(history);
    }

    public List<UserHistory> getAllHistory() {
        Main.log.info("Retrieving User History");
        return userhistory;
    }

}