#  Flipkart Automation using Selenium WebDriver (Java)

Automates the end-to-end user flow on Flipkart — from searching a product to initiating the EMI login flow — using Selenium WebDriver with Java.

# Project Flow

Launch Flipkart->
Close Login Popup (ESC)
     ->
Search "mobile" → Apply Filter
     ->
Click Apple iPhone 17
     ->
Switch to New Tab (Multi-Window Handling)
     ->
Scroll to "Buy with EMI"
     ->
Click "Buy with EMI"
     ->
Enter Phone Number in Login Popup


# Key Highlights

# 1. Auto-close Login Popup
Used `Keys.ESCAPE` on page load to automatically dismiss the Flipkart login popup without manual intervention.

# 2. Product Search & Filter
Automated the search bar using `By.name("q")` and applied product filters using class-based locators.

# 3.  Multi-Tab Handling
Flipkart opens the product page in a **new tab**. Handled this by:
- Calling `getWindowHandles()` **after** the click to capture new tab handle
- Using `switchTo().window(tabs.get(1))` to shift driver context to product page

# java
wait.until(ExpectedConditions.numberOfWindowsToBe(2));
ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));


# 4. JavaScript Executor for Scrolling
Used `JavascriptExecutor` with `scrollIntoView()` to scroll precisely to the "Buy with EMI" element.

# javaScript
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);


# 5. Dynamic Element Handling
Used `WebDriverWait` with `ExpectedConditions` throughout instead of fixed `Thread.sleep()` for reliable and fast element detection.

# 6.  Login Flow Automation
- Handled the EMI popup login form
- Used **stable XPath** (`@type='text'`) instead of fragile class names that Flipkart changes frequently
- Used `Actions` class to interact with React-based input fields




# 7.  Locator Strategies Used
| Locator | Used For |
|---|---|
| `By.name` | Search bar |
| `By.className` | Filter button |
| `By.tagName` | Body (ESC popup) |
| `By.xpath` | Product title, Buy with EMI, Phone input |
| `contains()` | Partial text matching |
| `normalize-space()` | Whitespace-safe text matching |


# Tech Stack

| Tool | Version 
| Java | JDK 24 
| Selenium WebDriver | 4.29.0 
| ChromeDriver | 145 
| Maven | 3.x 
| IDE | IntelliJ IDEA 
| OS | Windows 11 |

# How to Run

# Prerequisites
- Java JDK 17+
- Maven installed
- Google Chrome browser installed

# Steps

```bash
# 1. Clone the repository
git clone https://github.com/Manojnalla-gh/Flipkart-Automation.git

# 2. Navigate to project
cd Flipkart-Automation

# 3. Install dependencies
mvn clean install

# 4. Run the project
mvn exec:java -Dexec.mainClass="edu.school.project.Main"
```

Or simply open in **IntelliJ IDEA** and click ▶ Run.

---

# Project Structure

```
flipkart-automation/
├── src/
│   └── main/
│       └── java/
│           └── edu/school/project/
│               └── Main.java          ← Main automation script
├── pom.xml                            ← Maven dependencies
└── README.md                          ← Project documentation
```

---

#  Notes

- Flipkart class names (like `buvtMR`) change frequently — if selectors break, re-inspect and update XPath
- `getWindowHandles()` must always be called **after** clicking the product link
- Use `@type='text'` or `@placeholder` based XPaths for login inputs — more stable than class names
- This project is for **educational purposes only**

---

# Author
*Manoj*  
Selenium WebDriver Automation — Learning Project
