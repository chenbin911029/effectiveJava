package main.com.effectiveJava.charcter02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-09
 * Time: 11:30
 */
public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * don't do this
     * 每次调用的时候，都会新建一个Calendar，
     * 一个TimeZone，两个Date
     */
    public boolean isBabyBoomer() {
        //unnecessary allocation of expensive object
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        Date boomEnd = gmtCal.getTime();

        return birthDate.compareTo(boomStart) >=0
                && birthDate.compareTo(boomEnd) < 0;
    }
}
