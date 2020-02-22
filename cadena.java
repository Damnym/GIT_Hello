/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * La Entrada:Consistirá en distintos casos de prueba, cada uno en una línea.
 * Cada línea no tendrá más de 10.000 caracteres. La Salida: Para cada caso de
 * prueba se indicará si la entrada está correctamente balanceada (se escribirá
 * un simple YES) o hay algún error (NO).
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tc;
        Stack stack = new Stack();
        String str = "YES";

        while (str != "NO") {
            tc = sc.nextLine();
            stack.clear();
            for (int i = 0; i < tc.length(); i++) {
                if (('{' == (tc.charAt(i))) | ('[' == (tc.charAt(i))) | ('(' == (tc.charAt(i)))) {
                    stack.push((char) tc.charAt(i));
                } else if (('}' == (tc.charAt(i))) | (']' == (tc.charAt(i))) | (')' == (tc.charAt(i)))) {
                    if (!stack.empty()) {
                        switch (tc.charAt(i)) {
                            case ')': {
                                if ((char) stack.pop() != '(') {
                                    str = "NO";
                                }
                                break;
                            }
                            case ']': {
                                char a = (char) stack.pop();
                                if (a != '[') {
                                    str = "NO";
                                }
                                break;
                            }
                            case '}': {
                                if ((char) stack.pop() != '{') {
                                    str = "NO";
                                }
                                break;
                            }
                        }
                    } else {
                        str = "NO";
                    }
                }
            }
            if (!stack.empty()) {
                str = "NO";
            }
            System.out.println(str);
        }
    }
}