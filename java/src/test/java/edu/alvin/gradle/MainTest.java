package edu.alvin.gradle;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void testSetNumber() throws Exception {
        Main main = new Main(0);
        main.setNumber(123);
        assertThat(main.getNumber(), is(123));
    }

    @Test
    public void testGetNumber() throws Exception {
        Main main = new Main(99);
        assertThat(main.getNumber(), is(99));
    }

    @Test
    public void testSystemProperties() throws Exception {
        assertThat(System.getProperty("test-name"), is("Alvin"));
        assertThat(System.getProperty("test-key"), is("100"));
    }
}