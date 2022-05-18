package IAV.HomeWork_04;

public class HomeWork_04 {

    public static double getArea(int sideA, int sideB, int sideC) throws HomeWork_04_Exception{

        //TODO Проверить условия проброса исключений: проверка возможности треугольника, отрицательные или нулевые стороны
        if (!((sideA < (sideB + sideC) && sideA > (sideB - sideC)) &&
                (sideB < (sideA + sideC) && sideB > (sideA - sideC)) &&
                (sideC < (sideA + sideB) && sideC > (sideA - sideB)))){
            throw new HomeWork_04_Exception("Triangle with this sides is not possible");
        }

        if (sideA <= 0 || sideB <=0 || sideC <= 0 ){
            throw new HomeWork_04_Exception("All sides should be greater than 0");
        }

        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
