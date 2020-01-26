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

import java.util.Set;

import static pl.art.lach.mateusz.openchess.core.board.Field.coordinatesAreValid;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
abstract class LongRangeStrategy implements PieceMoveStrategy {

    protected enum Direction {

        TOP_LEFT(-1, -1), 
        TOP_RIGHT(1, -1), 
        BOTTOM_LEFT(-1, 1), 
        BOTTOM_RIGHT(1, 1),

        TOP(0, -1), 
        BOTTOM(0, 1), 
        RIGHT(1, 0),
        LEFT(-1, 0);

        Direction(final int letterDirection, final int numberDirection) {
            this.letterDirection = letterDirection;
            this.numberDirection = numberDirection;
        }

        private int letterDirection;

        private int numberDirection;

        int getLetterDirection() {
            return letterDirection;
        }

        int getNumberDirection() {
            return numberDirection;
        }
    }

    protected void addFieldsInDirection(Board board, Set<Field> fields, 
            Field currentField, Color color, Direction direction) {
        int fieldLetter = currentField.getLetter().ordinal() + direction.getLetterDirection();
        int fieldNumber = currentField.getNumber().ordinal() + direction.getNumberDirection();
        while (coordinatesAreValid(fieldLetter, fieldNumber)) {
            Letter letter = Field.Letter.values()[fieldLetter];
            Number number = Field.Number.values()[fieldNumber];

            Field field = Field.getEmptyField(letter, number);
            if (board.fieldCanBeTaken(field, color)) {
                fields.add(field);
                fieldLetter += direction.getLetterDirection();
                fieldNumber += direction.getNumberDirection();
            } else {
                return;
            }
            
        }
    }


}
