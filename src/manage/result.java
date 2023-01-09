package manage;

public class result {
    private testingSite site;
    private tester person;
    private String type;
    private String date;
    private String time;
    private String testResult = "negative";
    result(testingSite site, tester person, String date, String time, String type, String testResult){
        this.site = site;
        this.person = person;
        this.type = type;
        this.testResult = testResult;
        this.date = date;
        this.time = time;
    }
    public testingSite getSite() {
        return site;
    }
    public tester getPerson() {
        return person;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTestResult() {
        return testResult;
    }
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
