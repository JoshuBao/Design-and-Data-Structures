import java.util.Scanner;

public class BinaryConverter {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Binary Converter!");
        System.out.println("Enter 0 to convert from decimal to binary, or 1 to convert from binary to decimal:");
        int conversionChoice = scanner.nextInt();
        
        System.out.println("Enter the number to convert:");
        long num = scanner.nextLong();
        
        String convertedNumber;
        if (conversionChoice == 0) {
            convertedNumber = convToBin(num);
        } else if (conversionChoice == 1) {
            convertedNumber = convToDec(num);
        } else {
            System.out.println("Invalid input. Please enter either 0 or 1.");
            return;
        }
        
        System.out.println("The converted number is: " + convertedNumber);
    }
    

    public static String convToDec(long bin) {
        
        long decimal = 0;
        long powerOfTwo = 1;
        while (bin > 0) {
            long digit = bin % 10;
            decimal += digit * powerOfTwo;
            bin = bin / 10;
            powerOfTwo *= 2;
        }
        return String.valueOf(decimal);
    }
    
    public static String convToBin(long dec) {
        
        if (dec == 0) {
            return "0";
        }
        
        String binary = "";
        while (dec > 0) {
            binary = (dec % 2) + binary;
            dec = dec / 2;
        }
        return binary;
    }
    
    
}