package pl.art.lach.mateusz.openchess.core.board;

public class Field {
    
    public enum Number {
        _1, _2, _3, _4, _5, _6, _7, _8
    }
    
    public enum Letter {
        _A, _B, _C, _D, _E, _F, _G, _H
    }
    
    private final Letter letter;
    
    private final Number number;
    
    private Field(Letter letter, Number number) {
        this.letter = letter;
        this.number = number;
    }
    
    public static Field getInstance(Letter letter, Number number) {
        return new Field(letter, number);
    }
    
    public Number getNumber() {
        return number;
    }
    

}
