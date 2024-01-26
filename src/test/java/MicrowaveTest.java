import org.example.Model.UserHistory;
import org.example.Service.HistoryService;
import org.example.Service.ReHeat;
import org.example.Exception.FishException;
import org.example.Exception.FoodSelectionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class MicrowaveTest {

    HistoryService historyService;
    ReHeat reheat;

    @Before
    public void setUp(){
        historyService = new HistoryService();
        reheat = new ReHeat();
    }

    @Test
    public void historyServiceEmptyAtStart(){
        List<UserHistory> userHistoryList = historyService.getAllHistory();
        Assert.assertEquals(0, userHistoryList.size());
    }

    @Test
    public void heatingUpFishInTheOffice(){
        String Food = "Fish";
        try{
            reheat.getSuggestedHeatingTime(Food);
            Assert.fail();
        }catch (FishException e){
        }catch (FoodSelectionException e){}

    }

    @Test
    public void invalidFoodSelection(){
        String Food = "Tacos";
        try{
            reheat.getSuggestedHeatingTime(Food);
            Assert.fail();
        }catch (FishException e){
        }catch (FoodSelectionException e){}

    }

    @Test
    public void correctSuggestedTimeGenerated1(){
        String Food = "Popcorn";
        try{
            String actual = reheat.getSuggestedHeatingTime(Food);
            Assert.assertEquals("The suggested heating time is 150 seconds.", actual);
        }catch (FishException e){
        }catch (FoodSelectionException e){}

    }

    @Test
    public void correctSuggestedTimeGenerated2(){
        String Food = "Liquids";
        try{
            String actual = reheat.getSuggestedHeatingTime(Food);
            Assert.assertEquals("The suggested heating time is 60 seconds.", actual);
        }catch (FishException e){
        }catch (FoodSelectionException e){}

    }

    @Test
    public void userHistorySaved(){
        String testname = "John";
        String testfood = "Beef";
        int testseconds = 90;
        historyService.addUserHistory(testname, testfood, testseconds);
        List<UserHistory> userHistoryList = historyService.getAllHistory();
        UserHistory actual = userHistoryList.get(0);
        Assert.assertEquals(testname, actual.getUsername());

    }

    @Test
    public void correctHeatingTimeGenerated1(){
        String Food = "Beef";
        int actual = reheat.SuggestedSeconds(Food);
        Assert.assertEquals(120, actual);
    }

    @Test
    public void correctHeatingTimeGenerated2(){
        String Food = "Popcorn";
        int actual = reheat.SuggestedSeconds(Food);
        Assert.assertEquals(150, actual);
    }




}
