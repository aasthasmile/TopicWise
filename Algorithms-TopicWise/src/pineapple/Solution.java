package pineapple;

import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//TODO: Strings geeksforgeeks(Must Do,Hard,Medium) .


public class Solution {

    public static final String ACCOUNT_HOLDER = "Account Holder:";
    public static final int accountHolderLength = ACCOUNT_HOLDER.length();
    public static final String ACCOUNT_DATA = "Account Data:";
    public static final int accountDataLength = ACCOUNT_DATA.length();
    public static final BigDecimal ONE_MILLION = new BigDecimal(1000000);

    public static void main(String[] args) throws Exception {

        SimulatedReader sm = new SimulatedReader();
        String s = "";
        Set<String> names = new HashSet<>();
        while ((s = sm.readLine()) != null) {
            //System.out.println(s);
            if (s.length() >= accountHolderLength && findAccountHolder(s) && findAccountData(sm.readLine())) {
                String text = sm.readLine();
                if (findValidText(text)) {
                    String data[] = text.split(",");
                    if (new BigDecimal(data[2]).compareTo(ONE_MILLION) == 1)
                        names.add(s.replaceAll(ACCOUNT_HOLDER, ""));
                }

            }
        }

        names.forEach(i -> System.out.println(i));
    }

    public static boolean findValidText(String str) {

        if (str.equals(ACCOUNT_HOLDER) || str.equals(ACCOUNT_DATA))
            return false;

        return (str.split(",").length == 5);
    }

    public static boolean findAccountData(String str) {
        return (str.equals(ACCOUNT_DATA));

    }

    public static boolean findAccountHolder(String str) {

        return (str.substring(0, accountHolderLength).equals(ACCOUNT_HOLDER) &&
                str.substring(accountHolderLength + 1, str.length()) != null && str.substring(15, str.length()) != ""
                && isValidAccountHolderName(str.substring(accountHolderLength + 1, str.length())));
        //&& str.substring(accountHolderLength+1,str.length()).chars().allMatch(Character::isDigit));

    }

    private static boolean isValidAccountHolderName(String str) {
        String[] data = str.split(" ");
        for (String s : data) {
            if (!s.chars().allMatch(Character::isLetter))
                return false;
        }
        return true;
    }


    public static class SimulatedReader extends BufferedReader {
        public SimulatedReader() {
            super(new StringReader(
                    "Foo\n" +
                            "Bar\n" +
                            "Bar\n" +
                            "Bar\n" +
                            "Account Holder: Steve Jobs\n" +
                            "Account Data:\n" +
                            "FooBarText,12/24/2016,1123456.00,xyz,4321\n" +
                            "\n" +
                            "ABC\n" +
                            "XYZ\n" +
                            "Account Holder: Some Guy\n" +
                            "Account Data:\n" +
                            "abc,12/24/2016,4321.00,xyz,4321\n" +
                            "foobarbaz\n" +
                            "Account Holder: Steve Jobs\n" +
                            "Account Data:\n" +
                            "abc,01/24/2017,1523456.00,xyz,4321\n" +
                            "Account Holder: Woz\n" +
                            "garbagefromdisk\n" +
                            "Account Data:\n" +
                            "abc,01/24/2017,1523456.00,xyz,4321\n" +
                            "Account Holder: Account Holder: Account Holder: Bill Gates\n" +
                            "Account Data:\n" +
                            "abc,01/24/2017,1523456.00,xyz,4321\n" +
                            "Account Holder: Bill Gates\n" +
                            "Account Data:\n" +
                            "Account Data:\n" +
                            "abc,01/24/2017,1523456.00,xyz,4321\n" +
                            ""
            ));
        }
    }
}
