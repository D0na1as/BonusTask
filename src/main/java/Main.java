import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        printBonusDatesBetween(2010, 2015);
    }

    static void printBonusDatesBetween(int fromYear, int toYear) {

        String reverseDate;
        int temp;

        for (int i=fromYear; i<=toYear; i++ ) {
            int length = String.valueOf(i).length();
            if (length>2 && length<5) {
                temp = i;
                reverseDate = "" +temp;
                if (temp%10<3) {
                    reverseDate += "-" + temp%10;
                    temp = temp/10;
                    reverseDate += temp%10;
                    temp = temp/10;
                    if (temp<32) {
                        if (length==3) {
                            reverseDate += "-" + temp + "0";
                            if (isValidDate(reverseDate)) {
                                System.out.println(reverseDate);
                            }
                        } else if (length==4) {
                            reverseDate += "-" + temp%10;
                            temp = temp/10;
                            reverseDate += temp%10;
                            if (isValidDate(reverseDate)) {
                                System.out.println(reverseDate);
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isValidDate(String input) {
        String formatString = "yyyy-MM-dd";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }

        return true;
    }

}
