package day8;

import java.io.IOException;

public interface PersonalStorageImpl {
    String readFile(String fileName);

    String readFileWithThrows(String fileName) throws IOException;
}
