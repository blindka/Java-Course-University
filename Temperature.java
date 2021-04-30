import java.util.Scanner;
/**
 * the user input type of Temperature - the program check if it is valid
 * and converting and outputting different types of Temeprature
 * 
 * @author Eyal Haimov
 * @version 316316868
 */
public class Temperature
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double fahrenheit, kelvin, celcius;
        final double FIVE_DIVIDED_NINE = 5.0/9;
        final double FAHRENHEIT_ADDITION = 32;
        final double FAHRENHEIT_TO_KELVIN = 459.67;
        final double CELCIUS_TO_FAHRENHEIT_DIVIDER = 1.8;
        final double CELCIUS_TO_KELVIN = 273.15;
        System.out.println("Choose type of temperature:\nf. Fahrenheit\nc. Celcius\nk. Kelvin");
        String word = scan.next();
        char tempType = word.charAt(0);
        switch(word){
            case "f":
            System.out.println("Tempertaure Type: '" +tempType+ "' Enter Fahrenheit Temperature:");
            fahrenheit=scan.nextDouble();
            // converting from fahrenheit to celcius, kelvin
            celcius = (fahrenheit-FAHRENHEIT_ADDITION) * FIVE_DIVIDED_NINE;
            kelvin = (fahrenheit + FAHRENHEIT_TO_KELVIN) * FIVE_DIVIDED_NINE;
            System.out.println(+ celcius + " C");
            System.out.println(+ fahrenheit + " F");
            System.out.println(+ kelvin + " K");
            break;
            case "c":
            System.out.println("Tempertaure Type: '" +tempType+ "' Enter Celcius Temperature:");
            celcius=scan.nextDouble();
            // converting from celcius to fahrenheit, kelvin
            fahrenheit = (celcius*CELCIUS_TO_FAHRENHEIT_DIVIDER) + FAHRENHEIT_ADDITION;
            kelvin = celcius + CELCIUS_TO_KELVIN;
            System.out.println(+ celcius + " C");
            System.out.println(+ fahrenheit + " F");
            System.out.println(+ kelvin + " K");
            break;
            case "k":
            System.out.println("Tempertaure Type: '" +tempType+ "' Enter Kelvin Temperature:");
            kelvin=scan.nextDouble();
            // converting from kelvin to fahrenheit, celcius
            fahrenheit = (kelvin-CELCIUS_TO_KELVIN) * CELCIUS_TO_FAHRENHEIT_DIVIDER + FAHRENHEIT_ADDITION;
            celcius = kelvin - CELCIUS_TO_KELVIN;
            System.out.println(+ celcius + " C");
            System.out.println(+ fahrenheit + " F");
            System.out.println(+ kelvin + " K");
            break;
        }
    }
}