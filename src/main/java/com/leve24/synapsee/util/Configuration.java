package com.leve24.synapsee.util;
import java.io.*;
import java.util.Properties;

public class Configuration {
    enum Settings {MainWindowWidth,mainWindowHeight}
    private static final String PROPERTIES_FILE = "config.properties";

    private static double mainWindowWidth = 600;
    private double mainWindowHeight = 900;

    Properties props = new Properties();

    public Configuration(){
        try {
            File file = new File(PROPERTIES_FILE);
            file.createNewFile();

            InputStream inputStream = new FileInputStream(PROPERTIES_FILE);
            props.load(inputStream);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public double GetMainWindowWidth(){
        try {
            mainWindowWidth = Double.valueOf(props.getProperty(Settings.MainWindowWidth.toString()));
            System.out.println(Settings.MainWindowWidth.toString() + " (GET): " + mainWindowWidth);
        } catch (NullPointerException ex){
            System.out.println(Settings.MainWindowWidth.toString() + ": Unable to get configuration information.");
        }
        return mainWindowWidth;
    }

    public void SetMainWindowWidth(double width)  {
        try {
            FileOutputStream out = new FileOutputStream(PROPERTIES_FILE);
            props.setProperty(Settings.MainWindowWidth.toString(), Double.toString(width));
            System.out.println(Settings.MainWindowWidth.toString() + " (SET): " + GetMainWindowWidth());
            props.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(Settings.MainWindowWidth.toString() + ": Unable to set configuration information.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(Settings.mainWindowHeight.toString() + ": Unable to set configuration information.");
            throw new RuntimeException(e);
        }
    }

    public double GetMainWindowHeight(){
        try {
            mainWindowHeight = Double.valueOf(props.getProperty(Settings.mainWindowHeight.toString()));
            System.out.println(Settings.mainWindowHeight.toString() + " (GET): " + mainWindowHeight);
        } catch (NullPointerException ex){
            System.out.println(Settings.mainWindowHeight.toString() + ": Unable to get configuration information.");
        }
        return mainWindowHeight;
    }

    public void SetMainWindowHeight(double width)  {
        try {
            FileOutputStream out = new FileOutputStream(PROPERTIES_FILE);
            props.setProperty(Settings.mainWindowHeight.toString(), Double.toString(width));
            System.out.println(Settings.mainWindowHeight.toString() + ":" + GetMainWindowHeight());
            props.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(Settings.mainWindowHeight.toString() + ": Unable to set configuration information.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(Settings.mainWindowHeight.toString() + ": Unable to set configuration information.");
            throw new RuntimeException(e);
        }
    }
}
