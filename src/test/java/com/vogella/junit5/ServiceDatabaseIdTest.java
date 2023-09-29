package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ServiceDatabaseIdTest {
    @Mock
    Database databaseMock;

    @Test
    void ensureMockitoReturnsTheConfiguredValue() {

        // define valor de retorno para o método getUniqueId()
        when(databaseMock.getUniqueId()).thenReturn(42);

        Service service = new Service(databaseMock);

        //use Mock no teste
        assertEquals(service.toString(), "Using database with id: 42");
    }
}
