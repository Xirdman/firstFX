package sample.controller;

/**
 * Class to do task number 2
 */
public class ExpandNumber {
    /**
     * Method build string to expand number
     *
     * @param expandedNumber number to expand
     * @return expanded number in string format
     */
    public String expandNumber(String expandedNumber) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expandedNumber.length(); i++) {
            char singleChar = expandedNumber.charAt(i);
            if (singleChar != '0') {
                builder.append(singleChar);
                for (int j = expandedNumber.length() - 1 - i; j > 0; j--)
                    builder.append('0');
                builder.append(" + ");
            }
        }
        return builder.substring(0, builder.length() - 3);
    }
}
