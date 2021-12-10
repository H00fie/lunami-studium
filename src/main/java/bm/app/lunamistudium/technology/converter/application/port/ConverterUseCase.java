package bm.app.lunamistudium.technology.converter.application.port;

public interface ConverterUseCase {

    String convertDecimalToBinary(String decimal);

    String convertBinaryToDecimal(String binary);

    String convertBinaryToHexadecimal(String binary);

    String convertHexadecimalToBinary(String hex);

}
