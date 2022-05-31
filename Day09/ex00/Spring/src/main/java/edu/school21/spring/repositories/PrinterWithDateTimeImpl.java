package edu.school21.spring.repositories;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterWithDateTimeImpl implements Printer{
    private Renderer renderer;
    private LocalDateTime dateTime;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
        this.dateTime = LocalDateTime.now();
    }

//    public void setDateTime(LocalDateTime dataTime) {
//        this.dateTime = dataTime;
//    }

    @Override
    public void print(String str) {
        renderer.outputInfo(dateTime + " " + str);
    }
}
