import java.text.DecimalFormat;
import java.util.Scanner;
public class BMICalculator {
    /**
     * Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     *
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return User's BMI weight(kg)/height(m)^2
     */
    public static double computeBMI(int inches, int pounds) {
        double kgs, meters;
        if(inches <= 0 || pounds <= 0)
            return 0.;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        return kgs/(Math.pow(meters, 2));
    }

    /**
     * Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches, pounds;
        DecimalFormat df = new DecimalFormat("0.00");
        while (true) {
            // sanitize height and convert to inches 6'2"
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit ");
                userin = in.nextLine();
                if (userin.equals("0"))
                    break;
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
                inches += Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));
                //System.out.println("DEBUG: " + inches);
                System.out.print("Enter your weight in pounds: ");
                pounds = Integer.parseInt(in.nextLine());
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)) + " kg/m^2");
            }
            catch (Exception e) {
                System.out.println("There was an error, see here: " + e.toString());
            }

        }
    }
}