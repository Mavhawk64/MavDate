
/**
 * Write a description of class MavDate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MavDate
{
    private int month; private int day; private int year; private int century = 5;

    public String dayOfWeek; //We can do something like mavdate.dayOfWeek = "Wednesday"; in runner.

    public MavDate(int month, int day, int year) {
        this.month = month; //I am setting This Month to be the month passed in
        this.day = day;
        this.year = year;
        this.century = year / 1000; //2021 --> 2
        if(this.month <= 0 || this.month > 12) 
        {
            this.month = 1;
        }
        //1,3,5,7,8,10,12 -- 31
        //4,6,9,11 -- 30
        //2 -- 28 or 29
        int daysInFeb = this.year % 4 == 0 ? 29 : 28; //Is this.year divisible by 4? Yes: 29, No: 28.

        //This if-else if chain can be written in one line... but I wrote it this way for you.
        if(this.month == 2 && this.day > daysInFeb) {
            this.day = 1;
        } else if(this.month < 8 && this.month % 2 == 1 /*1,3,5,7*/ && this.day > 31) {
            this.day = 1;
        } else if(this.month >= 8 && this.month % 2 == 0 /*8,10,12*/ && this.day > 31) {
            this.day = 1;
        } else if(this.day > 30) { //4,6,9,11
            this.day = 1;
        }
    }

    public MavDate(int century) {
        century = century; //I intentionally left off the 'this.' to show it won't set century
    }

    public int getCentury() {
        return this.century;
    }

    public int getDaysInMonth() {
        return this.month == 2 ? this.year % 4 == 0 ? 29 : 28 : (this.month < 8 && this.month % 2 == 1) || (this.month >= 8 && this.month % 2 == 0) ? 31 : 30; 
    }

    public String getMonth() {
        String mo = "";
        //switch is the fancy way of writing:
        //if(this.month == 1) { mo = "January"; }
        //else if(this.month == 2) { mo = "February"; }
        //...
        //else { mo = "Not a Month"; }
        switch(this.month) {
            case 1:
            mo = "January";
            break;
            case 2:
            mo = "February";
            break;
            case 3:
            mo = "March";
            break;
            case 4:
            mo = "April";
            break;
            case 5:
            mo = "May";
            break;
            case 6:
            mo = "June";
            break;
            case 7:
            mo = "July";
            break;
            case 8:
            mo = "August";
            break;
            case 9:
            mo = "September";
            break;
            case 10:
            mo = "October";
            break;
            case 11:
            mo = "November";
            break;
            case 12:
            mo = "December";
            break;
            default:
            mo = "Not a Month";
            break;
        }
        return mo;
    }

    public void addDaysToDate(int amtDays) {
        this.day += amtDays;
        while(this.day > this.getDaysInMonth()) {
            //We are above the cap for days in month!
            this.day -= this.getDaysInMonth();
            this.month += 1;
            if(this.month > 12) {
                this.month = 1;
                this.year += 1;
            }
        }
    }

    @Override
    public String toString() {
        return "The date is " + this.getMonth() + " " + this.day + ", " + this.year + ".";
    }
}
