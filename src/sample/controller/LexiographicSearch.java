package sample.controller;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Class to do task number 2
 */
public class LexiographicSearch {
    /**
     * Method search substrings of array a1 in array a2
     *
     * @param a1 array of string
     * @param a2 array of string
     * @return Collection of substrings
     */
    public Collection<String> doLexiographicSearch(String[] a1, String[] a2) {
        TreeSet<String> r = new TreeSet<>();
        for (String stringFromA2 : a2)
            for (String stringFromA1 : a1)
                if (stringFromA2.contains(stringFromA1))
                    r.add(stringFromA1);
        return r;
    }
}
