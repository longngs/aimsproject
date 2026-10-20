package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Same task as GarbageCreator but uses a mutable buffer -> almost no garbage
public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = args.length > 0 ? args[0] : "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer(inputBytes.length);
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        }
        String outputString = outputStringBuffer.toString();
        endTime = System.currentTimeMillis();
        System.out.println("NoGarbage (" + inputBytes.length + " bytes): " + (endTime - startTime) + " ms");
    }
}
