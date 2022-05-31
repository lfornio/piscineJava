package edu.school21.spring.repositories;

public class RendererErrImpl implements Renderer {
    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void outputInfo(String source) {
        System.err.println(preProcessor.remakeString(source));
    }
}
