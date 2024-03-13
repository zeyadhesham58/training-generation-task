import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
class function {
    // Function that prints normal 4 block routine
    public void blockFunction (LocalDate date,int counter,long repeat){
        int n=1;
        while (n<=repeat){
            System.out.println("Week #" + counter + " - Recovery week - from " + date + " to " + date.plusDays(6));
            counter++;
            System.out.println("Week #" + counter + " - Build 1 week - from " + date.plusWeeks(1) + " to " + date.plusDays(13));
            counter++;
            System.out.println("Week #" + counter + " - Build 2 week - from " + date.plusWeeks(2) + " to " + date.plusDays(20));
            counter++;
            System.out.println("Week #" + counter + " - Key week - from " + date.plusWeeks(3) + " to " + date.plusDays(27));
            counter++;
            n++;
            date=date.plusWeeks(4);
        }

    }
}
public class Main {
    public static void main(String[] args) {
        function obj = new function();
        Scanner scanner = new Scanner(System.in);
        // Taking in User Input for Start Date
        System.out.println("Enter the Start Date:");
        System.out.println("Enter the year:");
        int startYear = scanner.nextInt();
        System.out.println("Enter the month (1-12):");
        int startMonth = scanner.nextInt();
        System.out.println("Enter the day of the month:");
        int startDay = scanner.nextInt();
        // Create a LocalDate object from the input values
        LocalDate startDate = LocalDate.of(startYear,startMonth,startDay);
        // Print the  Start Date
        System.out.println("Date entered: " + startDate);
        // Taking in User Input for Race Date
        System.out.println("Enter the Race Date:");
        System.out.println("Enter the year:");
        int raceYear = scanner.nextInt();
        System.out.println("Enter the month (1-12):");
        int raceMonth = scanner.nextInt();
        System.out.println("Enter the day of the month:");
        int raceDay = scanner.nextInt();
        // Create a LocalDate object from the input values
        LocalDate raceDate = LocalDate.of(raceYear, raceMonth, raceDay);
        // Print the Race date
        System.out.println("Date entered: " + raceDate);
        // To calculate difference in weeks between start and race dates
        long weeksDifference = ChronoUnit.WEEKS.between(startDate, raceDate);
        long daysDifference = startDate.until(raceDate, ChronoUnit.DAYS);
        // Weeks less than a full week by just one day will cause an error
        if ((daysDifference+1)%7==0){
            weeksDifference++;
        }
        scanner.close();
        // Error given if difference in weeks is less than 8
        if (weeksDifference<8) {
            System.out.println("Number of weeks is less than 8!");
            return;
        }
        // to find out number of main blocks
        long blocks= weeksDifference-4;
        // first 2 weeks printed which are the same for every case
        System.out.println("Week #1 - Test - from " + startDate + " to " + startDate.plusDays(6));
        System.out.println("Week #2 - Test - from " + startDate.plusWeeks(1) + " to " + startDate.plusDays(13));
        // if number of total weeks is 9,13,17... ( Has a filler week )
        if (blocks%4==1 ){
            System.out.println("Week #3 - Filler Week - from " + startDate.plusWeeks(2) + " to " + startDate.plusDays(20));
            int counter=4;
            startDate=startDate.plusWeeks(3);
            long repeat=(blocks-1)/4;
            obj.blockFunction(startDate,counter,repeat);
            startDate=startDate.plusWeeks(repeat*4);

        }
        // if number of weeks is 8,12,16...
        if (blocks%4==0){
            int counter=3;
            startDate=startDate.plusWeeks(2);
            long repeat=(blocks)/4;
            obj.blockFunction(startDate,counter,repeat);
            startDate=startDate.plusWeeks(repeat*4);
        }
        // if number of weeks is 10,14,18...
        if (blocks%4==2){
            int counter=3;
            startDate=startDate.plusWeeks(2);
            System.out.println("Week #" + counter + " - Build 2 week - from " + startDate + " to " + startDate.plusDays(6));
            counter++;
            System.out.println("Week #" + counter + " - Key week - from " + startDate.plusWeeks(1) + " to " + startDate.plusDays(13));
            counter++;
            startDate=startDate.plusWeeks(2);
            long repeat=(blocks)/4;
            obj.blockFunction(startDate,counter,repeat);
            startDate=startDate.plusWeeks(repeat*4);
        }
        // if number of weeks is 11,15,19...
        if (blocks%4==3){
            int counter=3;
            startDate=startDate.plusWeeks(2);
            System.out.println("Week #" + counter + " - Build 1 week - from " + startDate + " to " + startDate.plusDays(6));
            counter++;
            System.out.println("Week #" + counter + " - Build 2 week - from " + startDate.plusWeeks(1) + " to " + startDate.plusDays(13));
            counter++;
            System.out.println("Week #" + counter + " - Key week - from " + startDate.plusWeeks(2) + " to " + startDate.plusDays(20));
            counter++;
            startDate=startDate.plusWeeks(3);
            long repeat=(blocks)/4;
            obj.blockFunction(startDate,counter,repeat);
            startDate=startDate.plusWeeks(repeat*4);
        }
        // Last 2 weeks printed which are the same for every case
        int week = (int) (weeksDifference-1);
        System.out.println("Week #" + week + " - Taper Week - from " + startDate + " to " + startDate.plusDays(6));
        week++;
        System.out.println("Week #" + week + " - Race Week - from " + startDate.plusWeeks(1) + " to " + raceDate);

    }
}
