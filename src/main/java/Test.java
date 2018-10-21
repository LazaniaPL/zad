public class Test {
    public static void main (String[] args) {
        int n = 0; // variable for parsing inputs

        for (String arg : args) {
            try {
                n = Integer.parseInt(arg);
                System.out.println(RomanArabic.arabicToRoman(n));
            }
            catch (NumberFormatException e) {
                try {
                    System.out.println(RomanArabic.romanToArabic(arg));
                }
                catch (RomanArabicException ex) {
                    System.out.println(ex);
                }
            }
            catch (RomanArabicException e) {
                System.out.println(e);
            }
        }
    }
}