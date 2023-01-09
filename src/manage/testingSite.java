package manage;

public class testingSite {
    private int ID;
    private String city;
    private String testingSiteName;
    private String openingDate;
    private String openingTime;

    testingSite(int ID, String city, String testingSiteName, String openingDate, String openingTime){
        this.ID = ID;
        this.city = city;
        this.testingSiteName = testingSiteName;
        this.openingDate = openingDate;
        this.openingTime = openingTime;
    }

    public int getID() {
        return ID;
    }

    public String getCity() {
        return city;
    }

    public String getTestingSiteName() {
        return testingSiteName;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }
}
