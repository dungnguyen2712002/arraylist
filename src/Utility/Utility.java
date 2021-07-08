/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Utility {
    public String getString(Scanner sc, String msg, boolean isEmpty, String pattern) {
        String line;
        
        do {
            System.out.print(msg);
            line = sc.nextLine().trim();
            if (line.isEmpty() && !isEmpty) continue;
            else {
                if (pattern.isEmpty()) break;
                else if (line.matches(pattern)) {
                    if (pattern == "[01]") {
                        if (line.equals("1")) line = "true";
                        else line = "false";
                        break;
                    }
                    else break;
                }
                else continue;
            }
        } while (true);
        return line;
    }

    public int getInt(Scanner sc, String msg, int min, int max) {
        String line;
        int result;
        
        do {
            System.out.print(msg);
            line = sc.nextLine();
            try {
                result = Integer.parseInt(line);
                if (result >= min && result <= max) break;
                else continue;
            }
            catch (Exception ex) {
                continue;
            }
        } while (true);
        return result;
    }
}
