

class RomanArabic {
    private static String[] romanNums = {
            "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
    };

    // corresponding arabic numbers
    private static int[] arabicNums = {
            1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
    };

    // length of both arrays
    private static int numbersCount = 12;

    static int romanToArabic(String roman) throws RomanArabicException{
        int result = 0; // initialize the result
        String romanCopy = roman; // copy roman for test

        for (int i=numbersCount; i>=0;) {
            if (roman.startsWith(romanNums[i])) {
                result += arabicNums[i];
                roman = roman.substring(romanNums[i].length());
            }
            else {
                i--;
            }
        }

        // check if converted number was of correct format
        try {
            if (!roman.isEmpty() || !romanCopy.equals(arabicToRoman(result))) {
                throw new RomanArabicException("incorrect number format");
            }
        }
        catch (RomanArabicException e) {
            throw new RomanArabicException("incorrect number format");
        }

        return result;
    }

    static String arabicToRoman(int arabic) throws RomanArabicException{
        // throw exception if number out of range
        if (arabic > 3999 || arabic <= 0) {
            throw new RomanArabicException("number cannot be represented in roman system");
        }

        // initialize empty result string
        String result = "";

        for (int i=numbersCount; i>=0;) {
            if (arabic >= arabicNums[i]) {
                result += romanNums[i];
                arabic -= arabicNums[i];
            }
            else {
                i--;
            }
        }
        return result;
    }
}