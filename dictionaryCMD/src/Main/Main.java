package com.dict;

import Model.DbWords;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập từ cần tra: ");
        String word = scanner.nextLine().toLowerCase();
        DbWords words = new DbWords(word);
        try {
            ResultSet rs = words.getDetail();
            if(rs.next()) {
                System.out.println("\nNghia của từ là: " + rs.getString("detail"));
            } else System.out.println("\n:v Từ điển hiện không có từ này!!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
