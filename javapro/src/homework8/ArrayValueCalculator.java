package homework8;

import java.util.Random;

import static java.lang.Character.isDigit;

public class ArrayValueCalculator {

    public static void main(String[] args) {

        String[][] strings = new String[4][4];
        {
            strings[0][0] = "123";
            strings[0][1] = "22";
            strings[0][2] = "33";
            strings[0][3] = "44";
            strings[1][0] = "55";
            strings[1][1] = "-1";
            strings[1][2] = "00";
            strings[1][3] = "12";
            strings[2][0] = "12";
            strings[2][1] = "12";
            strings[2][2] = "12";
            strings[2][3] = "12";
            strings[3][0] = "12";
            strings[3][1] = "12";
            strings[3][2] = "12";
            strings[3][3] = "12";
        }
        try {
            System.out.println("Testing method doCalc with made by hands Array");
            System.out.println(doCalc(strings) + "\n");
            System.out.println("Testing method doCalc with Array made by another method");
            System.out.println(doCalc(fillArrayForCalc(4, 4)));
        } catch (ArraySizeException arraySizeException) {
            System.out.println("ArraySizeException()... You should check your Array size, it cannot be " +
                    "else then [4][4] !!!");
        } catch (ArrayDataException | NumberFormatException arrayDataException) {
            System.out.println("You should check your data !!!");
        }
    }

    //Main method for summation of two level Arrays
    static int doCalc(String[][] strings) throws ArraySizeException, ArrayDataException {
        int result = 0;
        if (strings.length != 4) {
            throw new ArraySizeException();
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != 4) {
                throw new ArraySizeException();
            }
            for (int j = 0; j < strings[i].length; j++) {
                if (strings[i][j] == null) {         //Check for null
                    System.out.println("ArrayDataException() at strings[" + i + "][" + j + "]");
                    throw new ArrayDataException();
                }
                for (char c : strings[i][j].toCharArray()) {
                    if (c == '-') {                  //Check char isNegative number
                        continue;
                    }
                    if (!isDigit(c)) {              //Check char isDigit
                        System.out.println("ArrayDataException() at strings[" + i + "][" + j + "]");
                        throw new ArrayDataException();
                    }
                }
                result += Integer.parseInt(strings[i][j]);
            }
        }
        return result;
    }

    //This method for correct fill of Array for method doCalc
    static String[][] fillArrayForCalc(int i, int j) {
        String[][] strings = new String[i][j];
        for (int a = 0; a < strings.length; a++) {
            for (int b = 0; b < strings[a].length; b++) {
                strings[a][b] = String.valueOf(new Random().nextInt(-100, 100));
            }
        }
        return strings;
    }
}
