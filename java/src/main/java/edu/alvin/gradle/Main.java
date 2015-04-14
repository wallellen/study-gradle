package edu.alvin.gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private int number;

	public Main(int number) {
		this.number = number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}

	public static void main(String[] args) {
		Main main = new Main(100);
        LOGGER.info("Hello, the value is: " + main.getNumber());
	}
}