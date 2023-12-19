package homework.homework08;

public class SubscriberServiceImpl implements SubscriberService {
    private Subscriber[] items;

    public Subscriber[] getItems() {
        return items;
    }

    public void setItems(Subscriber[] items) {
        this.items = items;
    }

    @Override
    public void printCityCallDurationOver(int duration) {
        for (Subscriber item : items) {
            if (item.getCityCallDuration() > duration)
                System.out.println(item + " - CityCallDuration=" + item.getCityCallDuration());
        }
    }

    @Override
    public void printInterCityCallDurationOver(int duration) {
        for (Subscriber item : items) {
            if (item.getInterCityCallDuration() > 0)
                System.out.println(item + " - InterCityCallDuration=" + item.getInterCityCallDuration());
        }
    }

    @Override
    public void printByFirstLetterOfLastName(String startLastName) {
        for (Subscriber item : items) {
            if (item.getLastName().toLowerCase().startsWith(startLastName.toLowerCase()))
                System.out.println(item);
        }
    }

    @Override
    public void printInternetTrafficOfCity(String city) {
        double sum = 0;
        for (Subscriber item : items) {
            if (item.getCity().equalsIgnoreCase(city)) {
                sum += item.getInternetTraffic();
                System.out.println(item);
            }
        }
        System.out.println("InternetTraffic of " + city + " is " + sum);
    }

    @Override
    public void printIfNegativeBalance() {
        for (Subscriber item : items) {
            if (item.getBalance() < 0)
                System.out.println(item);
        }
    }
}
