package ec.edu.epn.modelo;

public class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    /**
     * Instantiates a new Triangle.
     *
     * @param side1 the side 1
     * @param side2 the side 2
     * @param side3 the side 3
     */
    public Triangle(double side1, double side2, double side3) {
        if (Double.isNaN(side1) || Double.isNaN(side2) || Double.isNaN(side3) ||
                Double.isInfinite(side1) || Double.isInfinite(side2) || Double.isInfinite(side3)) {
            throw new IllegalArgumentException("Los lados deben tener un valor numerico real");
        }
        validateSides(side1, side2, side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private void validateSides(final double side1, final double side2, final double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("La longitud del lado debe ser positiva");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Inequidad del triángulo violada");
        }
    }

    /**
     * Gets side 1.
     *
     * @return the side 1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Gets side 2.
     *
     * @return the side 2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Gets side 3.
     *
     * @return the side 3
     */
    public double getSide3() {
        return side3;
    }
}