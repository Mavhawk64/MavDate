public class WhatsThisDot
{
    public static void main(String[] args) {
        MavDate mavdate = new MavDate(3,14,2002);
        System.out.println(mavdate.toString());
        mavdate.addDaysToDate(25);
        System.out.println(mavdate.toString());
        MavDate cen = new MavDate(3);
        System.out.println("The century is: " + cen.getCentury()); // Should be incorrect.
        MavDate christmas = new MavDate(12,24,2021);
        christmas.addDaysToDate(100);
        System.out.println(christmas.toString());
    }
}
