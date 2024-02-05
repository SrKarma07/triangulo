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
}