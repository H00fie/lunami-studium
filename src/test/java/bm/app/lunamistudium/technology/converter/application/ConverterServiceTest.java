package bm.app.lunamistudium.technology.converter.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterServiceTest {

    ConverterService converterService;

    @Test
    void shouldConvertDecimalToBinary() {
        //given
        String providedDecimal = "47";
        String expectedBinary = "101111";
        //when
        String result = converterService.convertDecimalToBinary(providedDecimal);
        //then
        assertThat(result).isEqualTo(expectedBinary);
    }

    @Test
    void shouldConvertBinaryToDecimal() {
        //given
        String providedBinary = "10001001";
        String expectedDecimal = "137";
        //when
        String result = converterService.convertBinaryToDecimal(providedBinary);
        //then
        assertThat(result).isEqualTo(expectedDecimal);
    }

    @Test
    void shouldConvertBinaryToHexadecimal() {
        //given
        String providedBinary = "11011101010";
        String expectedHexadecimal = "6EA";
        //when
        String result = converterService.convertBinaryToHexadecimal(providedBinary);
        //then
        assertThat(result).isEqualTo(expectedHexadecimal);
    }

    @Test
    void shouldConvertHexadecimalToBinary() {
        //given
        String providedHexadecimal = "B4F";
        String expectedBinary = "101101001111";
        //when
        String result = converterService.convertHexadecimalToBinary(providedHexadecimal);
        //then
        assertThat(result).isEqualTo(expectedBinary);
    }

    @Test
    void shouldReturnFalseWhenIncorrectBinaryValue() {
        //given
        String providedBinary = "1001h0";
        String expectedResult = "Incorrect binary value.";
        //when
        String actualResult = converterService.convertBinaryToHexadecimal(providedBinary);
        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @BeforeEach
    void setUp() {
        converterService = new ConverterService();
    }

}