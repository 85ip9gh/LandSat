package com.wecodeforfood.util;

/**
 * The {@code Vector} class represents a 3D vector used for
 * operations like calculating movement direction and magnitude.
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class Vector {

    //Instance variables
    private final double x;
    private final double y;
    private final double z;

    // Constructors
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Magnitude of the vector (length)
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Vector addition
    public Vector add(Vector v) {
        return new Vector(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    // Vector subtraction
    public Vector subtract(Vector v) {
        return new Vector(this.x - v.getX(), this.y - v.getY(), this.z - v.getZ());
    }

    // Scalar multiplication
    public Vector multiply(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Normalize the vector (make its magnitude 1)
    public Vector normalize() {
        double magnitude = getMagnitude();
        return new Vector(this.x / magnitude, this.y / magnitude, this.z / magnitude);
    }

    // Dot product (useful for calculating angles between vectors)
    public double dotProduct(Vector v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    // Cross product
    public Vector crossProduct(Vector v) {
        return new Vector(
                this.y * v.getZ() - this.z * v.getY(),
                this.z * v.getX() - this.x * v.getZ(),
                this.x * v.getY() - this.y * v.getX()
        );
    }

    // GETTERS
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }
}
