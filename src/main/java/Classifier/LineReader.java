package Classifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader {
    BufferedReader reader;

    public LineReader(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        // TODO release resources.
    }

	public String nextLine() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }
}
