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

import pl.art.lach.mateusz.openchess.core.pieces.Piece;

/**
 * @author: Mateusz Sławomir Lach 
 */
public abstract class Field {
    
    
    public enum Number {
        _1, _2, _3, _4, _5, _6, _7, _8
    }
    
    public enum Letter {
        _A, _B, _C, _D, _E, _F, _G, _H
    }
    
    private final Letter letter;
    
    private final Number number;
    
    Field(final Letter letter, final Number number) {
        this.letter = letter;
        this.number = number;
    }
    
    abstract boolean isFree();
    
    abstract Piece getPiece();
    
    public static Field getFreeField(final Letter letter, final Number number) {
        return new Field.EmptyField(letter, number);
    }
    
    public static Field getOccupiedField(final Letter letter, final Number number, 
            final Piece piece) {
        return new Field.OccupiedField(letter, number, piece);
    }
    
    public static Field getField(final Letter letter, final Number number, final Piece piece) {
        if (null == piece) {
            return getFreeField(letter, number);
        }
        return getOccupiedField(letter, number, piece);
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
        return isFieldNumberValid(fieldLetter) 
                && isFieldNumberValid(fieldNumber);
    }
    
    @Override
    public boolean equals(Object object) {
        if (null == object || !(object instanceof Field)) {
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
    
    
    static class EmptyField extends Field {

        EmptyField(Letter letter, Number number) {
            super(letter, number);
        }

        @Override
        boolean isFree() {
            return true;
        }

        @Override
        Piece getPiece() {
            return null;
        }
        
    }
    
    static class OccupiedField extends Field {
        
        private final Piece piece;

        OccupiedField(Letter letter, Number number, Piece piece) {
            super(letter, number);
            this.piece = piece;
        }

        @Override
        boolean isFree() {
            return false;
        }

        @Override
        Piece getPiece() {
            return piece;
        }
        
    }

}
