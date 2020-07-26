package sample.workwithfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class to load data from file
 */
public class FileLoader {
    /**
     * Method retrieve data from file with dto
     *
     * @param fileName name of the file
     * @return data transfer object to retrieve type of task and input data of task
     * @throws FileNotFoundException Exception if file not founded
     */
    public FromFileDto loadFromFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        try {
            int typeOfTask = Integer.parseInt(scanner.nextLine());
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine() + "\n");
            }
            return new FromFileDto(typeOfTask, stringBuilder.toString());
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
