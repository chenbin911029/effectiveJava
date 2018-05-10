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
public class PersonInhance {
    private final Date birthDate;
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END = gmtCal.getTime();
    }

    public PersonInhance(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 改进后，PersonInhance在初始化的时候创建
     * Calendar，TimeZone，Date实例一次
     */
    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >=0
                && birthDate.compareTo(BOOM_END) < 0;
    }
}
