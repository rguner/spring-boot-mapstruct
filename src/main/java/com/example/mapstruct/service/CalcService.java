package com.example.mapstruct.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int calAgeFromName(String name) {
        return switch (name) {
            case "Ada" -> {
                System.out.println("Age of Ada is 30");
                yield 30;
            }
            case "Grace" -> {
                System.out.println("Age of Grace is 25");
                yield 25;
            }
            default -> {
                System.out.println("Age not found for " + name);
                yield 0;
            }
        };
    }


}
