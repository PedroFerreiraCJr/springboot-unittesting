package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListMockTest {

	List mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}
}
