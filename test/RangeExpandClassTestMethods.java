package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandClassTestMethods {
	private Range expandObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		expandObjectUnderTest = null;
	}

	@After
	public void tearDown() throws Exception {
		expandObjectUnderTest = null;
	}

	 @Test
	    public void testExpandNullRange() {
	        try {
	            Range expandedRange = Range.expand(null, 0.25, 0.5);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }

	    
	    @Test
	    public void testExpandInvalidMargins() {
	        try {
	            Range expandedRange = Range.expand(expandObjectUnderTest, -0.5, 1.5);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }

	    
	    @Test
	    public void testExpandRangeWithSameBounds() {
	        Range range = new Range(5, 5);
	        Range expandedRange = Range.expand(range, 0, 0);
	        assertEquals(range, expandedRange);
	    }

	    // SECT-7: Range with negative bounds and margins
	    @Test
	    public void testExpandNegativeBoundsAndMargins() {
	        Range range = new Range(0, 10);
	        Range expandedRange = Range.expand(range, -0.5, 0.5);
	        assertEquals(new Range(-5, 15), expandedRange);
	    }

	    // SECT-8: Range with negative and positive margins
	    @Test
	    public void testExpandNegativePositiveMargins() {
	        Range range = new Range(-3, 3);
	        Range expandedRange = Range.expand(range, -0.25, 0.25);
	        assertEquals(new Range(-4.5, 4.5), expandedRange);
	    }

	    // SECT-9: Range with inconsistent bounds and margins
	    @Test
	    public void testExpandInconsistentBoundsAndMargins() {
	        try {
	            Range range = new Range(5, 3);
	            Range expandedRange = Range.expand(range, 0.2, 0.1);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertFalse("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }
	    
	    @Test
	    public void testExpandMethodWithNullShouldFail() {
	        try {
	            Range.expand(null, 0.1, 0.2); // Attempt to expand a null range
	             
	        } catch (IllegalArgumentException e) {
	            // If an IllegalArgumentException is caught, the test will pass, indicating the method behaved as expected
	        }
	    }
	    // SECT-10: Range with positive bounds and margins
	    @Test
	    public void testExpandPositiveBoundsAndMargins() {
	        Range range = new Range(1, 5);
	        Range expandedRange = Range.expand(range, 0.5, 0.5);
	        assertEquals(new Range(0, 7), expandedRange);
	    }

	    // SECT-11: Range with positive and negative bounds and margins
	    @Test
	    public void testExpandPositiveNegativeBoundsAndMargins() {
	        try {
	            Range range = new Range(8, 2);
	            Range expandedRange = Range.expand(range, -0.25, 0.25);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }

	
	    @Test
	    public void testExpandZeroBoundsAndMargins() {
	        Range range = new Range(0, 0);
	        Range expandedRange = Range.expand(range, 0, 0);
	        assertEquals(range, expandedRange);
	    }

	   
	    @Test
	    public void testExpandNegativeBoundsAndZeroMargins() {
	        Range range = new Range(-5, -1);
	        Range expandedRange = Range.expand(range, 0, 0);
	        assertEquals(range, expandedRange);
	    }

	   
	    @Test
	    public void testExpandPositiveBoundsAndZeroMargins() {
	        Range range = new Range(1, 5);
	        Range expandedRange = Range.expand(range, 0, 0);
	        assertEquals(range, expandedRange);
	    }

	    
	    @Test
	    public void testExpandZeroBoundsAndPositiveMargins() {
	        Range range = new Range(0, 0);
	        Range expandedRange = Range.expand(range, 0.25, 0.25);
	        assertEquals(new Range(-0.25, 0.25), expandedRange);
	    }

	  
	    @Test
	    public void testExpandNegativeBoundsAndPositiveMargins() {
	        Range range = new Range(-3, -1);
	        Range expandedRange = Range.expand(range, 0.25, 0.5);
	        assertEquals(new Range(-3.25, -0.5), expandedRange);
	    }

	    
	    @Test
	    public void testExpandPositiveBoundsAndNegativeMargins() {
	        try {
	            Range range = new Range(1, 5);
	            Range expandedRange = Range.expand(range, -0.5, -0.25);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertFalse("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }

	   
	    @Test
	    public void testExpandNegativeBoundsAndPositiveNegativeMargins() {
	        Range range = new Range(-3, -1);
	        Range expandedRange = Range.expand(range, -0.5, 0.5);
	        assertEquals(new Range(-4.5, 0.5), expandedRange);
	    }

	    @Test
	    public void testExpandPositiveBoundsAndNegativePositiveMargins() {
	        try {
	            Range range = new Range(1, 5);
	            Range expandedRange = Range.expand(range, -0.25, 0.5);
	            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            assertFalse("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	        }
	    }

	    
	    @Test
	    public void testExpandPositiveBoundsAndZeroMarginsExpand() {
	        Range range = new Range(1, 5);
	        Range expandedRange = Range.expand(range, 0, 0);
	        assertEquals(range, expandedRange);
	    }
	    
	  

	    @Test
	    public void testNullRangeArgumentForFirstMethod() {
	        try {
	            Range result = Range.expand(null, 0.25, 0.5);
	            
	        } catch (InvalidParameterException e ) {
	        	assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
	        }
	    }

	    @Test
	    public void testExpandedRangeForSecondMethod() {
	        Range range = new Range(2, 6);
	        Range result = Range.expand(range, 0.25, 0.5);
	        assertEquals(1.0, result.getLowerBound(), 0.001);
	        assertEquals(8.0, result.getUpperBound(), 0.001);
	    }

	    @Test
	    public void testExpandedRangeForFirstMethod() {
	        Range range = new Range(2, 6);
	        Range result = Range.expand(range, 0.25, 0.5);
	        assertEquals(1.0, result.getLowerBound(), 0.001);
	        assertEquals(8.0, result.getUpperBound(), 0.001);
	    }
	    
}
