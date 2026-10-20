package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Builds a String from a file using only the + operator -> creates a huge amount of garbage
public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = args.length > 0 ? args[0] : "test.exe"; // path to a (large) file
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // each += creates a new String object, the old one becomes garbage
        }
        endTime = System.currentTimeMillis();
        System.out.println("GarbageCreator (" + inputBytes.length + " bytes): " + (endTime - startTime) + " ms");
    }
}
