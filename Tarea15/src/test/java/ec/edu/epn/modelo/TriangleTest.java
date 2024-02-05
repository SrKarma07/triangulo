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
}