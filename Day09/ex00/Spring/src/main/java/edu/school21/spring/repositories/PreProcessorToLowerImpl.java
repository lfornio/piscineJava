package edu.school21.spring.repositories;

public class PreProcessorToLowerImpl implements PreProcessor{

    @Override
    public String remakeString(String source) {
        return source.toLowerCase();
    }
}
