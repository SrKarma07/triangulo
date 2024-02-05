package ec.edu.epn.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    //////////////////TEST DE CREACION DEL TRIANGULO/////////////////////
    /**
     * Test create triangle.
     */
    @Test
    void testCreateTriangle() {
        // Crear un triángulo con lados válidos
        double side1 = 3.0;
        double side2 = 4.0;
        double side3 = 5.0;
        Triangle triangle = new Triangle(side1, side2, side3);

        // Verificar que los lados del triángulo se han asignado correctamente
        assertEquals(side1, triangle.getSide1());
        assertEquals(side2, triangle.getSide2());
        assertEquals(side3, triangle.getSide3());
    }
    //////////////////TEST DE EQUIVALENCIA Y VALOR LIMITE/////////////////////
    /**
     * Test valid triangle.
     */
    @Test
    void testValidTriangle() {
        assertDoesNotThrow(() -> new Triangle(3, 4, 5));
    }

    /**
     * Test negative side.
     */
    @Test
    void testNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 4, 5));
    }

    /**
     * Test triangle inequality.
     */
    @Test
    void testTriangleInequality() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
    }

    /**
     * Test minimal positive sides.
     */
    @Test
    void testMinimalPositiveSides() {
        assertDoesNotThrow(() -> new Triangle(0.0001, 0.0001, 0.0001));
    }

    /**
     * Test inequality boundary.
     */
    @Test
    void testInequalityBoundary() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
    }

//////////////////TEST DE TIPO Y TAMAÑO DE VARIABLES/////////////////////
    /**
     * Test large double values.
     */
    @Test
    void testLargeDoubleValues() {
        double largeValue = Double.MAX_VALUE;
        Triangle triangle = new Triangle(largeValue, largeValue, largeValue);
        assertEquals(largeValue, triangle.getSide1());
        assertEquals(largeValue, triangle.getSide2());
        assertEquals(largeValue, triangle.getSide3());
    }

    /**
     * Test small double values.
     */
    @Test
    void testSmallDoubleValues() {
        double smallValue = Double.MIN_VALUE;
        Triangle triangle = new Triangle(smallValue, smallValue, smallValue);
        assertEquals(smallValue, triangle.getSide1());
        assertEquals(smallValue, triangle.getSide2());
        assertEquals(smallValue, triangle.getSide3());
    }

    //////////////////TEST DE CONJETURA DE ERRORES/////////////////////

    /**
     * Test triangle with non numeric values.
     */
    @Test
    void testTriangleWithNonNumericValues() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Double.NaN, 1.0, 1.0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Double.POSITIVE_INFINITY, 1.0, 1.0));
    }

    /**
     * Test triangle with limited precision.
     */
    @Test
    void testTriangleWithLimitedPrecision() {
        assertDoesNotThrow(() -> new Triangle(1.0, 1.0, 1.0 + Double.MIN_VALUE));
    }


//////////////////TEST DE FUNCIONES/////////////////////
    /**
     * Test triangle with extreme values.
     */
    @Test
    public void testTriangle() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals(3, t.getSide1());
        assertEquals(4, t.getSide2());
        assertEquals(5, t.getSide3());
        assertEquals(12, t.getPerimeter());
        assertEquals("Scalene", t.getType());

    }

    /**
     * Test triangle equilateral.
     */
    @Test
    public void testTriangleEquilateral() {
        Triangle t = new Triangle(3, 3, 3);
        assertEquals(3, t.getSide1());
        assertEquals(3, t.getSide2());
        assertEquals(3, t.getSide3());
        assertEquals(9, t.getPerimeter());
        assertEquals("Equilateral", t.getType());
    }

    /**
     * Test triangle isosceles.
     */
    @Test
    public void testTriangleIsosceles() {
        Triangle t = new Triangle(3, 3, 4);
        assertEquals(3, t.getSide1());
        assertEquals(3, t.getSide2());
        assertEquals(4, t.getSide3());
        assertEquals(10, t.getPerimeter());
        assertEquals("Isosceles", t.getType());
    }

    /**
     * Test triangle invalid.
     */
    @Test
    public void testTriangleInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, 2));
    }
}