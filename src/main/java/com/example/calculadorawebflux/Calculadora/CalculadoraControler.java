package com.example.calculadorawebflux.Calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/calcular")
public class CalculadoraControler {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/oi")
    public ResponseEntity<Integer> oi(@RequestParam Integer[] numero){
        return ResponseEntity.status(HttpStatus.OK).body(numero[0]);
    }

    @PostMapping("/soma")
    public ResponseEntity<Flux<Double>> somar(@RequestParam Double[] numeros){
        return ResponseEntity.status(HttpStatus.OK).body(calculadoraService.somar(numeros));
    }

    @PostMapping("/subtracao")
    public ResponseEntity<Flux<Double>> subtracao(@RequestParam Double[] numeros){
        return ResponseEntity.status(HttpStatus.OK).body(calculadoraService.subtracao(numeros));
    }

    @PostMapping("/multplicacao")
    public ResponseEntity<Flux<Double>> multplicacao(@RequestParam Double[] numeros){
        return ResponseEntity.status(HttpStatus.OK).body(calculadoraService.multplicacao(numeros));
    }

    @PostMapping("/divisao")
    public ResponseEntity<Flux<Double>> divisao(@RequestParam Double[] numeros){
        return ResponseEntity.status(HttpStatus.OK).body(calculadoraService.divisao(numeros));
    }
}
