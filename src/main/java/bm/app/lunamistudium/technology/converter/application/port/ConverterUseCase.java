package bm.app.lunamistudium.technology.converter.application.port;

public interface ConverterUseCase {

    int convertDecimalToBinary(int decimal);

    int convertBinaryToDecimal(int binary);

    String convertBinaryToHexadecimal(String binary);

    String convertHexadecimalToBinary(String hex);

}
