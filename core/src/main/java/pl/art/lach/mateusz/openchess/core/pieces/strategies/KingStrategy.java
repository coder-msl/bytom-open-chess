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
package pl.art.lach.mateusz.openchess.core.pieces.strategies;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;

import static pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy.addIfFieldCanBeTaken;
/**
 * @author: Mateusz Sławomir Lach 
 */
class KingStrategy implements PieceMoveStrategy {

    private static final int CASTLING_SHIFT = 2;

    @Override
    public Set<Field> getAllFieldsInRange(Board board, Field currentField, Color color) {
        final Set<Field> fields = new HashSet<>();
        final int letter = currentField.getLetter().ordinal();
        final int number = currentField.getNumber().ordinal();
        
        addIfFieldCanBeTaken(board, fields, letter - 1, number - 1, color);
        addIfFieldCanBeTaken(board, fields, letter + 0, number - 1, color);
        addIfFieldCanBeTaken(board, fields, letter - 1, number + 0, color);
        addIfFieldCanBeTaken(board, fields, letter + 1, number + 0, color);
        addIfFieldCanBeTaken(board, fields, letter + 0, number + 1, color);
        addIfFieldCanBeTaken(board, fields, letter + 1, number + 1, color);
        addIfFieldCanBeTaken(board, fields, letter + 1, number - 1, color);
        addIfFieldCanBeTaken(board, fields, letter - 1, number + 1, color);
        
        addLeftCastlingIfPossible(board, fields, currentField, color);
        addRightCastlingIfPossible(board, fields, currentField, color);
        
        return Collections.unmodifiableSet(fields);
    }

    private void addRightCastlingIfPossible(Board board, Set<Field> fields, Field currentField, Color color) {
        int letterOrdinal = currentField.getLetter().ordinal();
        if (board.isRightCastlingPossible(color)) {
            Letter letter = Field.Letter.values()[letterOrdinal + CASTLING_SHIFT];
            Field castlingField = Field.getEmptyField(letter, currentField.getNumber());
            fields.add(castlingField);
        }
    }

    private void addLeftCastlingIfPossible(Board board, Set<Field> fields, Field currentField, Color color) {
        int letterOrdinal = currentField.getLetter().ordinal();
        if (board.isLeftCastlingPossible(color)) {
            Letter letter = Field.Letter.values()[letterOrdinal - CASTLING_SHIFT];
            Field castlingField = Field.getEmptyField(letter, currentField.getNumber());
            fields.add(castlingField);
        }
    }



}
