/*
 * Moon Study - Project 7
 *
 * A program that
 * Jackie Vishton
 * version 11/13/2021
 * CMSC255
 */

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class MoonStudy {

    /**
     * a method that opens a file and creates an array list of strings where
     * each string element is a line from the text file
     */
    public static ArrayList<String> openFile (File inputFile) throws FileNotFoundException{
        ArrayList<String> forUser = new ArrayList<>();
        Scanner in = new Scanner(inputFile);

        // puts every line as a string into array list
        while (in.hasNextLine()) {
            forUser.add(in.nextLine());
        }
        in.close();
        return forUser;
    }

    /**
     * a method that takes an arraylist of strings and uses information from it
     * to create an arraylist of moon objects
     */
    public static ArrayList<Moon> createObjects (ArrayList<String> lines) {
        ArrayList<Moon> forUser = new ArrayList<>();

        // splits every line by tabs
        for (String line : lines) {
            String[] temp = line.split("\t");

            // radius density and distance are 0.0 by default
            double radius = 0.0, density = 0.0, distance = 0.0;
            for (int j = 0; j < temp.length; j++) {

                // makes sure radius is a non-negative number
                try {
                    radius = Double.parseDouble(temp[1]);
                    if (radius < 0) {
                        radius = 0.0;
                    }
                }
                catch (NumberFormatException ignore) {
                }

                // makes sure density is a non-negative number
                try {
                    density = Double.parseDouble(temp[2]);
                    if (density < 0) {
                        density = 0.0;
                    }
                }
                catch (NumberFormatException ignore) {
                }

                // makes sure distance is a non-negative number
                try {
                    distance = Double.parseDouble(temp[3]);
                    if (distance < 0) {
                        distance = 0.0;
                    }
                }
                catch (NumberFormatException ignore) {
                }
            }

            // with the kept radius, density, and distance value a moon object is created and added to array list
            Moon moon = new Moon(temp[0], radius, density, distance);
            forUser.add(moon);
        }
        return forUser;
    }

    /**
     * a method that finds the mean of a given attribute in an arraylist of moons
     */
    public static double findMean (ArrayList<Moon> moons, MoonAttributes attribute) {

        double total = 0;

        /*
        for radius density, or distance depending on the attribute, goes through the
        entire array list and adds up a total
         */
        if (attribute == MoonAttributes.RADIUS) {
            for (Moon moon : moons) {
                total += moon.getRadius();
            }
        }
        else if (attribute == MoonAttributes.DENSITY) {
            for (Moon moon : moons) {
                total += moon.getDensity();
            }
        }
        else {
            for (Moon moon : moons) {
                total += moon.getDistance();
            }
        }

        // divides total by number of values summed to get average
        return (total / moons.size());
    }

    /**
     * a method that finds the highest value of a given attribute
     * in an arraylist of moon objects
     */
    public static double findHighValue (ArrayList<Moon> moons, MoonAttributes attribute) {

        double highest = 0;

        // for radius/density/distance sees which has the greates value via for loop
        if (attribute == MoonAttributes.RADIUS) {
            for (Moon moon : moons) {
                if (moon.getRadius() > highest) {
                    highest = moon.getRadius();
                }
            }
        }
        else if (attribute == MoonAttributes.DENSITY) {
            for (Moon moon : moons) {
                if (moon.getDensity() > highest) {
                    highest = moon.getDensity();
                }
            }
        }
        else {
            for (Moon moon : moons) {
                if (moon.getDistance() > highest) {
                    highest = moon.getDistance();
                }
            }
        }

        return highest;
    }

    /**
     * a method that finds a moon that has the value of a given attribute
     * that is closest to the mean of the given attribute for the entire arraylist of moons
     */
    public static Moon findMeanMoon (ArrayList<Moon> moons, MoonAttributes attribute, double meanValue) {

        double difference;
        int index;

        // for radius/density/distance finds the value that is closest to the mean
        if (attribute == MoonAttributes.RADIUS) {
            difference = Math.abs(moons.get(0).getRadius() - meanValue);
            index = 0;

            for (int i = 0; i < moons.size(); i++) {
                if (Math.abs(moons.get(i).getRadius() - meanValue) < difference) {
                    difference = Math.abs(moons.get(i).getRadius() - meanValue);
                    index = i;
                }
            }
        }
        else if (attribute == MoonAttributes.DENSITY) {
            difference = Math.abs(moons.get(0).getDensity() - meanValue);
            index = 0;

            for (int i = 0; i < moons.size(); i++) {
                if (Math.abs(moons.get(i).getDensity() - meanValue) < difference) {
                    difference = Math.abs(moons.get(i).getDensity() - meanValue);
                    index = i;
                }
            }
        }
        else {
            difference = Math.abs(moons.get(0).getDistance() - meanValue);
            index = 0;

            for (int i = 0; i < moons.size(); i++) {
                if (Math.abs(moons.get(i).getDistance() - meanValue) < difference) {
                    difference = Math.abs(moons.get(i).getDistance() - meanValue);
                    index = i;
                }
            }
        }
        return moons.get(index);
    }

    /**
     * a method that finds the moons that have a value for the specified attribute that
     * is lower than the given double value
     */
    public static ArrayList<Moon> findLowestMoons (ArrayList<Moon> moons, double value, MoonAttributes attribute) {
        ArrayList<Moon> lowMoons = new ArrayList<>();

        // the moon is added to the array list that will be returned to the user if it's attribute is a smaller value than the given one
        if (attribute == MoonAttributes.RADIUS) {
            for (Moon moon : moons) {
                if (moon.getRadius() < value) {
                    lowMoons.add(moon);
                }
            }
        }
        else if (attribute == MoonAttributes.DENSITY) {
            for (Moon moon : moons) {
                if (moon.getDensity() < value) {
                    lowMoons.add(moon);
                }
            }
        }
        else {
            for (Moon moon : moons) {
                if (moon.getDistance() < value) {
                    lowMoons.add(moon);
                }
            }
        }

        return lowMoons;
    }

    /**
     * a method that prints a message and information about
     * an array of moons to a file
     * to a file
     */
    public static void outputToFile (String outputMessage, ArrayList<Moon> moons, PrintWriter out) {
        out.print(outputMessage);
        for (Moon moon : moons) {
            out.print(moon.toString() + " ");
        }
        out.println("\n");
        out.close();
    }
    /**
     * a method that prints a message and information
     * about a moon object to a file
     */
    public static void outputToFile (String outputMessage, Moon moon, PrintWriter out) {
        out.println(outputMessage + moon.toString());
        out.println();
    }
    /**
     * a method that prints a message and a double value rounded
     * to 2 decimal places to a file
     */
    public static void outputToFile (String outputMessage, double value, PrintWriter out) {
        out.printf("%s%.2f\n", outputMessage, value);
        out.println();
    }

    /**
     * this is the main method where the above functions are used/tested
     */
    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Moon> moons = new ArrayList<>();

        try {
            lines = openFile(inputFile);
            System.out.println("Input file correct");
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect input filename");
        }

        moons = createObjects(lines);

        try {
            PrintWriter out = new PrintWriter(outputFile);
            System.out.println("Output file correct");
            outputToFile("The mean of radii is: ", findMean(moons, MoonAttributes.RADIUS), out);
            outputToFile("The highest density value is: ", findHighValue(moons, MoonAttributes.DENSITY), out);
            outputToFile("The moon closest to the mean is: ", findMeanMoon(moons, MoonAttributes.RADIUS, findMean(moons, MoonAttributes.RADIUS)), out);
            outputToFile("The moons below the mean value of radii are: ", findLowestMoons(moons, findMean(moons, MoonAttributes.RADIUS), MoonAttributes.RADIUS), out);
            out.println();
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect output filename");
        }
    }
}
