package com.training.cleancode.e20;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 17/04/2018
 */
public class NameInverterTest {

    private final NameInverter nameInverter = new NameInverter();

    @Test
    public void invertNull_returnEmptyString() throws Exception {
        assertEquals("", nameInverter.invert(null));
    }

    @Test
    public void invertEmptyString_returnEmpty() throws Exception {
        assertEquals("", nameInverter.invert(""));
    }

    @Test
    public void invertFirstName_returnFirstName() throws Exception {
        assertEquals("Name", nameInverter.invert("Name"));
    }

    @Test
    public void invertFirstLast_returnLastFirst() throws Exception {
        assertEquals("Last, First", nameInverter.invert("First Last"));
    }

    @Test
    public void removeExtraSpacesAfterInvert() throws Exception {
        assertEquals("Name", nameInverter.invert("    Name  "));
        assertEquals("Last, First", nameInverter.invert("   First    Last    "));
    }

    @Test
    public void ignoreHonorifics() throws Exception {
        assertEquals("Last, First", nameInverter.invert("Mr. First Last"));
        assertEquals("Last, First", nameInverter.invert("Mis. First Last"));
    }

    @Test
    public void postNominals_stayAtEnd() throws Exception {
        assertEquals("Last, First Sr.", nameInverter.invert("First Last Sr."));
        assertEquals("Last, First Phd.", nameInverter.invert("First Last Phd."));
    }

    @Test
    public void integrateTest() throws Exception {
        assertEquals("Pishgah, Arya Phd.", nameInverter.invert("     Mr.  Arya       Pishgah     Phd."));
    }

}
