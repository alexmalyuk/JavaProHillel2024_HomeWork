package homework.homework08;

public class Subscriber {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private String phoneNumber;
    private String contractNumber;
    private double balance;
    private int cityCallDuration;
    private int interCityCallDuration;
    private int internetTraffic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCityCallDuration() {
        return cityCallDuration;
    }

    public void setCityCallDuration(int cityCallDuration) {
        this.cityCallDuration = cityCallDuration;
    }

    public int getInterCityCallDuration() {
        return interCityCallDuration;
    }

    public void setInterCityCallDuration(int interCityCallDuration) {
        this.interCityCallDuration = interCityCallDuration;
    }

    public int getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(int internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    public Subscriber() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + phoneNumber + " balance " + balance;
    }
}
