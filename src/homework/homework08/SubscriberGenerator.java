package homework.homework08;

import java.util.Random;

public class SubscriberGenerator {

    private SubscriberGenerator() {
    }

    public static Subscriber[] generateItems() {

        Subscriber s1 = new Subscriber();
        s1.setId(978);
        s1.setFirstName("John");
        s1.setLastName("Lennon");
        s1.setCity("Liverpool");
        s1.setPhoneNumber("(555) 123-4567");
        s1.setContractNumber("123");
        s1.setBalance(-100);
        s1.setCityCallDuration(0);
        s1.setInterCityCallDuration(10);
        s1.setInternetTraffic(1000);

        Subscriber s2 = new Subscriber();
        s2.setId(979);
        s2.setFirstName("Paul");
        s2.setLastName("McCartney");
        s2.setCity("Liverpool");
        s2.setPhoneNumber("(555) 987-6543");
        s2.setContractNumber("456");
        s2.setBalance(200);
        s2.setCityCallDuration(10);
        s2.setInterCityCallDuration(15);
        s2.setInternetTraffic(15);

        Subscriber s3 = new Subscriber();
        s3.setId(980);
        s3.setFirstName("Bob");
        s3.setLastName("Dylan");
        s3.setCity("New York");
        s3.setPhoneNumber("(555) 555-5555");
        s3.setContractNumber("789");
        s3.setBalance(1200);
        s3.setCityCallDuration(105);
        s3.setInterCityCallDuration(0);
        s3.setInternetTraffic(500);

        Subscriber s4 = new Subscriber();
        s4.setId(981);
        s4.setFirstName("Michael");
        s4.setLastName("Jackson");
        s4.setCity("Los Angeles");
        s4.setPhoneNumber("(555) 111-2222");
        s4.setContractNumber("357");
        s4.setBalance(-80.5);
        s4.setCityCallDuration(500);
        s4.setInterCityCallDuration(300);
        s4.setInternetTraffic(200);

        Subscriber s5 = new Subscriber();
        s5.setId(982);
        s5.setFirstName("Freddie");
        s5.setLastName("Mercury");
        s5.setCity("London");
        s5.setPhoneNumber("(555) 333-4444");
        s5.setContractNumber("159");
        s5.setBalance(1000);
        s5.setCityCallDuration(5000);
        s5.setInterCityCallDuration(3000);
        s5.setInternetTraffic(2000);

        return new Subscriber[]{s1, s2, s3, s4, s5};
    }
}
