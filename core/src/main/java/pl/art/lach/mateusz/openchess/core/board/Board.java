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

import static pl.art.lach.mateusz.openchess.core.Color.WHITE;

import java.util.Arrays;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import pl.art.lach.mateusz.openchess.core.pieces.Piece;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class Board {
    
    private final Field[][] fields;
    
    private final CastlingState whiteCastlingState; 
    
    private final CastlingState blackCastlingState;
    
    Board(final Field[][] fields) {
        this.fields = deepCloneFields(fields);
        this.blackCastlingState = CastlingState.getInitialState();
        this.whiteCastlingState = CastlingState.getInitialState();
    }
    
    Board(final Field[][] fields, final CastlingState whiteState, CastlingState blackState) {
        this.fields = deepCloneFields(fields);
        this.blackCastlingState = blackState;
        this.whiteCastlingState = whiteState;
    }
    
    public static Board getEmptyBoard() {
        Field[][] emptyFields = new FieldFacade().getEmptyFields();
        return new Board(emptyFields);
    }

    private static Board getConfiguredBoard(final Field[][] fields, 
            CastlingState whiteCastlingState, CastlingState blackCastlingState) {
        return new Board(fields, whiteCastlingState, blackCastlingState);
    }

    public Field getField(final Letter letter, final Number number) {
        return fields[letter.ordinal()][number.ordinal()];
    }
    
    public Board setField(final Field field) {
        return Board.Builder.ofExistingBoard(this)
                .setField(field)
                .build();
    }
    
    public Board clearField(final Field field) {
        return clearField(field.getLetter(), field.getNumber());
    }

    public Board clearField(final Letter letter, final Number number) {
        return Board.Builder.ofExistingBoard(this)
                .clearField(letter, number)
                .build();
    }
    
    private static Field[][] deepCloneFields(final Field[][] fields) {
        Field[][] copy = Arrays.copyOf(fields, fields.length);
        for (int i = 0; i < copy.length; i++) {
            copy[i] = fields[i].clone();
        }
        return copy;
    }

    public boolean isFieldEmpty(Field field) {
        return getField(field.getLetter(), field.getNumber()).isEmpty();
    }

    public boolean fieldCanBeTaken(Field field, Color color) {
        Piece piece = getField(field.getLetter(), field.getNumber()).getPiece();
        return isFieldEmpty(field) 
                || (piece.getColor() != color && piece.isTakeablePiece());
    }
    
    public static class Builder {
        
        private Field[][] builderFields;
        
        private CastlingState whiteCastlingState;
        
        private CastlingState blackCastlingState;
        
        private Builder(final Board board) {
            this.builderFields = deepCloneFields(board.fields);
            this.whiteCastlingState = board.whiteCastlingState;
            this.blackCastlingState = board.blackCastlingState;
        }
        
        private Builder() {
            this.builderFields = new FieldFacade().getEmptyFields();
            this.whiteCastlingState = CastlingState.getInitialState();
            this.blackCastlingState = CastlingState.getInitialState();
        }
        
        public static Builder ofEmptyBoard() {
            return new Builder();
        }
        
        public static Builder ofExistingBoard(final Board board) {
            return new Builder(board);
        }
        
        public Builder setField(final Field field) {
            int letterOrdinal = field.getLetter().ordinal();
            int numberOrdinal = field.getNumber().ordinal();
            builderFields[letterOrdinal][numberOrdinal] = field;
            return this;
        }
        
        public Builder setWhiteCastlingState(CastlingState castlingState) {
            this.whiteCastlingState = castlingState;
            return this;
        }
        
        public Builder setBlackCastlingState(CastlingState castlingState) {
            this.blackCastlingState = castlingState;
            return this;
        }
        
        public Builder clearField(final Field field) {
            return clearField(field.getLetter(), field.getNumber());
        }
        
        public Builder clearField(final Letter letter, final Number number) {
            Field emptyField = Field.getEmptyField(letter, number);
            builderFields[letter.ordinal()][number.ordinal()] = emptyField;
            return this;
        }
        
        public Board build() {
            return getConfiguredBoard(builderFields, whiteCastlingState, blackCastlingState);
        }
        
    }

    public boolean isRightCastlingPossible(final Color color) {
        return color == WHITE ? 
                whiteCastlingState.isRightCastlingPossible(this, color)
                : blackCastlingState.isRightCastlingPossible(this, color);
    }

    public boolean isLeftCastlingPossible(final Color color) {
        return color == WHITE ?
                whiteCastlingState.isLeftCastlingPossible(this, color)
                : blackCastlingState.isLeftCastlingPossible(this, color);
    }

}
