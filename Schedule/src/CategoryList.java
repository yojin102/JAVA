//public class CategoryList implements CalendarInterface {
//    static final int NUM_CALENDAR = 3;
//    Calendar[] mCalendars = new Calendar[NUM_CALENDAR];
//    static int mCalendarCount = 0;
//
//    public CategoryList(){
//
//    }
//
//    @Override
//    public void printCalendarList(Calendar[] p) {
//        for(int i =0; i<p.length; i++){
//            System.out.print(p[i].getYear() + " | ");
//            System.out.print(p[i].getMonth() + " | ");
//            System.out.print(p[i].getDay() + " | ");
//            System.out.print(p[i].getCategory() + " | ");
//            System.out.print(p[i].getDate());
//            System.out.println(" ");
//        }
//    }
//    public void print(){
//        System.out.println("일정있는 모든 리스트 출력");
//        System.out.println("--------------------------------------------");
//        System.out.println("연도\t| 월 \t| 일 \t| 카테고리 \t| 일정");
//        for(int i =0; i<mCalendarCount; i++){
//            System.out.print(" "+ mCalendars[i].getYear() + "\t| ");
//            System.out.print(" "+ mCalendars[i].getMonth() + "\t| ");
//            System.out.print(" "+ mCalendars[i].getDay() + "\t| ");
//            System.out.print(" "+ mCalendars[i].getCategory() + "\t| ");
//            System.out.print(" "+ mCalendars[i].getDate() + "\t| ");
//            System.out.println(" ");
//        }
//        System.out.println("--------------------------------------------");
//    }
//}
