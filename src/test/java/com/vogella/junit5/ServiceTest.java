package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Pede para o Mockito criar os mocks baseado na anotação @Mock
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    // Pede para o Mockito mockar a instância databaseMock
    @Mock
    Database databaseMock;

    @Test
    public void testQuery() {
        // Configura o Mock para retornar true quando o método isAvailable for chamado (linha 23)
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);

        // Executa o código da classe sob teste
        Service t = new Service(databaseMock);
        boolean check = t.query("* from t");

        // Verifica que a chamada do método retorna true
        assertTrue(check);
    }

}
