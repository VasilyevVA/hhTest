import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {

    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData = $x("//span[@data-qa='resume-personal-address']/ancestor::p");
    private final SelenideElement tick = $x("//div[@data-qa='resume-contacts-phone']/span[1]");

    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String CONFIRMED_PRONE = "Подтвержденный номер";
    public static String READY_TO_RELOCATE = "Готовность к переезду";

    public HhResumePage(String url) {
        Selenide.open(url);
    }


    public Map<String, Object> getAttributes() {
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put(GENDER, getGender());
//        attributes.put(AGE, getAge());
//        attributes.put(CITY, getCity());
//        attributes.put(CONFIRMED_PRONE, isPhoneConfirmed());
//        attributes.put(READY_TO_RELOCATE, isReadyToRelocate());
//        return attributes;

        //Сокращенная форма записи
        return new HashMap<>(){{
            put(GENDER, getGender());
            put(AGE, getAge());
            put(CITY, getCity());
            put(CONFIRMED_PRONE, isPhoneConfirmed());
            put(READY_TO_RELOCATE, isReadyToRelocate());
        }};
    }


    public boolean isPhoneConfirmed() {
        return tick.isDisplayed();
    }


    public boolean isReadyToRelocate() {
//        String[] array = liveData.getText().split(", ");
//        String relocate = array[2];
//        return false;

        //запись в одну строку
        return !liveData.getText().split(", ")[1].equals("не готов к переезду");
    }


    public String getCity() {
        return city.getText();
    }


    public int getAge() {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }


    // 1-ый способ получения буквы "М" из слова "Мужчина"
//    public String getGender() {
//
//        String genderValue = gender.getText();
//        if(genderValue == "Мужчина") {
//            return "М";
//        }
//        return "Ж";
//
//    }


    // 2-ой способ получения буквы "М" из слова "Мужчина"
    public String getGender() {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

}
