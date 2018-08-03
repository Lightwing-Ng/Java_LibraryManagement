package com.lightwing.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    public MyDate() {
    }

    public static String getDate() {
        SimpleDateFormat lFormat;
        Calendar MyDate = Calendar.getInstance();
        MyDate.setTime(new java.util.Date());
        java.util.Date date = MyDate.getTime();
        lFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return lFormat.format(date);
    }

    // 闰年中每月天数
    private static final int[] DAYS_P_MONTH_LY = {
            31, 29, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31
    };
    // 平年中每月天数
    private static final int[] DAYS_P_MONTH_CY = {
            31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31
    };

    // 代表数组里的年、月、日
    private static final int Y = 0, M = 1, D = 2;

    // 参与运算用
    private int[] ymd = null;

    /**
     * 检查传入的参数是否合法的日期
     *
     * @param date
     * @throws IllegalArgumentException
     */
    private static void validate(String date) throws IllegalArgumentException {
        int[] ymd = splitYMD(date);

        if (ymd[M] == 0 || ymd[M] > 12) {
            throw new IllegalArgumentException("月份数值错误");
        }

        if (isLeapYear(ymd[0]) && (ymd[D] == 0 || ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1])) {
            throw new IllegalArgumentException("日期数值错误");
        } else if (ymd[D] == 0 || ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
            throw new IllegalArgumentException("日期数值错误");
        }
    }

    /**
     * 检查传入的参数代表的年份是否为闰年
     *
     * @param year
     * @return
     */
    private static boolean isLeapYear(int year) {
        // 注意格里历和儒略历交接时的日期差别
        int gregorianCutoverYear = 1582;
        return year >= gregorianCutoverYear ?
                ((year % 4 == 0) && ((year % 100 != 0) ||
                        (year % 400 == 0))) : // Gregorian
                (year % 4 == 0); // Julian
    }

    /**
     * 日期加1天，注意这里没有考虑儒略历和格里历交接时相差的10天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private int[] addOneDay(int year, int month, int day) {
        if (isLeapYear(year)) {
            day++;
            if (day > DAYS_P_MONTH_LY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        } else {
            day++;
            if (day > DAYS_P_MONTH_CY[month - 1]) {
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }
        return new int[]{
                year, month, day};
    }

    /**
     * 以循环的方式计算日期加法
     *
     * @param date
     * @param days
     * @return
     */
    public String addDaysByLoop(String date, int days) {
        validate(date);
        int[] ymd = splitYMD(date);
        for (int i = 0; i < days; i++) {
            ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 日期减1天，注意这里没有考虑儒略历和格里历交接时相差的10天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private int[] reduceOneDay(int year, int month, int day) {
        if (isLeapYear(year)) {
            day--;
            if (day <= 0) {
                month--;
                if (month < 1) {
                    year--;
                    month = 12;
                }
                day = DAYS_P_MONTH_LY[month - 1];
            }
        } else {
            day--;
            if (day <= 0) {
                month--;
                if (month < 1) {
                    year--;
                    month = 12;
                }
                day = DAYS_P_MONTH_CY[month - 1];
            }
        }
        int[] ymd = {
                year, month, day};
        return ymd;
    }

    /**
     * 以循环的方式计算日期减法
     *
     * @param date
     * @param days
     * @return
     */
    public String reduceDaysByLoop(String date, int days) {
        validate(date);
        int[] ymd = splitYMD(date);
        for (int i = 0; i < days; i++) {
            ymd = reduceOneDay(ymd[Y], ymd[M], ymd[D]);
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 指定日期加上指定的天数的操作
     *
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String addDays(Date date, int days) throws IllegalArgumentException {
        return addDays(formatDate(date), days);
    }

    /**
     * 指定日期加上指定的天数的操作
     *
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String addDays(String date, int days) throws
            IllegalArgumentException {

        validate(date);
        ymd = splitYMD(date);

        if (isLeapYear(ymd[Y])) {
            ymd[D] += days;
            if (ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1]) {
                ymd[M]++;
                ymd[D] = ymd[D] - DAYS_P_MONTH_LY[ymd[M] - 1 - 1];
                if (ymd[M] > 12) {
                    ymd[M] -= 12;
                    ymd[Y]++;
                }
                if (ymd[D] > DAYS_P_MONTH_LY[ymd[M] - 1]) {
                    addDays(formatYear(ymd[Y]) +
                                    formatMonthDay(ymd[M]) +
                                    formatMonthDay(DAYS_P_MONTH_LY[ymd[M] - 1]),
                            ymd[D] - DAYS_P_MONTH_LY[ymd[M] - 1]);
                }
            }
        } else {
            ymd[D] += days;
            if (ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
                ymd[M]++;
                ymd[D] = ymd[D] - DAYS_P_MONTH_CY[ymd[M] - 1 - 1];
                if (ymd[M] > 12) {
                    ymd[M] -= 12;
                    ymd[Y]++;
                }
                if (ymd[D] > DAYS_P_MONTH_CY[ymd[M] - 1]) {
                    addDays(formatYear(ymd[Y]) +
                                    formatMonthDay(ymd[M]) +
                                    formatMonthDay(DAYS_P_MONTH_CY[ymd[M] - 1]),
                            ymd[D] - DAYS_P_MONTH_CY[ymd[M] - 1]);
                }
            }
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 指定日期减去指定的天数的操作
     *
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    public String reduceDays(Date date, int days) throws
            IllegalArgumentException {
        return reduceDays(formatDate(date), days);
    }

    /**
     * 指定日期减去指定的天数的操作
     *
     * @param date
     * @param days
     * @return
     * @throws IllegalArgumentException
     */
    private String reduceDays(String date, int days) throws
            IllegalArgumentException {

        validate(date);
        ymd = splitYMD(date);

        if (isLeapYear(ymd[Y])) {
            ymd[D] -= days;
            if (ymd[D] <= 0) {
                ymd[M]--;
                if (ymd[M] < 1) {
                    ymd[M] += 12;
                    ymd[Y]--;
                }
                ymd[D] = ymd[D] + DAYS_P_MONTH_LY[ymd[M] - 1];
                if (ymd[D] <= 0) {
                    reduceDays(formatYear(ymd[Y]) +
                                    formatMonthDay(ymd[M]) +
                                    formatMonthDay(1),
                            abs(ymd[D] - 1));
                }
            }
        } else {
            ymd[D] -= days;
            if (ymd[D] <= 0) {
                ymd[M]--;
                if (ymd[M] < 1) {
                    ymd[M] += 12;
                    ymd[Y]--;
                }
                ymd[D] = ymd[D] + DAYS_P_MONTH_CY[ymd[M] - 1];
                if (ymd[D] <= 0) {
                    reduceDays(formatYear(ymd[Y]) +
                                    formatMonthDay(ymd[M]) +
                                    formatMonthDay(1),
                            abs(ymd[D] - 1));
                }
            }
        }
        return formatYear(ymd[Y]) +
                formatMonthDay(ymd[M]) +
                formatMonthDay(ymd[D]);
    }

    /**
     * 格式化一个日期字符串
     *
     * @param date
     * @return
     */
    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * 将代表日期的字符串分割为代表年月日的整形数组
     *
     * @param date
     * @return
     */
    private static int[] splitYMD(String date) {
        int[] ymd = {
                0, 0, 0};
        ymd[Y] = Integer.parseInt(date.substring(0, 4));
        ymd[M] = Integer.parseInt(date.substring(4, 6));
        ymd[D] = Integer.parseInt(date.substring(6, 8));
        return ymd;
    }

    /**
     * 将不足两位的月份或日期补足为两位
     *
     * @param decimal
     * @return
     */
    private static String formatMonthDay(int decimal) {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(decimal);
    }

    /**
     * 将不足四位的年份补足为四位
     *
     * @param decimal
     * @return
     */
    private static String formatYear(int decimal) {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(decimal);
    }

    /**
     * 取绝对值操作
     *
     * @param num
     * @return
     */
    private static int abs(int num) {
        return (num > 0) ? num : -num;
    }

    private static String getYear(String date) {
        return date.substring(0, 4);
    }

    private static String getMonth(String date) {
        return date.substring(4, 6);
    }

    private static String getDay(String date) {
        return date.substring(6, 8);
    }

    public static String addMonth(String date) {
        int month = setZ(date.substring(4, 6));
        int year = setZ(date.substring(0, 4));
        if (month + 1 > 12) {
            year++;
            month = 1;
        } else {
            month++;
        }

        return setZ(year) + "" + setZ(month) + date.substring(6, 8) +
                date.substring(8, 10) +
                date.substring(10, 12) + date.substring(12, 14);
    }

    private static int setZ(String i) {
        if (!i.equals("0")) {
            if (i.startsWith("0")) {
                return Integer.parseInt(i.substring(1, 2));
            }
        }
        return Integer.parseInt(i);
    }

    private static String setZ(int i) {
        if (i < 10 && i > 0) {
            return "0" + i;
        } else {
            return "" + i;
        }
    }

    public static String chengeDays(String date, int day) {
        return date.substring(0, 6) + setZ(day) + date.substring(8, 14);
    }

    public static String jianMonth(String date) {
        int month = setZ(date.substring(4, 6));
        int year = setZ(date.substring(0, 4));
        if (month - 1 < 1) {
            year--;
            month = 12;
        } else {
            month--;
        }

        return setZ(year) + "" + setZ(month) + date.substring(6, 8) +
                date.substring(8, 10) +
                date.substring(10, 12) + date.substring(12, 14);
    }


    public static String printDays() {
        String date = getDate();
        return getYear(date) + "." + getMonth(date) + "." + getDay(date);
    }

    public static String printDays(String date) {
        return getYear(date) + "." + getMonth(date) + "." + getDay(date);
    }

    public int getMonthDays(int month, boolean type) {
        int res = 0;
        switch (month) {
            case 1:
                res = 31;
                break;
            case 2:
                if (type) {
                    res = 29;
                } else {
                    res = 28;
                }
                break;
            case 3:
                res = 31;
                break;
            case 4:
                res = 30;
                break;
            case 5:
                res = 31;
                break;
            case 6:
                res = 30;
                break;
            case 7:
                res = 31;
                break;
            case 8:
                res = 31;
                break;
            case 9:
                res = 30;
                break;
            case 10:
                res = 31;
                break;
            case 11:
                res = 30;
                break;
            case 12:
                res = 31;
                break;
        }
        return res;
    }

    public int getYearDay(int years) {
        int res = 0;
        for (int i = 1; i <= years; i++) {
            if (isLeapYear(i)) {
                res += 366;
            } else {
                res += 365;
            }
        }
        return res;
    }

    public static long jianfa(String star, String end) {
        long days = 0;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
            Date d1;
            d1 = f.parse(formatDate(star));
            Date d2 = f.parse(formatDate(end));
            days = (d2.getTime() - d1.getTime()) / (60 * 60 * 24);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return days;
    }

    private static String formatDate(String date) {
        return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
    }
}
