/**
 * MiddleCode 中间代码
 *
 * @author LuoTianYi
 * @version 2024/05/16 11:40
 **/
public class MiddleCode {
    public enum CodeType{
        LIT, OPR, LOD, STO, INT, JMP, JPC
    }
    public CodeType codeType;
    public int l;
    public int a;

    public MiddleCode(CodeType codeType, int l, int a) {
        this.codeType = codeType;
        this.l = l;
        this.a = a;
    }

    @Override
    public String toString() {
        return codeType.toString()+"\t"+l+"\t"+a;
    }
}