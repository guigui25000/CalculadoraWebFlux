package com.example.calculadorawebflux.Calculadora;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Service
public class CalculadoraService {

    public Flux<Double> somar(Double[] numeros) {
        return Flux.just(resolverSoma(Arrays.stream(numeros)
                .collect(Collectors.toList())));
    }

    public Double resolverSoma(List<Double> lista){
        return lista.stream()
                .flatMapToDouble(DoubleStream::of)
                .sum();
    }

    public Flux<Double> subtracao(Double[] numeros) {
        return Flux.just(resolverSubtracao(Arrays.stream(numeros)
        .collect(Collectors.toList())));
    }

    public Double resolverSubtracao(List<Double> numeros){
        Double resp = numeros.get(0);
        for(int i = 0;numeros.size()-1 > i;i++){
            resp -= numeros.get(i+1);
        }
        return resp;
    }

    public Flux<Double> multplicacao(Double[] numeros) {
        return Flux.just(resolvermultplicacao(Arrays.stream(numeros)
                .collect(Collectors.toList())));
    }

    public Double resolvermultplicacao(List<Double> numeros){
        Double resp = numeros.get(0);
        for(int i = 0;numeros.size()-1 > i;i++){
            resp *= numeros.get(i+1);
        }
        return resp;
    }

    public Flux<Double> divisao(Double[] numeros) {
        return Flux.just(resolverdivisao(Arrays.stream(numeros)
                .collect(Collectors.toList())));
    }

    public Double resolverdivisao(List<Double> numeros){
        Double resp = numeros.get(0);
        for(int i = 0;numeros.size()-1 > i;i++){
            resp /= numeros.get(i+1);
        }
        return resp;
    }
}
