package manage;

import java.util.ArrayList;
import java.util.ListIterator;

public class resultManage {
    ArrayList<result> results = new ArrayList<>();
    public testingSiteManage siteManage = new testingSiteManage();
    ArrayList<testingSite> testingSites = siteManage.getTestingSites();
    public testerManage personManage = new testerManage();
    ArrayList<tester> testers = personManage.getTesters();
    ListIterator<result> resultListIterator;
    // input: testingSiteID testerID testingDate testingTime testResult
    public void addResult(String input){
        String[] inputString = input.split(" ");
        testingSite ts = siteManage.getTestingSite(Integer.parseInt(inputString[0]));
        tester person = personManage.getTester(Long.parseLong(inputString[1]));
        if (inputString[4].equals("positive")){
            person.setStage("RED");
        }
        // conflict management
        result r = new result(ts, person, inputString[2], inputString[3], "single", inputString[4]);
        if (!r.getSite().getCity().equals(r.getPerson().getCity())){
            System.out.println("City not compatible!");
            return;
        }
        if (!r.getSite().getOpeningDate().equals(r.getDate())){
            System.out.println("Date not compatible!");
            return;
        }
        if (!checkTestTime(r.getTime(),r.getSite().getOpeningTime())){
            System.out.println("Time not available!");
            return;
        }
        if (results.size() == 0) {
            results.add(r);
            return;
        }
        resultListIterator = results.listIterator();
        while (resultListIterator.hasNext()) {
            result re = resultListIterator.next();
            if (re.getDate().equals(r.getDate()) && re.getTime().equals(r.getTime()) && re.getTestResult().equals(r.getTestResult()) && (re.getSite().getID() == r.getSite().getID() && re.getSite().getCity().equals(r.getSite().getCity()) && re.getSite().getTestingSiteName().equals(r.getSite().getTestingSiteName()) && re.getSite().getOpeningDate().equals(r.getSite().getOpeningDate()) && re.getSite().getOpeningTime().equals(r.getSite().getOpeningTime())) && (r.getPerson().getID() == re.getPerson().getID() && r.getPerson().getCity().equals(re.getPerson().getCity()) && r.getPerson().getName().equals(re.getPerson().getName()) && r.getPerson().getAge() == re.getPerson().getAge() && r.getPerson().getStage().equals(re.getPerson().getStage()))){
                System.out.println("Duplicate testing result!");
                return;
            } else if (re.getPerson().getName().equals(r.getPerson().getName())) {
                if (re.getDate().equals(r.getDate())){
                    System.out.println("Same person test two times one day!");
                    return;
                }
            }
        }
        resultListIterator.add(r);
    }
    /* input: 5*10 array
    *  testingSiteID testerID testingDate testingTime testResult
    * */
    public void addResults(String[] input){
        for (int i = 0 ; i < 10 ; i++){
            String[] inputString = input[i].split(" ");
            testingSite ts = siteManage.getTestingSite(Integer.parseInt(inputString[0]));
            tester person = personManage.getTester(Long.parseLong(inputString[1]));
            if (inputString.equals("positive")){
                person.setStage("YELLOW");
            }
            // conflict management
            result r = new result(ts, person, inputString[2], inputString[3], "mixed", inputString[4]);
            if (!r.getSite().getCity().equals(r.getPerson().getCity())){
                System.out.println("City not compatible!");
                return;
            } else if (!r.getSite().getOpeningDate().equals(r.getDate())){
                System.out.println("Date not compatible!");
                return;
            } else if (!checkTestTime(r.getTime(),r.getSite().getOpeningTime())){
                System.out.println("Time not available!");
                return;
            } else if (results != null){
                for (result re : results){
                    if (r.getPerson().getName().equals(re.getPerson().getName())){
                        System.out.println("Duplicate person!");
                        return;
                    } else if (re.getPerson().getName().equals(r.getPerson().getName())){
                        if (re.getDate().equals(r.getDate())){
                            System.out.println("Same person test two times one day!");
                            return;
                        }
                    } else if (re.getDate().equals(r.getDate()) && re.getTime().equals(r.getTime()) && re.getTestResult().equals(r.getTestResult()) && (re.getSite().getID() == r.getSite().getID() && re.getSite().getCity().equals(r.getSite().getCity()) && re.getSite().getTestingSiteName().equals(r.getSite().getTestingSiteName()) && re.getSite().getOpeningDate().equals(r.getSite().getOpeningDate()) && re.getSite().getOpeningTime().equals(r.getSite().getOpeningTime())) && (r.getPerson().getID() == re.getPerson().getID() && r.getPerson().getCity().equals(re.getPerson().getCity()) && r.getPerson().getName().equals(re.getPerson().getName()) && r.getPerson().getAge() == re.getPerson().getAge() && r.getPerson().getStage().equals(re.getPerson().getStage()))){
                        System.out.println("Duplicate testing result!");
                        return;
                    }
                }
            }
            results.add(r);
        }
    }
    public void retrieveAllResults(){
        int i = 1;
        for (result r : results){
            System.out.println("RESULT " + i);
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
            System.out.println();
            i++;
        }
    }
    public void retrieveResultByTSID(int testSiteID){
        ArrayList<result> testResult = null;
        for (result r : results){
            if (r.getSite().getID() == testSiteID){
                testResult.add(r);
            }
        }
        for (result r : testResult){
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
        }
    }
    public void retrieveResultByTesterID(long testerID){
        ArrayList<result> testResult = null;
        for (result r : results){
            if (r.getPerson().getID() == testerID){
                testResult.add(r);
            }
        }
        for (result r : testResult){
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
        }
    }
    public void retrieveResultByDate(String testDate){
        ArrayList<result> testResult = null;
        for (result r : results){
            if (r.getSite().getOpeningDate().equals(testDate)){
                testResult.add(r);
            }
        }
        for (result r : testResult){
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
        }
    }
    public void retrieveResultByResult(String result){
        ArrayList<result> testResult = null;
        for (result r : results){
            if (r.getPerson().equals(result)){
                testResult.add(r);
            }
        }
        for (result r : testResult){
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
        }
    }
    // input : testSide,tester,testDate,test result
    public void retrieveResult(String input){
        String[] inputString = input.split(",");
        ArrayList<result> testResult = results;
        if (inputString[0] != null){
            for (result r : testResult){
                if (r.getSite().getID() != Integer.parseInt(inputString[0])){
                    testResult.remove(r);
                }
            }
        }
        if (inputString[1] != null){
            for (result r : testResult){
                if (r.getPerson().getID() != Long.parseLong(inputString[1])){
                    testResult.remove(r);
                }
            }
        }
        if (inputString[2] != null){
            for (result r : testResult){
                if (!r.getSite().getOpeningDate().equals(inputString[2])){
                    testResult.remove(r);
                }
            }
        }
        if (inputString[3] != null){
            for (result r : testResult){
                if (!r.getPerson().getStage().equals(inputString[3])){
                    testResult.remove(r);
                }
            }
        }
        for (result r : testResult){
            System.out.println("Test site: " + r.getSite().getTestingSiteName());
            System.out.println("Test city: " + r.getSite().getCity());
            System.out.println("Person name: " + r.getPerson().getName());
            System.out.println("Person ID: " + r.getPerson().getID());
            System.out.println("Test date: " + r.getDate());
            System.out.println("Test result: " + r.getTestResult());
        }
    }
    public tester getPersonByID(long ID){
        tester temp = null;
        for (tester ter : testers){
            if (ter.getID() == ID){
                temp = ter;
            } else {
                return null;
            }
        }
        return temp;
    }
    public boolean checkTestTime (String testTime, String openingTime){
        StringBuffer stringBuffer = new StringBuffer();
        char[] testTimeChar = new char[5];
        for (int i = 0 ; i < 5 ; i++) {
            testTimeChar[i] = testTime.charAt(i);
        }

        stringBuffer.append(testTimeChar[0]);
        stringBuffer.append(testTimeChar[1]);
        int testHour = Integer.parseInt(stringBuffer.toString());
        stringBuffer.setLength(0);

        char[] openingTimeChar = new char[11];
        for (int i = 0 ; i < 11 ; i++){
            openingTimeChar[i] = openingTime.charAt(i);
        }

        stringBuffer.append(openingTimeChar[0]);
        stringBuffer.append(openingTimeChar[1]);
        int openingHour = Integer.parseInt(stringBuffer.toString());
        stringBuffer.setLength(0);

        stringBuffer.append(openingTimeChar[6]);
        stringBuffer.append(openingTimeChar[7]);
        int closeHour = Integer.parseInt(stringBuffer.toString());
        stringBuffer.setLength(0);

        if (openingHour <= testHour && testHour <= closeHour) {
            return true;
        } else {
            return false;
        }
    }
}
