package turingmachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TuringMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of state:");
        try {
            int state = sc.nextInt();
            if (state >= 1) {
                System.out.print("Enter number of string alphabet:");
                try {
                    int alpha = sc.nextInt();
                    if (alpha >= 1) {
                        //alphabets using in the machine
                        char[] A = new char[alpha];
                        for (int i = 0; i <= alpha - 1; i++) {
                            if (i == 0) {
                                System.out.print("Enter " + 1 + "st element: ");
                                A[0] = sc.next().charAt(0);
                            }
                            if (i == 1) {
                                System.out.print("Enter " + 2 + "nd element: ");
                                A[1] = sc.next().charAt(0);
                            }
                            if (i == 2) {
                                System.out.print("Enter " + 3 + "rd element: ");
                                A[2] = sc.next().charAt(0);
                            } else if (i > 2) {
                                System.out.print("Enter " + (i + 1) + "th element: ");
                                A[i] = sc.next().charAt(0);
                            }

                        }

                        //machine alphabets using in the
                        System.out.print("Enter number of machine alphabet: ");
                        try {
                            int mAlpha = sc.nextInt();
                            if (mAlpha >= 0) {
                                char[] M = new char[mAlpha];
                                for (int i = 0; i <= mAlpha - 1; i++) {
                                    if (i == 0) {
                                        System.out.print("Enter " + 1 + "st element: ");
                                        M[0] = sc.next().charAt(0);
                                    }
                                    if (i == 1) {
                                        System.out.print("Enter " + 2 + "nd element: ");
                                        M[1] = sc.next().charAt(0);
                                    }
                                    if (i == 2) {
                                        System.out.print("Enter " + 3 + "rd element: ");
                                        M[2] = sc.next().charAt(0);
                                    } else if (i > 2) {
                                        System.out.print("Enter " + (i + 1) + "th element: ");
                                        M[i] = sc.next().charAt(0);
                                    }

                                }
                                char[] N = new char[alpha + mAlpha];
                                System.arraycopy(A, 0, N, 0, alpha);
                                for (int k = alpha; k < N.length; k++) {
                                    N[k] = M[k - alpha];
                                }
                                //transition 2D array
                                int r = state * (alpha + mAlpha);
                                // int c=sc.nextInt();
                                char[][] transe = new char[r][5];
                                System.out.print("Enter your Transition:  ");
                                for (char[] transe1 : transe) {
                                    String s = sc.next();
                                    for (int j = 0; j < transe[0].length; j++) {
                                        transe1[0] = s.charAt(0);
                                        int n = 0;
                                        while (n != N.length) {
                                            if (s.charAt(1) != N[n]) {
                                                n++;
                                            } else {
                                                transe1[1] = s.charAt(1);
                                                break;
                                            }
                                        }
                                        if (n == N.length && transe1[1] == '0') {
                                            System.out.println("Entered an Alphabet or Input Machine not defined .");
                                            System.exit(1);
                                        }
                                        transe1[2] = s.charAt(2);
                                        int e = 0;
                                        while (e != N.length) {
                                            if (s.charAt(3) != N[e]) {
                                                e++;
                                            } else {
                                                transe1[3] = s.charAt(3);
                                                break;
                                            }
                                        }
                                        if (e == N.length && transe1[3] == '0') {
                                            System.out.println("Entered an Alphabet or Input Machine not defined .");
                                            System.exit(1);
                                        }
                                        if (s.charAt(4) == 'R' || s.charAt(4) == 'L' || s.charAt(4) == 'Y' || s.charAt(4) == 'N') {
                                            transe1[4] = s.charAt(4);
                                        } else {
                                            System.out.println("Entered The Action Wrong.");
                                            System.exit(1);
                                        }
                                    }
                                }

                                System.out.print("your Transition is:  ");
                                System.out.print("[");
                                for (char[] transe1 : transe) {
                                    System.out.print("[");
                                    for (int j = 0; j < transe[0].length; j++) {
                                        System.out.print(transe1[j] + ",");
                                    }
                                    System.out.print("]");
                                }
                                System.out.print("]");
                                System.out.println("");

                                //the string in the 1D array to trace it
                                System.out.print("Enter your string :  ");
                                String str = sc.next();
                                char[] st = new char[60];
                                for (int j = str.length(); j < 60; j++) {
                                    for (int i = 0; i < str.length(); i++) {
                                        int v = 0;
                                        while (v != N.length) {
                                            if (str.charAt(i) != N[v]) {
                                                v++;
                                            } else {
                                                st[i] = str.charAt(i);
                                                break;
                                            }
                                            if (v == N.length && st[i] != str.charAt(i)) {
                                                System.err.println("You Entered " + str.charAt(i) + " out of Alphabet .");
                                                System.exit(1);
                                            }
                                        }
                                    }
                                    st[j] += '#';
                                }

                                //user chose the position
                                System.out.print("Enter intial position of the head :  ");
                                int head = sc.nextInt();
                                if (head < 0) {
                                    System.err.println("Entered Number (" + head + ") < 0 . \nEnter Initial position Again :");
                                    head = sc.nextInt();
                                    if (head < 0) {
                                        System.err.println("You Entered Again Number " + head + " less Than Zero .");
                                        System.exit(1);
                                    }
                                }
                                //cheching if the string is accepted or not and make some change if it happend in the string 
                                char x = '0';
                                boolean flag = false;
                                while (!flag) {
                                    for (char[] transe1 : transe) {
                                        OUTER:
                                        for (int j = 0; j < transe[0].length; j++) {
                                            if (transe1[0] == (x) && transe1[1] == st[head]) {
                                                x = transe1[2];
                                                st[head] = transe1[3];
                                                switch (transe1[4]) {
                                                    case 'R' ->
                                                        head++;
                                                    case 'L' ->
                                                        head--;
                                                    case 'Y' -> {
                                                        System.out.println("your string is accepted");
                                                        flag = true;
                                                        break OUTER;
                                                    }
                                                    case 'N' -> {
                                                        System.out.println("your string is rejected");
                                                        flag = true;
                                                        break OUTER;
                                                    }
                                                    default ->
                                                        System.err.print("something is wrong");
                                                }
                                            }
                                        }
                                        if (flag == true) {
                                            break;
                                        }
                                    }
                                }

                                //now the final string if it changed
                                System.out.print("the final string is: ");
                                for (int i = 0; i < st.length; i++) {

                                    System.out.print(st[i]);
                                }
                                System.out.println(" ");
                                //and last thing is the place of the head at now
                                System.out.println("the location of the head is " + head);
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("You Don't Enter a number .");
                            System.exit(1);

                        }
                    } else if (alpha <= 0) {
                        System.err.println(alpha + "<= 0 .");
                        System.exit(1);
                    }
                } catch (InputMismatchException e) {
                    System.err.println("You Don't Enter a number .");
                    System.exit(1);
                }
            } else if (state <= 0) {
                System.err.println(state + "<= 0 .");
                System.exit(1);
            }
        } catch (InputMismatchException e) {
            System.err.println("You Don't Enter a number .");
            System.exit(1);

        }

    }

}
