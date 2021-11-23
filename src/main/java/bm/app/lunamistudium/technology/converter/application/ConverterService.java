package bm.app.lunamistudium.technology.converter.application;

import org.springframework.jdbc.core.SqlReturnType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }
        return decimal;
    }

    public String convertBinaryToHexadecimal(String binary) {
        binary = leftPad(binary);
        return binaryToHexadecimal(binary);
    }

    private String binaryToHexadecimal(String binary) {
        String[] hexValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String hexadecimal = "";
        int sum = 0;
        int exp = 0;
        for (int i = 0; i < binary.length(); i++) {
            exp = 3 - i % 4;
            if ((i % 4) == 3) {
                sum = sum + Integer.parseInt(binary.charAt(i) + "") * (int) (Math.pow(2, exp));
                hexadecimal = hexadecimal + hexValues[sum];
                sum = 0;
            } else {
                sum = sum + Integer.parseInt(binary.charAt(i) + "") * (int) (Math.pow(2, exp));
            }
        }
        return hexadecimal;
    }

    private String leftPad(String binary) {
        int paddingCount = 0;
        if ((binary.length() % 4) > 0)
            paddingCount = 4 - binary.length() % 4;

        while (paddingCount > 0) {
            binary = "0" + binary;
            paddingCount--;
        }
        return binary;
    }

    public String convertHexadecimalToBinary(String hexadecimal) {
        hexadecimal = hexadecimal.replaceAll("0", "0000");
        hexadecimal = hexadecimal.replaceAll("1", "0001");
        hexadecimal = hexadecimal.replaceAll("2", "0010");
        hexadecimal = hexadecimal.replaceAll("3", "0011");
        hexadecimal = hexadecimal.replaceAll("4", "0100");
        hexadecimal = hexadecimal.replaceAll("5", "0101");
        hexadecimal = hexadecimal.replaceAll("6", "0110");
        hexadecimal = hexadecimal.replaceAll("7", "0111");
        hexadecimal = hexadecimal.replaceAll("8", "1000");
        hexadecimal = hexadecimal.replaceAll("9", "1001");
        hexadecimal = hexadecimal.replaceAll("A", "1010");
        hexadecimal = hexadecimal.replaceAll("B", "1011");
        hexadecimal = hexadecimal.replaceAll("C", "1100");
        hexadecimal = hexadecimal.replaceAll("D", "1101");
        hexadecimal = hexadecimal.replaceAll("E", "1110");
        hexadecimal = hexadecimal.replaceAll("F", "1111");
        return hexadecimal;
    }
}
