package kz.spring.aop.objects;

import java.io.File;
import java.io.FilenameFilter;

public class CustomFileFilter implements FilenameFilter {

    private String extension;

    public CustomFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File file, String s) {
        return s.toUpperCase().endsWith("." + extension.toUpperCase());
    }
}
