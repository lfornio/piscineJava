package edu.school21.spring.repositories;

public class PreProcessorToUpperImpl implements PreProcessor{

    @Override
    public String remakeString(String source) {
        return source.toUpperCase();
    }
}
