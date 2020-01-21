/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.art.lach.mateusz.openchess.core.board;

import java.util.Objects;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class Field {
    
    public enum Number {
        _1, _2, _3, _4, _5, _6, _7, _8
    }
    
    public enum Letter {
        _A, _B, _C, _D, _E, _F, _G, _H
    }
    
    private final Letter letter;
    
    private final Number number;
    
    Field(Letter letter, Number number) {
        this.letter = letter;
        this.number = number;
    }
    
    public static Field getInstance(Letter letter, Number number) {
        return new Field(letter, number);
    }
    
    public Number getNumber() {
        return number;
    }

    public Letter getLetter() {
        return letter;
    }
    

    public static boolean isFieldNumberValid(int fieldNumber) {
        return fieldNumber >= Field.Number._1.ordinal()
                && fieldNumber <= Field.Number._8.ordinal();
    }
    
    public static boolean coordinatesAreValid(int fieldLetter, int fieldNumber) {
        return isFieldNumberValid(fieldLetter) && isFieldNumberValid(fieldNumber);
    }
    
    @Override
    public boolean equals(Object object) {
        if (null == object || object.getClass() != Field.class) {
            return false;
        }
        
        Field field = (Field) object;
        return Objects.equals(letter, field.letter)
                && Objects.equals(number, field.number);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(letter, number);
    }
    

}
