import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Interpreter 解释程序
 *
 * @author LuoTianYi
 * @version 2024/05/16 12:56
 **/
public class Interpreter {

    private int baseAddress = 0;//当前层数基地址
    private int programCounter = 0;//当前执行指令标号

    private MiddleCode instruct;//当前执行指令
    private Stack<Integer> dataMemory = new Stack<>();//数据栈
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/ReadWrite.l24");

            L24 parser = new L24(inputStream);
            parser.Program();
            Interpreter interpreter =new Interpreter();
            interpreter.execute(L24.midCodeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(ArrayList<MiddleCode> middleCodes) {
        while (programCounter < middleCodes.size()) {
            instruct = middleCodes.get(programCounter);
            switch (instruct.codeType) {
                case LIT -> dataMemory.push(instruct.a);
                case OPR -> {
                    try {
                        switch (instruct.a) {
                            case 2 -> dataMemory.push(Math.addExact(dataMemory.pop(), dataMemory.pop()));
                            case 3 -> dataMemory.push(Math.addExact(-dataMemory.pop() , dataMemory.pop()));
                            case 4 -> dataMemory.push(Math.multiplyExact(dataMemory.pop() , dataMemory.pop()));
                            case 5 -> {
                                int b = dataMemory.pop();
                                int a = dataMemory.pop();
                                dataMemory.push(Math.divideExact(a, b));
                            }
                            case 8 -> dataMemory.push(dataMemory.pop() == dataMemory.pop() ? 1 : 0);
                            case 9 -> dataMemory.push(dataMemory.pop() != dataMemory.pop() ? 1 : 0);
                            case 10 -> dataMemory.push(dataMemory.pop() > dataMemory.pop() ? 1 : 0);
                            case 11 -> dataMemory.push(dataMemory.pop() <= dataMemory.pop() ? 1 : 0);
                            case 12 -> dataMemory.push(dataMemory.pop() < dataMemory.pop() ? 1 : 0);
                            case 13 -> dataMemory.push(dataMemory.pop() >= dataMemory.pop() ? 1 : 0);
                            case 14 -> {
                                System.out.println(dataMemory.pop());
                            }
                            case 16 -> {
                                dataMemory.push(scanner.nextInt());
                            }
                        }
                    } catch (ArithmeticException e) {
                        ErrorExecute.showErrMsg(4, e.toString());
                        //算数异常
                    }
                }
                case INT -> {
                    for (int i = 0; i < instruct.a; i++) {
                        dataMemory.push(0);
                    }
                }
                case JPC -> {
                    if (dataMemory.pop() == 0) {
                        programCounter = instruct.a;
                        continue;
                    }
                }
                case JMP -> {
                    programCounter = instruct.a;
                    continue;

                }
                case LOD -> {
                    dataMemory.push(dataMemory.get(instruct.a + baseAddress));
                }
                case STO -> {
                    dataMemory.set(instruct.a + baseAddress, dataMemory.pop());
                }
            }
            programCounter++;
        }
    }
}

