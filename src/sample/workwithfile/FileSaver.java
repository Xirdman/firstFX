package sample.workwithfile;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to save data to file
 */
public class FileSaver {
    private static String NAME_OF_FILE = "TaskFile.txt";

    /**
     * Method to save data to text file with name TaskFile.txt
     *
     * @param i                  type of task 1 for first task 2 for second task
     * @param textFromEnterField input data from text field
     * @throws IOException throws exception if there is problems to write data in file
     */
    public void saveToFile(int i, String textFromEnterField) throws IOException {
        FileWriter fileWriter = new FileWriter(NAME_OF_FILE);
        fileWriter.write(String.valueOf(i) + "\n");
        fileWriter.write(textFromEnterField);
        fileWriter.flush();
        fileWriter.close();
    }
}
