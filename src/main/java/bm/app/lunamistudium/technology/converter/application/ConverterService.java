package bm.app.lunamistudium.technology.converter.application;

import org.springframework.jdbc.core.SqlReturnType;

import java.util.HashMap;
import java.util.Map;

public class ConverterService {

    public int convertDecimalToBinary(int decimal) {
        StringBuffer binaryResult = new StringBuffer();
        int temporaryVariable;
        while (decimal > 0) {
            temporaryVariable = decimal % 2;
            decimal /= 2;
            binaryResult.append(temporaryVariable);
        }
        return Integer.parseInt(String.valueOf(binaryResult.reverse()));
    }

    public int convertBinaryToDecimal(int binary) {
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
}
