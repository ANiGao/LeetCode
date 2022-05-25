package other_;

public class LeetCode_1360 {
}

class Solution_1360 {
    int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysPassed1917(date1) - daysPassed1917(date2));
    }

    // 计算这个日期与1971.01.01日的差，之后再做差取绝对值即可
    public int daysPassed1917(String date) {
        int countDay = 0;
        String[] temp = date.split("-");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        // 先加上整年
        for (int i = 1970; i < year; i++) {
            if (isLeapYear(i)) {
                countDay += 366;
            } else {
                countDay += 365;
            }
        }
        // 然后加月
        for (int i = 1; i < month; i++) {
            countDay += months[i];
        }
        if (month > 2 && isLeapYear(year)) {
            countDay++;
        }
        // 然后加剩下的日
        countDay += day;
        return countDay;
    }

    // 判断是否为闰年
    public boolean isLeapYear(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }
}