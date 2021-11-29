package bm.app.lunamistudium.technology.converter.web;

import bm.app.lunamistudium.technology.converter.application.port.ConverterUseCase;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/converter")
@RestController
@AllArgsConstructor
public class ConverterController {

    private final ConverterUseCase converterUseCase;

    @GetMapping
    public String testGet() {
        return "Hello there.";
    }

    @PostMapping("/decToBin/{decimal}")
    @ApiOperation(value = "Converts a decimal number into a binary one.", notes = "Provide a decimal number")
    public int getDecimalToBinary(@PathVariable int decimal) {
        return converterUseCase.convertDecimalToBinary(decimal);
    }

    @PostMapping("/binToDec/{binary}")
    @ApiOperation(value = "Converts a binary number into a decimal one.", notes = "Provide a binary number")
    public int getBinaryToDecimal(@PathVariable int binary) {
        return converterUseCase.convertBinaryToDecimal(binary);
    }
}
