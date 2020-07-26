package sample.controller;


import java.util.Collection;

/**
 * Class to get data from task 1 or task 2
 */
public class Controller {
    /**
     * Method get result of executing task 1
     *
     * @param unformattedString String from textbox
     * @return answer as string to place in textbox
     * @throws RuntimeException throws Exception if input format is invalid
     */
    public String executeFirstTask(String unformattedString) throws RuntimeException {
        try {
            String[] strings = task1FormatString(unformattedString);
            String[] a1 = formatSingleStringTask1(strings[0]);
            String[] a2 = formatSingleStringTask1(strings[1]);
            Collection<String> collection = new LexiographicSearch().doLexiographicSearch(a1, a2);
            if (collection.size() == 0) {
                return "[]";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[\"");
            for (String string : collection) {
                stringBuilder.append(string);
                stringBuilder.append("\", ");
            }
            String result = stringBuilder.substring(0, stringBuilder.length() - 2);
            result += "]";
            return result;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    /**
     * Method get result of executing task 2
     *
     * @param unformattedString String from textbox
     * @return answer as string to place in textbox
     * @throws RuntimeException throws Exception if input format is invalid
     */
    public String executeSecondTask(String unformattedString) throws RuntimeException {
        try {
            Integer.parseInt(unformattedString);
        } catch (RuntimeException e) {
            throw new RuntimeException("Невозможно конвертировать строку " + unformattedString);
        }
        return new ExpandNumber().expandNumber(unformattedString);
    }

    private String[] task1FormatString(String unformattedString) throws RuntimeException {
        String[] result = unformattedString.split("\n");
        if (result.length < 2)
            throw new RuntimeException("Входных строк меньше двух");
        else if (result.length > 2)
            throw new RuntimeException("Входных строк больше двух");
        return result;
    }

    private String[] formatSingleStringTask1(String string) throws RuntimeException {
        String[] array = string.split("\\[\"|\"\\]|\",\\s\"");
        if (array.length == 0) {
            throw new RuntimeException("Не обнаружены элементы массива");
        }
        // Return elements without first, like a1 =
        String[] result = new String[array.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i + 1];
        }
        return result;
    }
}
