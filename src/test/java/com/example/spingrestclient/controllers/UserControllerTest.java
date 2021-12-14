package com.example.spingrestclient.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/12/21
 */
//@WebFluxTest(controllers = {
//        UserController.class
//})
@SpringBootTest
@AutoConfigureWebTestClient
class UserControllerTest {

    @Autowired
    ApplicationContext applicationContext;

    WebTestClient webTestClient;

    @BeforeEach
    void setUp() throws Exception{
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @Test
    void index() throws Exception{
        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void formPost() throws Exception{
        MultiValueMap <String, String> formData = new LinkedMultiValueMap<>();
        formData.add("limit", "3");

        webTestClient.post().uri("users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .exchange()
                .expectStatus().isOk();
    }
}