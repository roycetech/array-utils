package com.github.roycetech.commons;

/**
 * Hello world!
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Combines multi-dimensional array by combining elements from each array.
     *
     * @param arrays source array.
     * @return product of multi-dimensional array.
     */
    public static Object[][] product(Object[][] arrays) {
	if (arrays == null) {
	    return arrays;
	}

	if (arrays.length == 1) {
	    return arrays;
	}

	final int total = computeTotal(arrays);
	final int typeCount = arrays.length;

	final Object[][] result = new Object[total][typeCount];

	for (int y = 0; y < total; y++) {
	    for (int x = 0; x < typeCount; x++) {
		final int divisor = getDivisor(arrays, x);

		final int sourceX;
		if (x == arrays.length - 1) {
		    sourceX = y % arrays[x].length;
		} else {
		    sourceX = y / divisor;
		}

		final int sourceY = x;
		result[y][x] = arrays[sourceY][sourceX % arrays[x].length];
	    }
	}

	return result;
    }

    private static int computeTotal(Object[][] arrays) {
	int total = arrays[0].length;
	for (int i = 1; i < arrays.length; i++) {
	    total *= arrays[i].length;
	}
	return total;
    }

    private static int getDivisor(Object[][] arrays, final int x) {
	int divisor = 1;
	for (int i = x + 1; i < arrays.length; i++) {
	    divisor *= arrays[i].length;
	}
	return divisor;
    }
}
