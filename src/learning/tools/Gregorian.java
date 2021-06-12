package learning.tools;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * @description
 *      乔治格林时间类
 *      JAVA核心技术 卷1 98  4-1
 * @author:Alexius
 * @date: 2021/6/10 21:17
 */


public class Gregorian {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ITALY);
        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        //设置d为这个月第一天
        d.set(DAY_OF_MONTH,1);
        //第一天星期几
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        //获取当前星期的起始日
        int firstdayofweek = d.getFirstDayOfWeek();
        int indents = 0;
        do
        {
            indents++;
            d.add(DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        while(weekday!=d.getFirstDayOfWeek());

        String[] weekdayNAME = new DateFormatSymbols().getShortMonths();
        do
        {
            System.out.printf("%3s",weekdayNAME[weekday]);
            d.add(DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        while(weekday!=d.getFirstDayOfWeek());

        weekday = d.get(Calendar.DAY_OF_WEEK);

        System.out.println();
        for(int i = 0;i < indents;i++)
            System.out.print(" ");

        d.set(DAY_OF_MONTH, 1);
        do
        {
            int day = d.get(DAY_OF_MONTH);
            System.out.printf("%3d",day);
            if(day == today)
                System.out.print("*");
            d.add(DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if(weekday == d.getFirstDayOfWeek())
                System.out.println();
        }
        while(month == d.get(Calendar.MONTH));

        if(weekday != d.getFirstDayOfWeek()) System.out.println();
    }

}
