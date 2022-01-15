package ru.flendger.waterconsumer.model.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateService {
    public LocalDate current() {
        return LocalDate.now();
    }
}
