package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeConstrainsTestMethod {
	
	private Range constrainRangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		constrainRangeObjectUnderTest = new Range(0,10);
		
	}

	@After
	public void tearDown() throws Exception {
		constrainRangeObjectUnderTest = null;
	}

	public void testValidValueWithinRange() {
        assertEquals(3.0, constrainRangeObjectUnderTest.constrain(3.0), 0.0);
    }

    @Test
    public void testValidValueBelowLowerBound() {
        assertEquals(0.0, constrainRangeObjectUnderTest.constrain(-2.0), 0.0);
    }

    @Test
    public void testValidValueAboveUpperBound() {
        assertEquals(10.0, constrainRangeObjectUnderTest.constrain(12.0), 0.0);
    }

    @Test
    public void testBoundaryCaseLowerBoundValue() {
        assertEquals(0.0, constrainRangeObjectUnderTest.constrain(0.0), 0.0);
    }

    @Test
    public void testBoundaryCaseUpperBoundValue() {
        assertEquals(10.0, constrainRangeObjectUnderTest.constrain(10.0), 0.0);
    }

    @Test
    public void testValidValueWithinRangeDecimal() {
        assertEquals(7.5, constrainRangeObjectUnderTest.constrain(7.5), 0.0);
    }

    @Test
    public void testValidValueBelowLowerBoundDecimal() {
        assertEquals(0.0, constrainRangeObjectUnderTest.constrain(-3.5), 0.0);
    }

    @Test
    public void testValidValueAboveUpperBoundDecimal() {
        assertEquals(10.0, constrainRangeObjectUnderTest.constrain(15.5), 0.0);
    }

    @Test
    public void testBoundaryCaseLowerBoundValueDecimal() {
        assertEquals(0.0, constrainRangeObjectUnderTest.constrain(0.0), 0.0);
    }

    @Test
    public void testBoundaryCaseUpperBoundValueDecimal() {
        assertEquals(10.0, constrainRangeObjectUnderTest.constrain(10.0), 0.0);
    }

    @Test
    public void testValidValueWithinRangeNegative() {
        Range negativeRangeObject = new Range(-10, -5);
        assertEquals(-3.0, negativeRangeObject.constrain(-3.0), 0.0);
    }

    @Test
    public void testValidValueBelowLowerBoundNegative() {
        Range negativeRangeObject = new Range(-10, -5);
        assertEquals(-10.0, negativeRangeObject.constrain(-12.0), 0.0);
    }

    @Test
    public void testValidValueAboveUpperBoundNegative() {
        Range negativeRangeObject = new Range(-10, -5);
        assertEquals(-5.0, negativeRangeObject.constrain(-2.0), 0.0);
    }

    @Test
    public void testBoundaryCaseLowerBoundValueNegative() {
        Range negativeRangeObject = new Range(-10, -5);
        assertEquals(-10.0, negativeRangeObject.constrain(-10.0), 0.0);
    }

    @Test
    public void testBoundaryCaseUpperBoundValueNegative() {
        Range negativeRangeObject = new Range(-10, -5);
        assertEquals(-5.0, negativeRangeObject.constrain(-5.0), 0.0);
    }
}
