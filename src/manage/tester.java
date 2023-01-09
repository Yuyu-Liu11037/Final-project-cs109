package manage;

public class tester {
    private long ID;
    private String name;
    private int age;
    private String city;
    private String stage = "GREEN";

    tester(long ID, String name, int age, String stage, String city){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.stage = stage;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCity() {
        return city;
    }
}
