public class Resume {

    private String gender;
    private int age;
    private String city;
    boolean isPhoneNumberConfirmed;
    boolean isReadyToRelocate;

    public Resume(String gender, int age, String city, boolean isPhoneNumberConfirmed, boolean isReadyToRelocate) {
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.isPhoneNumberConfirmed = isPhoneNumberConfirmed;
        this.isReadyToRelocate = isReadyToRelocate;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean isPhoneNumberConfirmed() {
        return isPhoneNumberConfirmed;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }
}
