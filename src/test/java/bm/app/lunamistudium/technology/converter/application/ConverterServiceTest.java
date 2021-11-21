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

    @BeforeEach
    void setUp() {
        converterService = new ConverterService();
    }

}