/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ProblemHelper;

import java.util.Scanner;

public class App {
    private static boolean terminate;

    public static void main(String[] args) throws Exception {
        terminate = false;
        while (!terminate) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a command: ");
            String str = sc.nextLine(); // reads string
            Thread execution = (new Thread() {

                @Override
                public void run() {
                    String[] commands = str.split(" ");
                    if (commands.length > 0) {
                        final String command = commands[0];
                        if (command.equals("build")) {
                            System.out.println("Executing build");
                            try {
                                // Print the hand
                                System.out.println("; Hand \n (hand hand)\n (sturdy hand)\n");
                                System.out.println(new Fridge(commands).toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Done");
                        } else if (command.equals("close")) {
                            terminate = true;
                            System.out.println("Bye bye");

                            // Print Item Configuration
                        } else if (command.equals("item")) {
                            String toPrint = "Not found\n";
                            Item itemOfThis = null;

                            try {
                                switch (Item.valueOf(commands[1])) {
                                case ONE_ONE_ONE:
                                    itemOfThis = Item.ONE_ONE_ONE;
                                    break;
                                case ONE_ONE_THREE:
                                    itemOfThis = Item.ONE_ONE_THREE;
                                    break;
                                case ONE_ONE_TWO:
                                    itemOfThis = Item.ONE_ONE_TWO;
                                    break;
                                case ONE_TWO_THREE:
                                    toPrint = Item.ONE_TWO_THREE.toString();
                                    itemOfThis = Item.ONE_TWO_THREE;
                                    break;
                                case ONE_TWO_TWO:
                                    itemOfThis = Item.ONE_TWO_TWO;
                                    break;
                                case TWO_TWO_TWO:
                                    itemOfThis = Item.TWO_TWO_TWO;
                                    break;
                                default:
                                    break;
                                }
                            } catch (Exception e) {

                            }

                            if (itemOfThis != null) {
                                toPrint = itemOfThis.toString();
                            }
                            System.out.println(toPrint);
                            if (commands.length > 2)
                                System.out.println(Item.assignOrientation(itemOfThis, Integer.valueOf(commands[2])));

                        } else if (command.equals("init")) {
                            System.out.println("(define (problem another_problem)\n(:domain example)\n;(:situation <situation_name>) ;deprecated\n(:objects\n\n)\n(:init\n\n)\n(:goal\n(and\n\n)\n)\n)\n\n");
                        }else {
                            System.out.println("Invalid command");
                        }
                    }
                }

            });
            execution.start();
            execution.join();
        }
    }
}
