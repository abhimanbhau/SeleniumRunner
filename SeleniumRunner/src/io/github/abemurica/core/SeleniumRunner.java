package io.github.abemurica.core;

import io.github.abemurica.utils.CommandProcessor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SeleniumRunner {
    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        String csvFile = args[0];
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] cmds = line.split(",");
                CommandProcessor.processCommand(cmds[0].trim(), cmds[1].trim(), cmds[2].trim(), chromeDriver);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            chromeDriver.close();
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
