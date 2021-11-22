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

    @BeforeEach
    void setUp() {
        converterService = new ConverterService();
    }

}