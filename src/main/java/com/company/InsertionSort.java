package com.company;

import java.util.Comparator;

/**
 * Класс для выполнения сортировки вставками
 */
public class InsertionSort implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
            int firstValue = (int) o1;
            int secondValue = (int) o2;
            return firstValue-secondValue;

        } else if (o1 instanceof String && o2 instanceof String) {
            String firstValue = (String) o1;
            String secondValue = (String) o2;

            int len1 = firstValue.toCharArray().length;
            int len2 = secondValue.toCharArray().length;
            int lim = Math.min(len1, len2);
            char[] v1 = firstValue.toCharArray();
            char[] v2 = secondValue.toCharArray();

            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
            return len1 - len2;
        }
        return 0;
    }
}
