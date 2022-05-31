package edu.school21.spring.repositories;

public class PrinterWithPrefixImpl implements Printer{
    private Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = " ";
    }

    public PrinterWithPrefixImpl() {
    }

    public void setPrefix(String source) {
        prefix = source;
    }

    @Override
    public void print(String str) {
      renderer.outputInfo(prefix + " " + str);
    }
}
