package utilities;

import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Internet;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	Address address = faker.address();
	Internet internet = faker.internet();

	public String getFirstName() {
		return address.firstName();
	}

	public String getLastName() {
		return address.lastName();
	}

	public String getEmailAddress() {
		return internet.emailAddress();
	}

	public String getCityName() {
		return address.city();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {

		return address.streetAddress();
	}

	public String getPassword() {
		return internet.password(8, 12, true, true);
	}

}
