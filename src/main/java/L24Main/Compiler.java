import java.io.*;

/**
 * Compiler 编译器主函数
 *
 * @author LuoTianYi
 * @version 2024/05/17 15:14
 **/
public class Compiler {
    public static BufferedReader stdin;

    static {
        try {
            stdin = new BufferedReader(new InputStreamReader(System.in,"GBK"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileName;
        String in;
        String filePath;
        //判断文件是否存在
        String userPath = System.getProperty("user.dir");

        try{
            System.out.println("请输入l24文件：");
            fileName = stdin.readLine();
            filePath = userPath + "/" + fileName;
            System.out.println("是否输出中间代码？(Y/N)");
            in = stdin.readLine();
            if(fileName.endsWith(".l24")){
                InputStream inputStream = new FileInputStream(filePath);
                L24 parser = new L24(inputStream);
                parser.Program();
                if(in.equals("Y")||in.equals("y")){
                    L24.outPutMiddleCodeList();
                }

                Interpreter interpreter =new Interpreter();
                interpreter.execute(L24.midCodeList);
            }

        }
        catch (Exception e){
            ErrorExecute.showErrMsg(7,e.toString());
        }

    }
}

