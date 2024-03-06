package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeCombineTestMethods {
	private Range combineRange1;
    private Range combineRange2;

	@Before
	public void setUp() throws Exception {
		combineRange1 = null;
        combineRange2 = null;
		
	}

	@After
	public void tearDown() throws Exception {
		combineRange1 = null;
        combineRange2 = null;
	}


	
	 @Test
	    public void testCombineBothRangesNull() {
	        assertNull(Range.combine(null, null));
	    }

	  

	    @Test
	    public void testCombineFirstRangeNull() {
	        Range combineRange2 = new Range(0, 5);
	        Range result = Range.combine(null, combineRange2);
	        assertNotNull(result); // Ensure the result is not null
	        assertEquals(combineRange2, result); // Ensure the result equals combineRange2
	    }
	 
	    @Test
	    public void testCombineNotBothNull() {
	        assertNull(Range.combine(combineRange1, combineRange2));
	    }

	    @Test
	    public void testCombineNotFirstNull() {
	        combineRange2 = new Range(0, 5);
	        assertEquals(combineRange2, Range.combine(combineRange1, combineRange2));
	    }

	    @Test
	    public void testCombineNotSecondNull() {
	        combineRange1 = new Range(0, 5);
	        assertEquals(combineRange1, Range.combine(combineRange1, combineRange2));
	    }

	    

	    @Test
	    public void testCombineNotSecondLowerBoundLessThanFirst() {
	        combineRange1 = new Range(0, 5);
	        combineRange2 = new Range(-2, 3);
	        assertEquals(new Range(-2, 5), Range.combine(combineRange1, combineRange2));
	    }
	    
	    @Test
	    public void testCombineFirstRangeUpperBoundLessThanSecond() {
	        combineRange1 = new Range(3, 8);
	        combineRange2 = new Range(0, 5);
	        assertEquals(new Range(0, 8), Range.combine(combineRange1, combineRange2));
	    }


	    @Test
	    public void testCombineSecondRangeUpperBoundLessThanFirst() {
	        combineRange1 = new Range(6, 10);
	        combineRange2 = new Range(0, 5);
	        assertEquals(new Range(0, 10), Range.combine(combineRange1, combineRange2));
	    }

	    
	    
	 

	    @Test
	    public void testCombineFirstRangeOverlapsWithSecond() {
	        combineRange1 = new Range(5, 10);
	        combineRange2 = new Range(0, 5);
	        assertEquals(new Range(0, 10), Range.combine(combineRange1, combineRange2));
	    }

	    @Test
	    public void testCombineRangesEqual() {
	        combineRange1 = new Range(0, 5);
	        combineRange2 = new Range(0, 5);
	        assertEquals(new Range(0, 5), Range.combine(combineRange1, combineRange2));
	    }

	    @Test
	    public void testCombineBothRangesEqual() {
	        combineRange1 = new Range(2, 3);
	        combineRange2 = new Range(2, 3);
	        assertEquals(new Range(2, 3), Range.combine(combineRange1, combineRange2));
	    }

	   
	    

}
