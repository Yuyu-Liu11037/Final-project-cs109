package test;
import manage.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* CurrentStage:
        * 0: choose management
        * 1: location management
        * 2: person management
        * 3: nucleic acid testing management
        * 4: add location
        * 5: search location
        * 6: remove location
        * 7: add person
        * 8: search person
        * 9: remove person
        * 10: add nucleic acid testing
        * 11: search nucleic acid testing
        *
        * 13: retrieve all locations
        * 14: retrieve location by ID
        * 15: retrieve all people
        * 16: retrieve person by ID
        * 17: add single test
        * 18: add mixed test
        * 19: add 10 people
        * 29: add one person*/
        int currentStage = 0;
        int n = 0;
        long m = 0;
        String tr;
        resultManage resultManage = new resultManage();
        Scanner scanner = new Scanner(System.in);

        while (true){
            switch (currentStage){
                case 0:
                    System.out.println("Please input an operation [0-3]:");
                    System.out.println("1. Location management");
                    System.out.println("2. Person management");
                    System.out.println("3. Nucleic Acid Testing management");
                    System.out.println("0. Quit");
                    n = scanner.nextInt();
                    switch (n) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            currentStage = 1;
                            break;
                        case 2:
                            currentStage = 2;
                            break;
                        case 3:
                            currentStage = 3;
                            break;
                    }
                    break;
                case 1:
                    System.out.println("Please input an operation number[0-3]:");
                    System.out.println("1. Add location:");
                    System.out.println("2. Search location:");
                    System.out.println("3. Remove location:");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 0:
                            currentStage = 0;
                            break;
                        case 1:
                            currentStage = 4;
                            break;
                        case 2:
                            currentStage = 5;
                            break;
                        case 3:
                            currentStage = 6;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Please input an operation number [0-3]:");
                    System.out.println("1. Add person:");
                    System.out.println("2. Search person:");
                    System.out.println("3. Remove person:");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 0:
                            currentStage = 0;
                            break;
                        case 1:
                            currentStage = 7;
                            break;
                        case 2:
                            currentStage = 8;
                            break;
                        case 3:
                            currentStage = 9;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Please input an operation number [0-2]:");
                    System.out.println("1. Add nucleic acid testing:");
                    System.out.println("2. Search nucleic acid testing:");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 0:
                            currentStage = 0;
                            break;
                        case 1:
                            currentStage = 10;
                            break;
                        case 2:
                            currentStage = 11;
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Please add a location (input ID, City, Name, Date, Time, separated by one space):");
                    scanner.nextLine();
                    String input = scanner.nextLine();
                    resultManage.siteManage.addTestingSite(input);
                    currentStage = 1;
                    break;
                case 5:
                    System.out.println("Please choose how to retrieve:");
                    System.out.println("1. retrieve all locations");
                    System.out.println("2. retrieve by ID");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 1:
                            currentStage = 13;
                            break;
                        case 2:
                            currentStage = 14;
                            break;
                        case 0:
                            currentStage = 1;
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Please input the ID of location you want to delete:");
                    scanner.nextLine();
                    n = Integer.parseInt(scanner.nextLine());
                    resultManage.siteManage.deleteTestingSite(n);
                    currentStage = 1;
                    break;
                case 7:
                    System.out.println("Please choose how to add:");
                    System.out.println("1. add single person");
                    System.out.println("2. add 10 people");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n) {
                        case 1:
                            currentStage = 20;
                            break;
                        case 2:
                            currentStage = 19;
                            break;
                        case 0:
                            currentStage = 2;
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Please choose how to retrieve:");
                    System.out.println("1. retrieve all people");
                    System.out.println("2. retrieve by ID");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 1:
                            currentStage = 15;
                            break;
                        case 2:
                            currentStage = 16;
                            break;
                        case 0:
                            currentStage = 2;
                            break;
                    }
                    break;
                case 9:
                    System.out.println("Please input the ID of person you want to delete:");
                    scanner.nextLine();
                    m = Long.parseLong(scanner.nextLine());
                    resultManage.personManage.deleteTester(m);
                    currentStage = 2;
                    break;
                case 10:
                    System.out.println("Please choose how to add:");
                    System.out.println("1. add single test");
                    System.out.println("2. add mixed test");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 1:
                            currentStage = 17;
                            break;
                        case 2:
                            currentStage = 18;
                            break;
                        case 0:
                            currentStage = 3;
                    }
                    break;
                case 11:
                    System.out.println("Please choose how to retrieve:");
                    System.out.println("1. retrieve all results");
                    System.out.println("2. retrieve by test side ID");
                    System.out.println("3. retrieve by person ID");
                    System.out.println("4. retrieve by test date");
                    System.out.println("5. retrieve by test result");
                    System.out.println("6. retrieve by multiple properties");
                    System.out.println("0. Back to the previous directory");
                    n = scanner.nextInt();
                    switch (n){
                        case 0:
                            currentStage = 3;
                            break;
                        case 1:
                            resultManage.retrieveAllResults();
                            break;
                        case 2:
                            System.out.println("Please input test side ID (int ID):");
                            scanner.nextLine();
                            n = scanner.nextInt();
                            resultManage.retrieveResultByTSID(n);
                            break;
                        case 3:
                            System.out.println("Please input person ID (long ID):");
                            scanner.nextLine();
                            m = scanner.nextLong();
                            resultManage.retrieveResultByTesterID(m);
                            break;
                        case 4:
                            System.out.println("Please input test date (String date)");
                            scanner.nextLine();
                            String date = scanner.nextLine();
                            resultManage.retrieveResultByDate(date);
                            break;
                        case 5:
                            System.out.println("Please input test result (\"positive\" or \"negative\")");
                            scanner.nextLine();
                            tr = scanner.nextLine();
                            resultManage.retrieveResultByResult(tr);
                            break;
                        case 6:
                            System.out.println("Please input multiple properties (testSide,tester,testDate,test result (type \"null\" where the attribute is not retrieved) separated by \",\"):");
                            scanner.nextLine();
                            tr = scanner.nextLine();
                            resultManage.retrieveResult(tr);
                            break;
                    }
                    break;
                case 13:
                    resultManage.siteManage.retrieveTestingSite();
                    currentStage = 5;
                    break;
                case 14:
                    System.out.println("Please input the ID of location:");
                    scanner.nextLine();
                    n = Integer.parseInt(scanner.nextLine());
                    resultManage.siteManage.retrieveTestingSite(n);
                    currentStage = 5;
                    break;
                case 15:
                    resultManage.personManage.retrieveTester();
                    currentStage = 8;
                    break;
                case 16:
                    System.out.println("Please input the ID of person:");
                    scanner.nextLine();
                    m = Long.parseLong(scanner.nextLine());
                    resultManage.personManage.retrieveTester(m);
                    currentStage = 8;
                    break;
                case 17:
                    System.out.println("Please add a result (input testingSiteID, personID, date, time, test result, separated by one space)");
                    scanner.nextLine();
                    input = scanner.nextLine();
                    resultManage.addResult(input);
                    currentStage = 3;
                    break;
                case 18:
                    System.out.println("Please add 10 results (input testingSiteID, personID, date, time, test result, separated by one space):");
                    scanner.nextLine();
                    String[] inputs = new String[10];
                    for (int i = 0; i<10 ; i++){
                        inputs[i] = scanner.nextLine();
                    }
                    resultManage.addResults(inputs);
                    currentStage = 10;
                    break;
                case 19:
                    System.out.println("Please add 10 people:");
                    scanner.nextLine();
                    String[] inputs2 = new String[10];
                    for (int i = 0; i<10 ; i++){
                        inputs2[i] = scanner.nextLine();
                    }
                    resultManage.personManage.addTesters(inputs2);
                    currentStage = 7;
                    break;
                case 20:
                    System.out.println("Please add a person (input ID, name, age, stage, city, separated by one space)");
                    scanner.nextLine();
                    input = scanner.nextLine();
                    resultManage.personManage.addTester(input);
                    currentStage = 7;
                    break;
            }
        }
    }
}
