package sm.view;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' &&
                    c != '5' && c != '6' && c != '7' && c != '8'
            ) {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString() {
        String s;
        for (; ; ) {
            try {
                s = readKeyBoard(20, false);
                break;
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入：");
            }
        }
        return s;
    }


    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入Y/N：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

    public static Date readDate() {
        Scanner scan = new Scanner(System.in);  // 从键盘接收数据
        String str = null;
        Date date = null;
        System.out.print("（yyyy-MM-dd）：");
        if (scan.hasNext()) {  // 判断
            str = scan.next();  // 接收
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("输入的日期格式错误！");
        }
        return date;
    }


}