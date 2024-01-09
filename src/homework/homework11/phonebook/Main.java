package homework.homework11.phonebook;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Леонід Кравчук", "0950001122"));
        phoneBook.add("Леонід Кравчук",     "0678901234");
        phoneBook.add("Вячеслав Чорновіл",  "0679586868");
        phoneBook.add("Леонід Кучма",       "0671234567");
        phoneBook.add("Валентина Семенюк",  "0631598742");
        phoneBook.add("Олег Тягнибок",      "0663216589");
        phoneBook.add("Іван Плющ",          "0443221111");
        phoneBook.add("Ігор Гетьман",       "0503694512");
        phoneBook.add("Віктор Ющенко",      "0689512684");
        phoneBook.add("Степан Хмара",       "0654672839");
        phoneBook.add(null);

        System.out.println(phoneBook.find(null));
        System.out.println(phoneBook.find("Іван ПЛЮЩ"));
        System.out.println(phoneBook.find("Олег Тягни-бік"));

        System.out.println(phoneBook.findAll(null));
        System.out.println(phoneBook.findAll("Леонід КРАВчук"));
        System.out.println(phoneBook.findAll("Леонід НЕКРАВ чук"));
    }
}
