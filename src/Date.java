public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year){//פעולה בונה
        this.day=day;
        this.month=month;
        this.year=year;
    }
    //גטים
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //סטים
    public void setDay(int dayToSet) {
        this.day = dayToSet;
    }

    public void setMonth(int monthToSet) {
        this.month = monthToSet;
    }

    public void setYear(int yearToSet) {
        this.year = yearToSet;
    }

    //פעולה המקבלת תאריך ומחזירה מספר חיובי עם התאריך הנוכחי מאוחר התאריך שהתקבל אפס אם התאריכים שווים ומספר שלילי עם התאריך עכשיו קודם לתאריך שהתקבל
    public int compareTo(Date other){
        if(other.getYear() != this.year)
            return (this.year-other.getYear());
        if (other.getMonth() != this.month)
            return (this.month-other.getMonth());
        if (other.getDay() != this.day)
            return (this.day- other.getDay());
        else
            return (0);
    }

    public Date futureDate(int k){
        Date temp=this;
        temp.day+=k;
        while (temp.day>31||temp.day<1){
             if(temp.day>31){
                 temp.month++;
                 temp.day-=31;
                 if(temp.month>12){
                     temp.year++;
                     temp.month=0;
                 }
             }
             else{
                 temp.month--;
                 temp.day+=31;
                 if (temp.month<1){
                     temp.month=12;
                     temp.year--;
                 }
             }
        }
        return temp;
    }

    //פעולה מחזירה מחרוזת של התאריך
    public String toString(){
        return (this.day+"."+this.month+"."+this.year);
    }
}
