package sample.workwithfile;

/**
 * Class to transfer data from file
 */
public class FromFileDto {
    private int typeOfTask;
    private String text;

    /**
     * Method to get type of task saved in file, it is 1 or 2
     * @return
     */
    public int getTypeOfTask() {
        return typeOfTask;
    }

    /**
     * Method to get input data for task
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Class constructor
     * @param typeOfTask type of task from file
     * @param text input text for file
     */
    public FromFileDto(int typeOfTask, String text) {
        this.typeOfTask = typeOfTask;
        this.text = text;
    }
}
