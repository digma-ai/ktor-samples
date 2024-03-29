package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.opentelemetry.api.GlobalOpenTelemetry
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.instrumentation.ktor.v2_0.server.KtorServerTracing

fun main() {

    val openTelemetry: OpenTelemetry = GlobalOpenTelemetry.get()

    embeddedServer(Netty, port=8082,host="0.0.0.0") {
        install(KtorServerTracing) {
            setOpenTelemetry(openTelemetry)
        }
        routing() {
            get("/") {
                   call.respondText("Hello World!")
            }
//            get(Regex("/(?<name>.+)/hello")){
//
//            }
            post("/myPost"){
                call.respondText("Hello World!")
            }
            delete("/myDelete"){
                call.respondText("Hello World!")
            }
            put("/myPut"){
                call.respondText("Hello World!")
            }
            patch("/myPatch"){
                call.respondText("Hello World!")
            }
            options("/myOptions"){
                call.respondText("Hello World!")
            }
        }

        routing {
            get("/aaa") {
                call.respondText("Hello World!")
            }
            head("/myHead") {
                call.respondText("Hello World!")
            }
        }

    }.start(wait = true)

}

//fun Application.module() {
//    configureSerialization()
//    configureRouting()
//}
