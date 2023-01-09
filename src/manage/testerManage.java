package manage;

import java.util.ArrayList;
import java.util.ListIterator;

public class testerManage {
    ArrayList<tester> testers = new ArrayList<>();
    ListIterator<tester> testerListIterator;
    // input: ID name stage age result city type
    public void addTester (String input){
        String[] inputTester = input.split(" ");
        tester ter = new tester(Long.parseLong(inputTester[0]), inputTester[1], Integer.parseInt(inputTester[2]), inputTester[3], inputTester[4]);
        if (testers.size() == 0) {
            testers.add(ter);
            return;
        }
        testerListIterator = testers.listIterator();
        while (testerListIterator.hasNext()) {
            tester t = testerListIterator.next();
            if (t.getID() == ter.getID() && t.getCity().equals(ter.getCity()) && t.getName().equals(ter.getName()) && t.getAge() == ter.getAge() && t.getStage().equals(ter.getStage())){
                System.out.println("Duplicate person information!");
                return;
            }
        }
        testerListIterator.add(ter);
    }
    public void addTesters (String[] input) {
        for (int i = 0; i<10 ; i++) {
            addTester(input[i]);
        }
    }
    public void retrieveTester(){
        for(tester ts : testers){
            System.out.println("ID: " + ts.getID());
            System.out.println("Name: " + ts.getName());
            System.out.println("Age: " + ts.getAge());
            System.out.println("Health Code: " + ts.getStage());
            System.out.println("City: " + ts.getCity());
        }
    }
    public void retrieveTester(long n){
        tester ts = null;
        for (tester t : testers){
            if (t.getID() == n){
                ts = t;
            }
        }
        System.out.println("Name: " + ts.getName());
        System.out.println("Age: " + ts.getAge());
        System.out.println("Health Code: " + ts.getStage());
    }
    public void deleteTester(long ID){
        tester shallBeDeleted = null;
        for (tester ts : testers){
            if (ts.getID() == ID){
                shallBeDeleted = ts;
            }
        }
        testers.remove(shallBeDeleted);
    }
    public ArrayList<tester> getTesters() {
        return testers;
    }
    public tester getTester (long ID) {
        for (tester t : testers) {
            if (t.getID() == ID) {
                return t;
            }
        }
        System.out.println("No one has such ID!");
        return null;
    }
}
