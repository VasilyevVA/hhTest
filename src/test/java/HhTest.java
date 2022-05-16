import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseTest {

    private final static String URL = "https://tomsk.hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

    @Test
    public void checkAttributesHashMap() {
        HhResumePage hhResumePage = new HhResumePage(URL);

        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, 26);
        expectedAttributes.put(HhResumePage.CITY, "Санкт-Петербург");
        expectedAttributes.put(HhResumePage.CONFIRMED_PRONE, true);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String, Object> actualAttributes = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void checkAttributesClass() {
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedAttributes = new Resume("М", 26, "Санкт-Петербург",
                true, false);
        Resume actualAttributes = new Resume(hhResumePage.getGender(), hhResumePage.getAge(), hhResumePage.getCity(),
                hhResumePage.isPhoneConfirmed(), hhResumePage.isReadyToRelocate());

        Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));
    }

}
