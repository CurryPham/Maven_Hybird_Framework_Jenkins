package pageUls.nopCommerce.user;

public class BasePageUI {
	public static final String ADDRESS_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String REWARD_POINT_LINK = "xpath=//div[@class='listbox']//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[text()='Log out']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String NAV_ICON = "xpath=//i[@class='fas fa-cogs']";

	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='listbox']//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";

}
