package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class MockitoSpyWithListTest {

    // demonstra a função spy
    @Test
    void ensureSpyForListWorks() {
        var list = new ArrayList<String>();
        var spiedList = spy(list);

        doReturn("42").when(spiedList).get(99);
        String value = (String) spiedList.get(99);

        assertEquals("42", value);
    }
}
