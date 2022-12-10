package StepDefinitions.ReqResDotIn.RequestBodyObjects;

public class User {
    private final String name;
    private final String job;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

}
