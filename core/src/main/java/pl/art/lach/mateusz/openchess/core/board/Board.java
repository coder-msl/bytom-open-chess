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

import java.util.Arrays;

import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class Board {
    
    private final Field[][] fields;
    
    Board(Field[][] fields) {
        this.fields = new FieldFacade().getEmptyFields();
    }
    
    public static Board getEmptyBoard() {
        Field[][] fields = new FieldFacade().getEmptyFields();
        return new Board(fields);
    }
    
    public static Board getBoard(Field[][] fields) {
        return new Board(fields);
    }
    
    public Field[][] getFields() {
        return Arrays.copyOf(fields, fields.length);
    }

    public Field getField(Letter letter, Number number) {
        return fields[letter.ordinal()][number.ordinal()];
    }

    
    public static class Builder {
        
        private final Field[][] builderFields;
        
        public Builder(Board board) {
            this.builderFields = board.getFields();
        }
        
        public Builder setField(Field field) {
            int letterOrdinal = field.getLetter().ordinal();
            int numberOrdinal = field.getNumber().ordinal();
            builderFields[letterOrdinal][numberOrdinal] = field;
            return this;
        }
        
        public Board build() {
            return Board.getBoard(builderFields);
        }
        
    }

}
