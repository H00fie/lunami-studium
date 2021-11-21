package bm.app.lunamistudium.technology.converter.application;

public class ConverterService {

    public int convertDecimalToBinary(int decimal) {
        StringBuffer binaryResult = new StringBuffer();
        int temporaryVariable = 0;
        while (decimal > 0) {
            temporaryVariable = decimal % 2;
            decimal /= 2;
            binaryResult.append(temporaryVariable);
        }
        return Integer.parseInt(String.valueOf(binaryResult.reverse()));
    }
}
