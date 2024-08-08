package org.esdindev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClimaClientTest {

    @Mock
    private ApiService apiService; // Mock the service that makes the API call

    @InjectMocks
    private ClimaClient climaClient; // The class under test

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCoordinatesByPostalCode() {
        // Given
        String postalCode = "12345";
        double expectedLatitude = 40.7128;
        double expectedLongitude = -74.0060;
        when(apiService.getCoordinates(postalCode)).thenReturn(new Coordinates(expectedLatitude, expectedLongitude));

        // When
        Coordinates coordinates = climaClient.getCoordinatesByPostalCode(postalCode);

        // Then
        assertEquals(expectedLatitude, coordinates.getLatitude());
        assertEquals(expectedLongitude, coordinates.getLongitude());
    }
}