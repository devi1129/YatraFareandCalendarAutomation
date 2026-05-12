package com.Yatra;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YatraTest {

	@Test
	public void test() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement departureElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@aria-label='Departure Date inputbox' and @role='button']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", departureElement);

		departureElement.click();

		List<WebElement> monthList = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='react-datepicker__month']")));

		List<WebElement> currentDates = selectmonth(wait, 0, monthList);

		List<WebElement> nextDates = selectmonth(wait, 1, monthList);

		List<String> currentlist = findlowestdate(currentDates);
		List<String> nextlist = findlowestdate(nextDates);

		String lowestvalue = Integer.parseInt(currentlist.get(1)) < Integer.parseInt(nextlist.get(1))
				? currentlist.get(0)
				: nextlist.get(0);

		System.out.println("Lowest value is " + lowestvalue);

		

	}

	public List<WebElement> selectmonth(WebDriverWait wait, int index, List<WebElement> monthList) {

		List<WebElement> dates = monthList.get(index)
				.findElements(By.xpath(".//div[contains(@class,'react-datepicker__day') and @role='option']"));

		return dates;
	}

	public List<String> findlowestdate(List<WebElement> dates) {

		int lowest_current = Integer.MAX_VALUE;
		WebElement lowest_price_element = null;

		for (WebElement element : dates) {

			try {

				WebElement priceElement = element
						.findElement(By.xpath(".//span[contains(@class,'custom-day-content')]"));

				System.out.println(priceElement.getText());

				int price = Integer.parseInt(priceElement.getText().replaceAll("[^0-9]", ""));
				if (price < lowest_current) {
					lowest_current = price;
					lowest_price_element = element;
				}

			} catch (Exception e) {

				System.out.println("Price not available");

			}
		}

		System.out.println("Lowest price: " + lowest_current);
		String finalDate = null;
		if (lowest_price_element != null) {
			String dateValue = lowest_price_element.getAttribute("aria-label");

			String[] arr = dateValue.split(",");

			String monthDate = arr[1].trim().replaceAll("(st|nd|rd|th)", "");

			String year = arr[2].trim();

			finalDate = monthDate + " " + year;

			System.out.println(finalDate);
		}

		List<String> list = new ArrayList<>();
		list.add(finalDate);
		list.add(String.valueOf(lowest_current));
		return list;

	}

}
