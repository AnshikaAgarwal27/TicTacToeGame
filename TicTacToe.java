package game;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class TicTacToe {

   //static Properties propertyFile;
    static WebDriver driver;
    public static void main(String[] args) {
//        propertyFile = new Properties();
//        try {
//            FileInputStream input = new FileInputStream("config.properties");
//            propertyFile.load(input);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://playtictactoe.org/#google_vignette");
        pause(2);

       //xpath of the blocks which allows to perform actions i.e. click
        WebElement TopLeft = driver.findElement(By.xpath("//div[@class=\"square top left\"]"));
        WebElement TopCentre = driver.findElement(By.xpath("//div[@class=\"square top\"]"));
        WebElement TopRight = driver.findElement(By.xpath("//div[@class=\"square top right\"]"));
        WebElement Middle = driver.findElement(By.xpath("//div[@class=\"square\"]"));
        WebElement BottomLeft = driver.findElement(By.xpath("//div[@class=\"square bottom left\"]"));

        WebElement Bottomright = driver.findElement(By.xpath("//div[@class=\"square bottom right\"]"));
        WebElement LeftCentre = driver.findElement(By.xpath("//div[@class=\"square left\"]"));
        WebElement RightCentre = driver.findElement(By.xpath("//div[@class=\"square right\"]"));
        WebElement BottomCentre = driver.findElement(By.xpath("//div[@class=\"square bottom\"]"));

        //xpath of the blocks which stores the value of the block..whether o,x or nothing
        WebElement topLeftValue = driver.findElement(By.xpath("//div[@class=\"square top left\"]/div"));
        WebElement TopCentreValue = driver.findElement(By.xpath("//div[@class=\"square top\"]/div"));
        WebElement TopRightValue = driver.findElement(By.xpath("//div[@class=\"square top right\"]/div"));
        WebElement MiddleValue = driver.findElement(By.xpath("//div[@class=\"square\"]/div"));
        WebElement BottomLeftValue = driver.findElement(By.xpath("//div[@class=\"square bottom left\"]/div"));
        WebElement BottomrightValue = driver.findElement(By.xpath("//div[@class=\"square bottom right\"]/div"));
        WebElement LeftCentreValue = driver.findElement(By.xpath("//div[@class=\"square left\"]/div"));
        WebElement RightCentreValue = driver.findElement(By.xpath("//div[@class=\"square right\"]/div"));
        WebElement BottomCentreValue = driver.findElement(By.xpath("//div[@class=\"square bottom\"]/div"));


        //TopLeft.click();
        test t=new test(driver);
        t.click(1);
        pause(2);

        //values of block stored in String variables, it tells whether the o is enterd or not in that particular block
        String topCentreValue = TopCentreValue.getAttribute("class");
        System.out.println("topCentreValue: " + topCentreValue);
        String leftCentreValue = LeftCentreValue.getAttribute("class");
        System.out.println("leftCentreValue:" + leftCentreValue);
        String rightCentreValue = RightCentreValue.getAttribute("class");
        System.out.println("rightCentreValue" + rightCentreValue);
        String bottomCentreValue = BottomCentreValue.getAttribute("class");
        System.out.println("bottomCentreValue" + bottomCentreValue);
        String topRightValue = TopRightValue.getAttribute("class");
        System.out.println("topRightValue" + topRightValue);
        String bottomLeftValue = BottomLeftValue.getAttribute("class");
        System.out.println("bottomLeftValue" + bottomLeftValue);
        String bottomRightValue = BottomrightValue.getAttribute("class");
        System.out.println("bottomRightValue" + bottomRightValue);
        String middleValue;

        boolean i=false;

//        for (boolean i = false; i == true; ) {
        while (!i){
            if (topCentreValue.equalsIgnoreCase("o") || leftCentreValue.equalsIgnoreCase("o") || rightCentreValue.equalsIgnoreCase("o") || bottomCentreValue.equalsIgnoreCase("o")) {
                Middle.click();
                pause(2);

                topCentreValue = TopCentreValue.getAttribute("class");
                leftCentreValue = LeftCentreValue.getAttribute("class");
                System.out.println("leftCentreValue:" + leftCentreValue);
                bottomRightValue = BottomrightValue.getAttribute("class");
                System.out.println("bottomRightValue" + bottomRightValue);
                rightCentreValue = RightCentreValue.getAttribute("class");
                System.out.println("rightCentreValue" + rightCentreValue);
                bottomCentreValue = BottomCentreValue.getAttribute("class");
                System.out.println("bottomCentreValue" + bottomCentreValue);

                //if opponent is adjacent
                if (topCentreValue.equalsIgnoreCase("o") || leftCentreValue.equalsIgnoreCase("o")) {

                    //if (topCentreValue.equalsIgnoreCase("o") || bottomRightValue.equalsIgnoreCase("o")) {
                    if (topCentreValue.equalsIgnoreCase("o")) {

                        BottomLeft.click();
                        pause(5);
                        topRightValue = TopRightValue.getAttribute("class");
                        System.out.println("topRightValue" + topRightValue);

                        if (topRightValue.equalsIgnoreCase("o")) {
                            System.out.println("3");
                            LeftCentre.click();
                            pause(2);
                        } else {
                            System.out.println("4");
                            TopRight.click();
                            pause(2);
                        }
                    } else {
                        TopRight.click();
                        pause(5);

                        topCentreValue = TopCentreValue.getAttribute("class");
                        System.out.println("topCentreValue: " + topCentreValue);

                        if (topCentreValue.equalsIgnoreCase("o")) {
                            System.out.println("1");
                            BottomLeft.click();
                            pause(2);
                        } else {
                            System.out.println("4");
                            TopCentre.click();
                            pause(2);
                        }
                    }

                }
                //opponent at side center but not adjacent
                else if (bottomCentreValue.equalsIgnoreCase("o") || rightCentreValue.equalsIgnoreCase("o")) {

                    pause(2);

                    if (bottomCentreValue.equalsIgnoreCase("o")) {
                        BottomLeft.click();
                        pause(2);

                        topRightValue = TopRightValue.getAttribute("class");
                        System.out.println("topRightValue" + topRightValue);

                        if (topRightValue.equalsIgnoreCase("o")) {
                            LeftCentre.click();
                            pause(2);
                        } else {
                            TopRight.click();
                            pause(2);
                        }
                    } else {
                        TopRight.click();
                        pause(2);

                        topCentreValue = TopCentreValue.getAttribute("class");
                        if (topCentreValue.equalsIgnoreCase("o")) {
                            BottomLeft.click();
                            pause(2);
                        } else {
                            TopCentre.click();
                            pause(2);
                        }
                    }
                }
               // System.out.println("It's a win!!!");

                  i=true;
                pause(5);
            }
            // opponent at corner
            else if (topRightValue.equalsIgnoreCase("o") || bottomRightValue.equalsIgnoreCase("o") || bottomLeftValue.equalsIgnoreCase("o")) {
                //  i= true;
                if (topRightValue.equalsIgnoreCase("o")) {
                    BottomLeft.click();
                    pause(2);
                    Bottomright.click();
                    pause(2);

                    leftCentreValue = LeftCentreValue.getAttribute("class");
                    if (leftCentreValue.equalsIgnoreCase("o")) {
                        middleValue = MiddleValue.getAttribute("class");
                        if (middleValue.equalsIgnoreCase("o")) {
                            BottomCentre.click();
                            pause(2);
                        } else {
                            Middle.click();
                            pause(2);
                        }
                    } else {
                        LeftCentre.click();
                        pause(2);
                    }
                } else if (bottomLeftValue.equalsIgnoreCase("o")) {
                    TopRight.click();
                    pause(2);
                    Bottomright.click();
                    pause(2);

                    if (topCentreValue.equalsIgnoreCase("o")) {
                        middleValue = MiddleValue.getAttribute("class");
                        pause(2);
                        if (middleValue.equalsIgnoreCase("o")) {
                            RightCentre.click();
                            pause(2);
                        } else {
                            Middle.click();
                        }
                    } else {
                        TopCentre.click();
                        pause(2);
                    }
                }
                //opponent at diagonally opposite corner
                else {
                    BottomLeft.click();
                    pause(2);
                    TopRight.click();
                    pause(2);

                    middleValue = MiddleValue.getAttribute("class");
                    if (middleValue.equalsIgnoreCase("o")) {
                        TopCentre.click();
                        pause(2);
                    } else {
                        Middle.click();
                        pause(2);
                    }

                }
               // System.out.println("It's a win!!!");
                i=true;
            }

            //opponent at centre
            else {
                Bottomright.click();
                pause(2);

                bottomLeftValue = BottomLeftValue.getAttribute("class");
                topRightValue = TopRightValue.getAttribute("class");
                if (topRightValue.equalsIgnoreCase("o")) {
                    BottomLeft.click();
                    pause(2);
                    bottomLeftValue = BottomLeftValue.getAttribute("class");
                    leftCentreValue = LeftCentreValue.getAttribute("class");
                    if (leftCentreValue.equalsIgnoreCase("o")) {
                        BottomCentre.click();
                    } else {
                        LeftCentre.click();
                    }
                    //System.out.println("It's a win!!!");
                        i=true;
                } else if (bottomLeftValue.equalsIgnoreCase("o")) {
                    TopRight.click();
                    pause(2);
                    topCentreValue = TopCentreValue.getAttribute("class");
                    if (topCentreValue.equalsIgnoreCase("o")) {
                        System.out.println("i am  rightcentre");
                       // RightCentre.click();
                        RightCentre.click();
                        pause(2);
                    } else {
                        TopCentre.click();
                    }
                  //  System.out.println("It's a win!!!");
                              i=true;
                } else {
                    i=false;
                    System.out.println("its a tie");
                    driver.navigate().refresh();
                    continue;


                }
            }

//            pause(2);
        }
         if(driver.findElement(By.xpath("//div[@class=\"scores p1\"]//span[@class=\"score appear\"]")).isDisplayed()){
             System.out.println("It's a win!!!");
         }else{
             System.out.println("its a tie");
         }
        driver.quit();

    }

        public static void pause ( int Seconds){
            try {
                Thread.sleep(Seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }