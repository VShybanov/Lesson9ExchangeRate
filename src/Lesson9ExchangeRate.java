//import java.util.Arrays;
import java.util.Random;

public class Lesson9ExchangeRate {
    final static double MIN_CURRENCY_RATE = 35.0;
    final static double MAX_CURRENCY_RATE = 40.0;
    final static int BEST_BANK_NUMBER = 3;
    final static String[] BANK_NAME = {"АТ КБ \"ПРИВАТБАНК\"", "АТ \"Ощадбанк\"", "АТ \"Укрексімбанк\"", "АБ \"УКРГАЗБАНК\"",
                                        "АТ \"Райффайзен Банк\"", "АТ \"УКРСИББАНК\"", "АT \"ПУМБ\"", "АТ \"КРЕДІ АГРІКОЛЬ БАНК\"",
                                        "АБ \"Південний\"", "ПАТ \"КРЕДОБАНК\"", "АТ \"Банк Кредит Дніпро\"", "АТ \"Універсал Банк\"",
                                        "АТ КБ \"ПРАВЕКС-БАНК\"", "АТ \"А - БАНК\""};

    private static void swapArrayItems(Bank[] array, int item1index, int item2index) {
        Bank tmp = array[item1index];
        array[item1index] = array[item2index];
        array[item2index] = tmp;
    }

    private static void customArraySort(Bank[] array) {
        // Човникове сортування
        Bank tmp;
        for (int i = 1; i < array.length; i++) {
            if (array[i].USDtoUAHrate > array[i-1].USDtoUAHrate) {
                swapArrayItems(array, i-1, i);
                for (int j = i-1; j-1 >= 0 ; j--) {
                    if (array[j].USDtoUAHrate > array[j-1].USDtoUAHrate) {
                        swapArrayItems(array, j-1, j);
                    } else
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        Bank[] bank = new Bank[BANK_NAME.length];

        System.out.println("Курси обміну в банках міста:");
        for (int i = 0; i < bank.length; i++) {
            bank[i] = new Bank(BANK_NAME[i], Math.random() * (MAX_CURRENCY_RATE - MIN_CURRENCY_RATE) + MIN_CURRENCY_RATE);
            System.out.println(bank[i]);
        }

        System.out.println();
        System.out.println(BEST_BANK_NUMBER + " банки з найкращім курсом обміну:");
        //Arrays.sort(bank);
        customArraySort(bank);
        for (int i = 0; i < BEST_BANK_NUMBER; i++) {
            System.out.println(bank[i]);
        }
    }
}
