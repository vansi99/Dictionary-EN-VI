package com.dict;

import Model.DbWords;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập phím 1: TRA TỪ" + "\nNhập phím 2: THÊM TỪ" + "\nNhập phím 3: XÓA TỪ");
        while(true) {
            Scanner scannerNumber = new Scanner(System.in);
            int number = scannerNumber.nextInt();
            if (number == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập từ cần tra: ");
                String word = scanner.nextLine().toLowerCase();
                DbWords words = new DbWords(word);
                try {
                    ResultSet rs = words.getDetail();
                    if (rs.next()) {
                        System.out.println("\nNghĩa của từ là: " + rs.getString("detail"));
                    }
                    else System.out.println("\nTừ điển hiện không có từ này!!!");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(number == 2){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập từ muốn thêm: ");
                String word = scanner.nextLine().toLowerCase();
                System.out.print("Nhập nghĩa của từ muốn thêm: ");
                String detail = scanner.nextLine().toLowerCase();
                DbWords postWord = new DbWords();
                postWord.postWord(word, detail);
            }
        }
    }
}
