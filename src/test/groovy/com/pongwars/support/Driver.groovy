package com.pongwars.support

import com.pongwars.ApplicationKt
import groovy.json.JsonBuilder
import groovyx.net.http.RESTClient

class Driver {
    def thread
    RESTClient client = new RESTClient("http://localhost:8080/")

    def start() {
        thread = new Thread({
            ApplicationKt.main()
        })
        thread.start()
    }

    def stop() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt() // Interrupt the thread if it's running
            try {
                thread.join() // Wait for the thread to finish
            } catch (InterruptedException e) {
                // Handle the interruption exception if needed
//                e.printStackTrace()
            }
        }
    }

    def initGame(userId) {
        def res = client.post([
                path: 'games',
                body: new JsonBuilder(new GameRequest(userId: userId)).toPrettyString(),
                contentType: "application/json"
        ])

        assert res.status == 201

        return res.responseData

    }

}
