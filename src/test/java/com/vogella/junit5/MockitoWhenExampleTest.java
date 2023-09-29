package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoWhenExampleTest {
    @Mock
    Iterator<String> i;

    Comparable<String> c;

    // Demonstra o retorno de múltipos valores
    @Test
    void testMoreThanOneReturnValue() {
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();

        // assert
        assertEquals("Mockito rocks", result);
    }

    // esse teste demonstra como retornar valores baseados na entrada
    // e que @Mock também pode ser usado como parâmetro de um método

    @Test
    void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c) {
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);

        //assert
        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

    // retorna um valor baseado no tipo do parâmetro que foi fornecido

    @Test
    void testReturnValueIndependentOnMethodParameter2(@Mock Comparable<Integer> c) {
        when(c.compareTo(isA(Integer.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(Integer.valueOf(4)));
    }
}
