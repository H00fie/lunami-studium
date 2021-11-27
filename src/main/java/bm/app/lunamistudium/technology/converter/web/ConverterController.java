package bm.app.lunamistudium.technology.converter.web;

import bm.app.lunamistudium.technology.converter.application.port.ConverterUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/converter")
@RestController
@AllArgsConstructor
public class ConverterController {

    private final ConverterUseCase converterUseCase;

    @GetMapping
    public String landingGetPage() {
        return "getPage.";
    }

    @PostMapping("/decToBin/{decimal}")
    public int getDecimalToBinary(@PathVariable int decimal) {
        return converterUseCase.convertDecimalToBinary(decimal);
    }


}
