package org.example;
import java.util.Scanner;

public class InteractiveOrderProcessor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Part 1: Interactive Order Processing Logic
        System.out.println("Welcome to the Interactive Order Processor!");
        System.out.println("\n--- Enter Order Details ---");

        System.out.print("Enter unit price: ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Is customer a member (true/false)?: ");
        boolean isMember = sc.nextBoolean();
        sc.nextLine(); //consume the leftover newline

        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = sc.nextLine();

        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = sc.nextLine();

        System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none): ");
        String discountCode = sc.nextLine();

        double subTotal = unitPrice * quantity;
        double currentTotal = subTotal; //will update each step

        System.out.println("\n--- Calculation Steps ---");
        System.out.printf("Initial Subtotal: $%.2f\n", subTotal);

        //TIER DISCOUNT (if else if else)
        if(customerTier.equals("Gold")){
            currentTotal = currentTotal * 0.85;
        }else if(customerTier.equals("Silver")){
            currentTotal = currentTotal * 0.90;
        }

        System.out.printf("After Tier Discount: $%.2f\n", currentTotal);

        //QUANTITY DISCOUNT (use if)
        if (quantity >= 5){
            currentTotal = currentTotal*0.95;
        }
        System.out.printf("After Quantity Discount: $%.2f\n", currentTotal);

        //PROMO CODE (if else if)
        boolean freeShipping = false;
        if(discountCode.equals("SAVE10") && currentTotal > 75.0){
            currentTotal -= 10;
        }  else if (discountCode.equalsIgnoreCase("FREESHIP")){
            freeShipping = true;
        }
        System.out.printf("After Promotional Code: %.2f\n", currentTotal);

        //SMALLER ORDER SURCHARGE (use ternary)
        currentTotal = currentTotal < 25.00 ? currentTotal + 3.00 : currentTotal;
        System.out.printf("After Small Order Surcharge: $%.2f\n", currentTotal);

        //SHIPPING COST CALCULATION (switch case)
        double shippingCost = 0.0;
        if (!freeShipping) {
            switch(shippingZone){
                case "ZoneA":
                    shippingCost = 5.0;
                    break;
                case "ZoneB":
                    shippingCost = 12.5;
                    break;
                case "ZoneC":
                    shippingCost = 20.0;
                    break;
                default:
                    shippingCost = 25.0;
                    break;
            }
        }
        System.out.printf("Shipping Cost: $%.2f", shippingCost);

        //TOTAL
        double finalOrderTotal = currentTotal + shippingCost;
        System.out.printf("\nFinal Order Total: $%.2f\n", finalOrderTotal);


        //Part 2: Interactive String Equality
        System.out.println("\n--- String Equality Demo ---");
        System.out.print("Enter first string for comparison: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string for comparison: ");
        String str2 = sc.nextLine();

        System.out.println("\nComparing \"" + str1 + "\" and \"" + str2 + "\"");

        //compare ==
        System.out.println("Using == : " + (str1 == str2));
        System.out.println("Explanation: '==' checks if the variables point to the exact same object in memory. For user input, this is almost always false.");

        // compare .equals()
        System.out.println("Using .equals() : " + str1.equals(str2));
        System.out.println("Explanation: '.equals()' checks if the actual content is identical. Note that this is case-sensitive.");

        // compare .equalsIgnoreCase()
        System.out.println("Using .equalsIgnoreCase() : " + str1.equalsIgnoreCase(str2));
        System.out.println("Explanation: '.equalsIgnoreCase()' checks the content, just like .equals(), but ignores differences in case");

        sc.close();

    }
}
