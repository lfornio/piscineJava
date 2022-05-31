package edu.school21.spring.application;

import edu.school21.spring.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix");
        printer.print("Hello!");

        ApplicationContext context1 = new ClassPathXmlApplicationContext("context.xml");
        Printer printer1 = context1.getBean("printerWithPrefix", Printer.class);
        printer1.print ("Hello!") ;

        ApplicationContext context2 = new ClassPathXmlApplicationContext("context.xml");
        Printer printer2 = context2.getBean("printerWithDataTime", Printer.class);
        printer2.print ("Hello!") ;
    }
}
