/**
 * Symbol 符号表
 *
 * @author LuoTianYi
 * @version 2024/05/16 11:39
 **/
enum SymbolType {
    intSym,
    //funcSym
}

public class Symbol {
    public Symbol(SymbolType type) {
        this.type = type;
    }

    private String name = "";
    private SymbolType type;
    private int value = 0;
    private int level = 0;
    private int adr = 0;
    private int size = 0;
    //private int returnType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SymbolType getType() {
        return type;
    }

    public void setType(SymbolType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAdr() {
        return adr;
    }

    public void setAdr(int adr) {
        this.adr = adr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", level=" + level +
                ", adr=" + adr +
                ", size=" + size +
                '}';
    }
}
