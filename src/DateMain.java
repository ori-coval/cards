public class DateMain {
    public static void main(String[] args) {
        Date d1 =new Date(16,7,1963);
        Date d2 = d1;
        d1.setDay(20);
        d2.setYear(1980);
        System.out.println(d1);
        System.out.println(d2);
    }
}
/*
1.
20.7.1980
20.7.1980

2.
2
d1 ו d2
 */

