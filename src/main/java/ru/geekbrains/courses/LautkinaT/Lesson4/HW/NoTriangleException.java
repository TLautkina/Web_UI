package ru.geekbrains.courses.LautkinaT.Lesson4.HW;


public class NoTriangleException extends Exception{
    public NoTriangleException() {
        super("Если треугольник = отрезок или точка, то площадь нельзя посчитать");
    }
}
