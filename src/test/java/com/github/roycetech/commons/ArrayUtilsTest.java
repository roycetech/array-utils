package com.github.roycetech.commons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for ArrayUtils
 */
@RunWith(Parameterized.class)
public class ArrayUtilsTest {

    private final Parameter input;

    public ArrayUtilsTest(Parameter input) {
	this.input = input;
    }

    @Parameters(name = "{0}")
    public static Collection<Parameter> generateParameters() {
	final List<Parameter> params = new ArrayList<>();
	params.add(new Parameter(null, "null"));
	params.add(new Parameter(new Object[][] { { 1, 2 } }, "[1, 2]"));
	params.add(new Parameter(new Object[][] { { 1, 2 }, { 'a', 'b' } },
		"[1, a][1, b][2, a][2, b]"));

	params.add(new Parameter(
		new Object[][] { new String[] { "red", "green", "blue" },
			new Integer[] { 1, 2, 3, 4 },
			new Boolean[] { false, true } },
		"[red, 1, false][red, 1, true][red, 2, false][red, 2, true][red, 3, false][red, 3, true][red, 4, false][red, 4, true][green, 1, false][green, 1, true][green, 2, false][green, 2, true][green, 3, false][green, 3, true][green, 4, false][green, 4, true][blue, 1, false][blue, 1, true][blue, 2, false][blue, 2, true][blue, 3, false][blue, 3, true][blue, 4, false][blue, 4, true]"));

	return params;
    }

    /**
     *
     */
    @Test
    public void shouldMatchExpectedResult() {
	final Object[][] actual = ArrayUtils.product(this.input.getInput());

	final StringBuilder actualFormatted = new StringBuilder();
	if (actual == null) {
	    actualFormatted.append(actual);
	} else {
	    for (final Object[] array : actual) {
		actualFormatted.append(Arrays.asList(array));
	    }

	}
	assertEquals(this.input.getExpected(), actualFormatted.toString());
    }
}

class Parameter {
    /** Test scenario. */
    private final Object[][] input;

    /** Expected result, given the current test scenario. */
    private final String expected;

    /**
     * @param input    current scenario, must neither be null nor empty.
     * @param expected expected result, must not be null or empty.
     */
    Parameter(final Object[][] input, final String expected) {
	super();

	this.input = input;
	this.expected = expected;
    }

    Object[][] getInput() {
	return input;
    }

    String getExpected() {
	return expected;
    }

    /**
     * This will appear in the test runner grid. New lines break the test runner
     * so we exclude them.
     *
     * @see {@link Object#toString()}
     * @return String representation of this instance.
     */
    @Override
    public String toString() {
	final StringBuilder retval = new StringBuilder();
	retval.append("Expect=[").append(getExpected()).append(']');

	if (getInput() == null) {
	    retval.append(": Scenario: null");
	} else {
	    retval.append(": Scenario: ")
		    .append(Arrays.deepToString(getInput()));
	}

	return retval.toString();
    }
}
