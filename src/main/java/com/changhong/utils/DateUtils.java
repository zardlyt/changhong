package com.changhong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间处理，时间日志工具类
 * Created by wb-zhaofugui on 2016/12/27.
 */
public class DateUtils {
    /**
     * 默认日期格式，yyyy-MM-dd
     */
    public static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认时间格式，HH:mm:ss
     */
    public static String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    /**
     * 默认日期时间格式，yyyy-MM-dd HH:mm:ss
     */
    public static String DEFAULT_DATETIME_PATTERN = DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;
    /**
     * 默认日期时间格式，yyyyMMdd
     */
    public static String DEFAULT_YEAR_PATTERN = "yyyyMMdd";

    /**
     * 默认日期时间格式，yyyyMMddHHmmss
     */
    public static final String SIMPLE_DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 默认日期时间格式，YYYYMM
     */
    public static final String DEFAULT_MONTH_PATTERN = "yyyyMM";

    /**
     * 获取YYYYMM格式的日期
     *
     * @return 当前系统时间
     */

    public static final String StringToData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_TIME_PATTERN);
            return getCurrentDatas(sdf.parse(data));
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取yyyy-MM-dd HH:mm:ss格式的日期
     *
     * @return 当前系统时间
     */

    public static final Date StringToDatas(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);
        try {
            return sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取yyyyMMdd格式的日期
     *
     * @return 当前系统时间
     */
    public static final String getCurrentDataTime() {
        Date date = new Date();
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_YEAR_PATTERN);
            return simpledateformat.format(date);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取指定格式的日期时间
     *
     * @param pattern
     * @return 指定格式当前系统时间
     */
    public static final String getCurrentDataTime(String pattern) {
        Date date = new Date();
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(pattern);
            return simpledateformat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式的日期
     *
     * @return 当前系统时间
     */
    public static final String getCurrentData() {
        Date date = new Date();
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_DATETIME_PATTERN);
            return simpledateformat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static final String getCurrentDatas(Date date) {
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_DATETIME_PATTERN);
            return simpledateformat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取现在时间
     *
     * @return 返回数字类型 YYYYMMDD
     */
    public static int getNowDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        String dateString = formatter.format(currentTime);
        return Integer.parseInt(dateString);
    }


    /**
     * 获取现在时间月第一天
     *
     * @return 返回数字类型 YYYYMMDD
     */
    public static int getStratDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        //当前月的第一天
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date beginTime = cal.getTime();
        String beginTime1 = datef.format(beginTime);
        return Integer.parseInt(beginTime1);
    }
    /**
     * 获取现在时间月最后一天
     *
     * @return 返回数字类型 YYYYMMDD
     */
    public static int getOverDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        //当前月的最后一天
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        Date endTime = cal.getTime();
        String endTime1 = datef.format(endTime);
        return Integer.parseInt(endTime1);
    }

    /**
     * 得到本季度开始日
     *
     * @return int
     * @Methods Name getStratDayOfQuarter
     */
    public static int getStratDayOfQuarter() {
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        int curMonth = cDay.get(Calendar.MONTH);
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
            cDay.set(Calendar.MONTH, Calendar.JANUARY);
        }
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
            cDay.set(Calendar.MONTH, Calendar.APRIL);
        }
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {
            cDay.set(Calendar.MONTH, Calendar.JULY);
        }
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
            cDay.set(Calendar.MONTH, Calendar.OCTOBER);
        }
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));
        //当前季度的第一天
        Calendar cal = Calendar.getInstance();
        cal.setTime(cDay.getTime());
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date beginTime = cal.getTime();
        String beginTime1 = datef.format(beginTime);
        return Integer.parseInt(beginTime1);
    }

    /**
     * 得到本季度结束日
     *
     * @return int
     * @Methods Name getOverDayOfQuarter
     */
    public static int getOverDayOfQuarter() {
        Date date = new Date();
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        int curMonth = cDay.get(Calendar.MONTH);
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
            cDay.set(Calendar.MONTH, Calendar.MARCH);
        }
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
            cDay.set(Calendar.MONTH, Calendar.JUNE);
        }
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {
            cDay.set(Calendar.MONTH, Calendar.AUGUST);
        }
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
            cDay.set(Calendar.MONTH, Calendar.DECEMBER);
        }
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        //当前季度的最后一天
        cal.setTime(cDay.getTime());
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        Date endTime = cal.getTime();
        String endTime1 = datef.format(endTime);
        return Integer.parseInt(endTime1);
    }


    /**
     * 获取某年第一天日期
     *
     * @return Date
     */
    public static int getStratDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        Date currYearFirst = calendar.getTime();
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        String beginTime1 = datef.format(currYearFirst);
        return Integer.parseInt(beginTime1);
    }

    /**
     * 获取某年最后一天日期
     *
     * @return Date
     */
    public static int getOverDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        SimpleDateFormat datef = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        String endTime1 = datef.format(currYearLast);
        return Integer.parseInt(endTime1);
    }

}
