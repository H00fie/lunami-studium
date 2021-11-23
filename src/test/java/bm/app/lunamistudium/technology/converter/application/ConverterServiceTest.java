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
        int providedDecimal = 47;
        int expectedBinary = 101111;
        //when
        int result = converterService.convertDecimalToBinary(providedDecimal);
        //then
        assertThat(result).isEqualTo(expectedBinary);
    }

    @Test
    void shouldConvertBinaryToDecimal() {
        //given
        int providedBinary = 10001001;
        int expectedDecimal = 137;
        //when
        int result = converterService.convertBinaryToDecimal(providedBinary);
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

    @BeforeEach
    void setUp() {
        converterService = new ConverterService();
    }

}