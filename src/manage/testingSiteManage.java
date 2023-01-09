package manage;

import java.util.ArrayList;
import java.util.ListIterator;

public class testingSiteManage {
    ArrayList<testingSite> testingSites = new ArrayList<>();
    public void addTestingSite(String input){
        String[] inputTestingSite = input.split(" ");
        testingSite ts = new testingSite(Integer.parseInt(inputTestingSite[0]), inputTestingSite[1], inputTestingSite[2], inputTestingSite[3], inputTestingSite[4]);
        if (testingSites.size() == 0) {
            testingSites.add(ts);
            return;
        }
        // conflict management
        ListIterator<testingSite> iterator = testingSites.listIterator();
        while (iterator.hasNext()) {
            testingSite t = iterator.next();
            if (t.getID() == ts.getID() && t.getTestingSiteName().equals(ts.getTestingSiteName()) && t.getCity().equals(ts.getCity()) && t.getOpeningDate().equals(ts.getOpeningDate()) && t.getOpeningTime().equals(ts.getOpeningTime())){
                System.out.println("Duplicate testing site!");
                return;
            }
        }
        iterator.add(ts);
    }
    public void retrieveTestingSite(){
        int n = 0;
        for(testingSite ts : testingSites){
            //System.out.println("第" + n + "个检测点:");
            System.out.println("ID: " + ts.getID());
            System.out.println("City: " + ts.getCity());
            System.out.println("Name: " + ts.getTestingSiteName());
            System.out.println("Date and Time: " + ts.getOpeningDate() + "   " + ts.getOpeningTime());
            n++;
        }
    }
    public void retrieveTestingSite(int ID){
        testingSite ts = null;
        for (testingSite t : testingSites){
            if (t.getID() == ID){
                ts = t;
            }
        }
        System.out.println("City: " + ts.getCity());
        System.out.println("Name: " + ts.getTestingSiteName());
        System.out.println("Date and Time: " + ts.getOpeningDate() + "   " + ts.getOpeningTime());
    }
    public testingSite getTestSite(int ID){
        testingSite ts = testingSites.get(ID);
        return ts;
    }
    public void deleteTestingSite(int ID){
        testingSite shallBeDeleted = null;
        for (testingSite ts : testingSites){
            if (ts.getID() == ID){
                shallBeDeleted = ts;
            }
        }
        testingSites.remove(shallBeDeleted);
    }
    public ArrayList<testingSite> getTestingSites() {
        return testingSites;
    }
    public testingSite getTestingSite (int ID) {
        for (testingSite t : testingSites) {
            if (t.getID() == ID) {
                return t;
            }
        }
        System.out.println("No site has such ID!");
        return null;
    }
}
