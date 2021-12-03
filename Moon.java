/*
 * Moon Object - Project 7
 *
 * An class that defines Moon objects
 * Jackie Vishton
 * version 11/13/2021
 * CMSC255
 */

package com.company;

public class Moon {

    private String name;
    private double radius;
    private double density;
    private double distance;

    /**
     * default constructoy
     */
    public Moon() {
        name = "";
        radius = 0.0;
        density = 0.0;
        distance = 0.0;
    }

    /**
     * parameterized constructor
     */
    public Moon(String name, double radius, double density, double distance) {
        this.name = name;
        this.radius = radius;
        this.density = density;
        this.distance = distance;
    }

    /**
     * returns name, radius, density and distance separated by a space rounded to 2 decimal places
     */
    public String toString () {
        return String.format("%s %.2f %.2f %.2f", this.name, this.radius, this.density,
                this.distance);
    }

    /**
     * getter for instance variable name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for instance variable name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for instance variable radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * setter for instance variable radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * getter for instance variable density
     */
    public double getDensity() {
        return density;
    }

    /**
     * setter for instance variable density
     */
    public void setDensity(double density) {
        this.density = density;
    }

    /**
     * getter for instance variable distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * setter for instance variable distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
