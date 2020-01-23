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

import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import static pl.art.lach.mateusz.openchess.core.board.FieldFacade.FIELDS_LENGTH;

import java.util.Arrays;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class Board {
    
    private final Field[][] fields;
    
    Board(Field[][] fields) {
        this.fields = Arrays.copyOf(fields, fields.length);
    }
    
    public static Board getEmptyBoard() {
        Field[][] emptyFields = createEmptyFieldsArray();
        return new Board(emptyFields);
    }
    
    private static Field[][] createEmptyFieldsArray() {
        Field[][] emptyFields = new Field[FIELDS_LENGTH][FIELDS_LENGTH]; 
        FieldFacade fieldFacade = new FieldFacade();
        for (int i = 0; i < emptyFields.length; i++) {
            for (int j = 0; j < emptyFields[i].length; j++) {
                Letter letter = Letter.values()[i];
                Number number = Number.values()[j];
                emptyFields[i][j] = fieldFacade.getEmptyFieldInstance(letter, number);
            }
        }
        return emptyFields;
    }
    
    private static Board getConfiguredBoard(Field[][] fields) {
        return new Board(fields);
    }

    public Field getField(Letter letter, Number number) {
        return fields[letter.ordinal()][number.ordinal()];
    }
    

    public Board clearField(Letter letter, Number number) {
        return Board.Builder.ofExistingBoard(this)
                .clearField(letter, number)
                .build();
    }

    
    public static class Builder {
        
        private final Field[][] builderFields;
        
        private Builder(Board board) {
            this.builderFields = Arrays.copyOf(board.fields, board.fields.length);
        }
        
        private Builder() {
            this.builderFields = createEmptyFieldsArray();
        }
        
        public static Builder ofEmptyBoard() {
            return new Builder();
        }
        
        public static Builder ofExistingBoard(final Board board) {
            return new Builder(board);
        }
        
        public Builder setField(Field field) {
            int letterOrdinal = field.getLetter().ordinal();
            int numberOrdinal = field.getNumber().ordinal();
            builderFields[letterOrdinal][numberOrdinal] = field;
            return this;
        }
        
        public Builder clearField(Field field) {
            return clearField(field.getLetter(), field.getNumber());
        }
        
        public Builder clearField(Letter letter, Number number) {
            Field emptyField = Field.getEmptyField(letter, number);
            builderFields[letter.ordinal()][number.ordinal()] = emptyField;
            return this;
        }
        
        public Board build() {
            return Board.getConfiguredBoard(builderFields);
        }
        
    }


}
