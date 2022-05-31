package edu.school21.spring.repositories;

public class RendererStandardImpl implements Renderer{
    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void outputInfo(String source) {
        System.out.println(preProcessor.remakeString(source));
    }
}
