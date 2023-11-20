package com.pongwars

import com.pongwars.support.Driver
import spock.lang.Shared
import spock.lang.Specification

class Spec extends Specification {

    @Shared
    Driver driver = new Driver()

    def setup() {
        driver.start()
    }

    def cleanup(){
        driver.stop()
    }

    def "start a new game" (){
        when:
        sleep(2000)
        def userId = UUID.randomUUID().toString()
        def response = driver.initGame(userId)

        then:
        assert response.getAt("userId") == (userId)
        assert response.getAt("gameId")
    }

}