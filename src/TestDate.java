public class TestDate {
    public static void main(String[] args) {
        Date date1 = new Date(13,5,2003);
        Date date2 = new Date(15,6,2013);
        date1.setDay(20);
        date1.setMonth(7);
        date1.setYear(2004);
        System.out.println(date1.getDay());
        System.out.println(date1.getMonth());
        System.out.println(date1.getYear());
        System.out.println(date1.compareTo(date2));
        System.out.println(date1.toString());
        System.out.println(date1.futureDate(13).toString());
    }
}
/*
20
7
2004
-9
20.7.2004
2.8.2004
 */
