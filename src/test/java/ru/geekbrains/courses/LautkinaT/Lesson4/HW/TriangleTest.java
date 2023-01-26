package ru.geekbrains.courses.LautkinaT.Lesson4.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест 1: проверка формулы на треугольнике")
    void test1() throws TriangleNotExistsException, NoTriangleException {
        logger.info("Тест 1: проверка формулы на треугольнике");
        assertNotEquals(0, CalculationTriangle.getSquare(3, 6, 7), 0.0);
        logger.info("\tТест успешен");
    }

    @ParameterizedTest
    @CsvSource({"3,6,7,8.94427190999916", "-3,-6,-7,8.94427190999916", "3,-6,7,8.94427190999916", "7,6,7,18.973665961010276"})
    @DisplayName("Тест 2: проверка корректности вычисления площади")
    void test2(int a, int b, int c, double d) throws TriangleNotExistsException, NoTriangleException {
        logger.info("Тест 2: проверка корректности вычисления площади");
        logger.info("\tВходящие параметры - (a,b,c) - " + a + ", " + b + ", " + c);
        assertEquals(CalculationTriangle.getSquare(a, b, c), d);
        logger.info("\tТест успешен");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidTriangles.csv")
    @DisplayName("Test 3: проверка корректности срабатывания исключения")
    void test3(int a, int b, int c) throws TriangleNotExistsException, NoTriangleException {
        logger.info("Тест 3: проверка корректности срабатывания исключения");
        NoTriangleException thrown = assertThrows(
                NoTriangleException.class,
                () -> CalculationTriangle.getSquare(a, b, c));
        assertTrue(thrown.getMessage().contains("Если треугольник = отрезок или точка, то площадь нельзя посчитать"));

        logger.info("\tТест успешен");
    }

    @Test
    @DisplayName("Тест 4: проверка корректности срабатывания исключения, если треугольник не существует")
    void test4() throws TriangleNotExistsException, NoTriangleException {
        logger.info("Тест 4: проверка корректности срабатывания исключения, если треугольник не существует");
        assertThrows(TriangleNotExistsException.class, () -> CalculationTriangle.getSquare(233, 6, 7));
        logger.info("\tТест успешен");
    }


}
