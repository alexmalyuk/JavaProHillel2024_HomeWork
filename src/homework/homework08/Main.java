package homework.homework08;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SubscriberServiceImpl subscriberService = new SubscriberServiceImpl();
        subscriberService.setItems(SubscriberGenerator.generateItems());
        System.out.println(Arrays.toString(subscriberService.getItems()));

        subscriberService.printCityCallDurationOver(200);
        subscriberService.printInterCityCallDurationOver(0);
        subscriberService.printByFirstLetterOfLastName("m");
        subscriberService.printInternetTrafficOfCity("liverpool");
        subscriberService.printIfNegativeBalance();
    }

}
