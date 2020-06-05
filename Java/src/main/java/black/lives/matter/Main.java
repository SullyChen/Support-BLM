package black.lives.matter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final String[] POSSIBLE_QUERIES = {
        "short nature video", "short cat video", "short k-pop video",
        "short dog video", "short coronavirus video"
    };
    private static final String MAIN_URL = "https://youtube.com/watch?v=bCgLa25fDHM";
    private static final String BASE_URL = "https://youtube.com";
    private static final String SEARCH_URL = "https://youtube.com/results?search_query=";

    private static final int MAIN_SECONDS = 3386;
    private static final int MAX_SECONDARY_MINUTES = 10;
    private static final int PAGE_LOAD_DELAY = 2;

    private final static Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(Main.class.getName());
        LOGGER.setLevel(Level.INFO);
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$s] %5$s %n");
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String [] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--mute-audio");
        WebDriver driver = new ChromeDriver(options);
        Random random = new Random();
        WebElement body;
        boolean spacePressed = false;
        try {
            while (true) {
                // Open main video using Selenium
                LOGGER.info("Opening main video at " + MAIN_URL + ".");
                driver.get(MAIN_URL);
                waitFor(PAGE_LOAD_DELAY); 

                // Press 'space' to start the main video and wait for it to finish
                LOGGER.info("Playing main video for " + MAIN_SECONDS + " seconds.");
                body = driver.findElement(By.tagName("body"));
                if (!spacePressed) {
                    body.sendKeys(Keys.SPACE);
                    spacePressed = true;
                }
                waitFor(MAIN_SECONDS);

                // Select a random query from a list of possiblities
                String query = POSSIBLE_QUERIES[random.nextInt(POSSIBLE_QUERIES.length)];
                System.out.println(query);

                // Use Selenium to scrape search results from YouTube
                // Only look for videos less than MAX_SECONDARY_MINUTES in duration
                LOGGER.info("Searching for videos using query '" + query + "'.");
                driver.get(SEARCH_URL + query);
                waitFor(PAGE_LOAD_DELAY);
                Document document = Jsoup.parse(driver.getPageSource());
                Elements elements = document.select("a[href]");
                List<String> links = new ArrayList<>(); 
                List<Integer> linkDurations= new ArrayList<>();
                for (Element element : elements) {
                    String relLink = element.attr("href").toString();
                    String description = element.attr("aria-label").toString();
                    if (relLink.startsWith("/watch?v=")) {
                        for (int i = 0; i < MAX_SECONDARY_MINUTES; i++) {
                            if (description.contains(i + " minutes")) {
                                links.add(BASE_URL + relLink);
                                linkDurations.add((i + 1) * 60);
                            }
                        }
                    }
                }
                LOGGER.info("Found videos: " + links);
                LOGGER.info("Video durations: " + linkDurations);

                // Begin playing 3 - 5 secondary videos
                int numVideos = random.nextInt(3) + 3;
                LOGGER.info("Playing " + numVideos + " short videos.");
                for (int i = 0; i < numVideos; i++) {
                    int j = random.nextInt(links.size());
                    driver.get(links.get(j));
                    waitFor(PAGE_LOAD_DELAY);
                    body = driver.findElement(By.tagName("body"));
                    waitFor(linkDurations.get(j));
                }
            }
        } finally {
            driver.quit();
        }
    }
}
