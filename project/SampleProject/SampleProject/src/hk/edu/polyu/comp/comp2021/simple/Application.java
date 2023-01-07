package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.*;

import java.io.IOException;

@SuppressWarnings({"ALL", "MissingJavadoc"})
public class Application {

    @SuppressWarnings("MissingJavadoc")
    public static void main(String[] args) throws IOException {
        Simple simple = new Simple();
        // Initialize and utilize the system
        simple.run();
    }

}