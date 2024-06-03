/**
 * ErrorExecute 错误计数和错误码
 *
 * @author LuoTianYi
 * @version 2024/05/16 23:05
 **/
public class ErrorExecute {
    enum ErrCode{

    }
    public static int errCount = 0;
    public static void showErrMsg(int errCode,String msg){
        System.err.println("Error code: " + errCode+" "+msg);
    }
}
    