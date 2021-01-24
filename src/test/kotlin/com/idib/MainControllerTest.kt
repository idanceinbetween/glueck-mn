package com.idib

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpRequest.GET
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MainControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient

    @Test
    fun `test for main controller` () {
        val request: HttpRequest<Any> = GET("/api")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("Hello World", body)

    }
}
