package com.example

import spock.lang.Specification

class TimeFormatterSpec extends Specification {

    def "test the constructor"() {
        when:
        new TimeFormatter("")

        then:
        thrown Exception

        when:
        new TimeFormatter(":00 AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("00: AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("00:00")

        then:
        thrown Exception

        when:
        new TimeFormatter("XX:00:AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("00:XX AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("00:00 XX")

        then:
        thrown Exception

        when:
        new TimeFormatter("13:00 AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("13:00 PM")

        then:
        thrown Exception

        when:
        new TimeFormatter("-12:00 AM")

        then:
        thrown Exception

        when:
        new TimeFormatter("12:60 PM")

        then:
        thrown Exception

        when:
        new TimeFormatter("12:-01 PM")

        then:
        thrown Exception
    }

    def "test the methods"() {
        expect:
        new TimeFormatter("1:00 AM").addMinutes(1440).format() == "1:00 AM"
        new TimeFormatter("1:00 AM").addMinutes(-1440).format() == "1:00 AM"
        new TimeFormatter("0:00 AM").addMinutes(0).format() == "12:00 AM"
        new TimeFormatter("0:00 AM").addMinutes(1).format() == "12:01 AM"
        new TimeFormatter("0:00 AM").addMinutes(-1).format() == "11:59 PM"
        new TimeFormatter("12:00 AM").addMinutes(0).format() == "12:00 AM"
        new TimeFormatter("12:00 AM").addMinutes(1).format() == "12:01 AM"
        new TimeFormatter("12:00 AM").addMinutes(-1).format() == "11:59 PM"
        new TimeFormatter("11:59 AM").addMinutes(0).format() == "11:59 AM"
        new TimeFormatter("11:59 AM").addMinutes(1).format() == "12:00 PM"
        new TimeFormatter("12:00 PM").addMinutes(0).format() == "12:00 PM"
        new TimeFormatter("12:00 PM").addMinutes(1).format() == "12:01 PM"
        new TimeFormatter("12:00 PM").addMinutes(-1).format() == "11:59 AM"
        new TimeFormatter("11:59 PM").addMinutes(0).format() == "11:59 PM"
        new TimeFormatter("11:59 PM").addMinutes(1).format() == "12:00 AM"
    }
}








