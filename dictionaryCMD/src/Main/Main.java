package com.dict;

import Model.DbWords;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Nhập phím 1: Tra từ" + "\nNhập phím 2: Thêm từ");
            Scanner scanner1 = new Scanner(System.in);
            int number = scanner1.nextInt();
            if (number == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập từ cần tra: ");
                String word = scanner.nextLine().toLowerCase();
                DbWords words = new DbWords(word);
                try {
                    ResultSet rs = words.getDetail();
                    if (rs.next()) {
                        System.out.println("\nNghĩa của từ là: " + rs.getString("detail"));
                    } else System.out.println("\nTừ điển hiện không có từ này!!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
