package bm.app.lunamistudium.technology.converter.application;

import bm.app.lunamistudium.technology.converter.application.port.ConverterUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
class ConverterService implements ConverterUseCase {

    Logger logger = LoggerFactory.getLogger(ConverterService.class);

    public String convertDecimalToBinary(String decimal) {
        if (!checkIfCorrectDecimal(decimal)) {
            return "Incorrect decimal.";
        }
        StringBuffer binaryResult = new StringBuffer();
        int parsedInput = Integer.parseInt(decimal);
        int temporaryVariable;
        while (parsedInput > 0) {
            temporaryVariable = parsedInput % 2;
            parsedInput /= 2;
            binaryResult.append(temporaryVariable);
        }
        return String.valueOf(binaryResult.reverse());
    }

    public String convertBinaryToDecimal(String binary) {
        if (!checkIfCorrectBinary(String.valueOf(binary))) {
            return "Incorrect decimal.";
        }
        int parsedInput = Integer.parseInt(binary);
        int decimal = 0;
        int n = 0;
        while (true) {
            if (parsedInput == 0) {
                break;
            } else {
                int temp = parsedInput % 10;
                decimal += temp * Math.pow(2, n);
                parsedInput = parsedInput / 10;
                n++;
            }
        }
        return String.valueOf(decimal);
    }

    public String convertBinaryToHexadecimal(String binary) {
        if (!checkIfCorrectBinary(binary)) {
            return "Incorrect binary value.";
        }
        binary = leftPad(binary);
        return binaryToHexadecimal(binary);
    }

    private String binaryToHexadecimal(String binary) {
        if (!checkIfCorrectBinary(binary)) {
            return "Incorrect binary value.";
        }
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

    public String convertHexadecimalToBinary(String hex) {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }

    private boolean checkIfCorrectBinary(String binary) {
        return binary.matches("[0-1]+");
    }

    private boolean checkIfCorrectDecimal(String decimal) {
        return decimal.matches("[0-9]+");
    }
}
