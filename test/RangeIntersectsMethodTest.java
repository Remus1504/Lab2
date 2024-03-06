package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeIntersectsMethodTest {
	private Range intersectsObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		intersectsObjectUnderTest = new Range(0, 5);
		
	}

	@After
	public void tearDown() throws Exception {
		intersectsObjectUnderTest = null;
	}

	@Test
    public void testValidRangeIntersects() {
        assertTrue(intersectsObjectUnderTest.intersects(0.0, 5.0));
    }

    @Test
    public void testValidRangeNoIntersection() {
        assertTrue(intersectsObjectUnderTest.intersects(-1, 0.0));
    }

    @Test
    public void testValidRangeBoundary() {
        assertTrue(intersectsObjectUnderTest.intersects(2.0, 2.0));
    }

    @Test
    public void testValidRangeCloseBoundaries() {
        assertTrue(intersectsObjectUnderTest.intersects(3.5, 3.7));
    }

    @Test
    public void testBoundaryCaseWithEqualBoundsIntersects() {
        assertTrue(intersectsObjectUnderTest.intersects(2.0, 2.0));
    }

    @Test
    public void testBoundaryCaseWithEqualBoundsNoIntersection() {
        assertFalse(intersectsObjectUnderTest.intersects(0.0, 0.0));
    }

    @Test
    public void testBoundaryCaseWithEqualBoundsCloseBoundaries() {
        assertTrue(intersectsObjectUnderTest.intersects(3.0, 3.001));
    }

    @Test
    public void testInvalidRangeIntersects() {
        assertFalse(intersectsObjectUnderTest.intersects(5.0, 0.0));
    }

    @Test
    public void testInvalidRangeNoIntersection() {
        assertTrue(intersectsObjectUnderTest.intersects(-2, 1));
    }

    @Test
    public void testInvalidRangeCloseBoundaries() {
        assertFalse(intersectsObjectUnderTest.intersects(3.7, 3.5));
    }

    @Test
    public void testBoundaryCaseWithEqualBoundsIntersectsAgain() {
        assertTrue(intersectsObjectUnderTest.intersects(2.0, 2.0));
    }

 

    @Test
    public void testBoundaryCaseWithEqualBoundsCloseBoundariesAgain() {
        assertTrue(intersectsObjectUnderTest.intersects(-1.0, -1.0));
    }

    // Additional Boundary Tests
    @Test
    public void testLowerBoundMinusOneDecimal() {
        assertTrue(intersectsObjectUnderTest.intersects(-1.1, 0.0));
    }

    @Test
    public void testUpperBoundPlusOneDecimal() {
        assertFalse(intersectsObjectUnderTest.intersects(5.0, 5.1));
    }

    @Test
    public void testLowerBoundEqualsLowerBound() {
        assertTrue(intersectsObjectUnderTest.intersects(0.0, 5.0));
    }

    @Test
    public void testUpperBoundEqualsUpperBound() {
        assertTrue(intersectsObjectUnderTest.intersects(0.0, 5.0));
    }

    @Test
    public void testLowerBoundEqualsUpperBoundMinusOneDecimal() {
        assertFalse(intersectsObjectUnderTest.intersects(4.9, 5.0));
    }

    @Test
    public void testUpperBoundEqualsLowerBoundPlusOneDecimal() {
        assertTrue(intersectsObjectUnderTest.intersects(0.0, 0.1));
    }
    
}
