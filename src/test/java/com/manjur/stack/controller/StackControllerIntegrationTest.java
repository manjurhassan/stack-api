package com.manjur.stack.controller;

import com.manjur.stack.controller.ui.model.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StackControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void pushToStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/push/10"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    @Test
    void popFromStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/push/10"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);

        response = restTemplate.exchange(
                createURLWithPort("/stack/pop"), HttpMethod.GET, null, Result.class);
        result = response.getBody();
        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    @Test
    void peekStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/push/10"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);

        response = restTemplate.exchange(
                createURLWithPort("/stack/peek"), HttpMethod.GET, null, Result.class);
        result = response.getBody();
        assertNotNull(result);
        assertEquals(10, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    @Test
    void sizeOfStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/push/10"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);

        response = restTemplate.exchange(
                createURLWithPort("/stack/size"), HttpMethod.GET, null, Result.class);
        result = response.getBody();
        assertNotNull(result);
        assertEquals(4, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    @Test
    void isEmptyStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/push/10"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);

        response = restTemplate.exchange(
                createURLWithPort("/stack/isEmpty"), HttpMethod.GET, null, Result.class);
        result = response.getBody();
        assertNotNull(result);
        assertEquals(0, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    @Test
    void resizeOfStackIntegrationTest() {

        ResponseEntity<Result> response = restTemplate.exchange(
                createURLWithPort("/stack/resize/110"), HttpMethod.POST, null, Result.class);
        Result result = response.getBody();
        assertNotNull(result);
        assertEquals(110, result.getValue());
        assertTrue(result.isSuccess());
        assertFalse(result.isEmpty());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}