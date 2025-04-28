package com.example.testing.softservice.utils;

import java.util.ArrayList;
import java.util.List;

public class ListSort {

    public static void mergeSort(List<Long> list) {
        int size = list.size();

        if (size > 1) {
            int mid = size / 2;

            List<Long> left = new ArrayList<>(list.subList(0, mid));
            List<Long> right = new ArrayList<>(list.subList(mid, size));

            mergeSort(left);
            mergeSort(right);

            int leftIndex = 0;
            int rightIndex = 0;
            int listIndex = 0;
            int leftSize = left.size();
            int rightSize = right.size();

            while (leftIndex < leftSize && rightIndex < rightSize) {
                long leftValue = left.get(leftIndex);
                long rightValue = right.get(rightIndex);

                if (leftValue < rightValue) {
                    list.set(listIndex, leftValue);
                    leftIndex++;
                } else {
                    list.set(listIndex, rightValue);
                    rightIndex++;
                }

                listIndex++;
            }

            while (leftIndex < leftSize) {
                long leftValue = left.get(leftIndex);

                list.set(listIndex, leftValue);

                leftIndex++;
                listIndex++;
            }

            while (rightIndex < rightSize) {
                long rightValue = right.get(rightIndex);

                list.set(listIndex, rightValue);

                rightIndex++;
                listIndex++;
            }
        }
    }
}
