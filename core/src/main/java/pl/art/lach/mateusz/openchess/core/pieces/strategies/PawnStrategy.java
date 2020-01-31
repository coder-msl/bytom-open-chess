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
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import static pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy.addIfFieldCanBeTaken;

/**
 * @author: Mateusz Sławomir Lach 
 */
class PawnStrategy implements PieceMoveStrategy {

    @Override
    public Set<Field> getAllFieldsInRange(Board board, Field currentField, Color color) {
        final Set<Field> fields = new HashSet<>();
        final int numberDirection = getNumberDirectionBasingOnColor(color);
        
        final int letter = currentField.getLetter().ordinal();
        final int number = currentField.getNumber().ordinal();
        addIfFieldCanBeTaken(board, fields, letter, number + numberDirection, color);
        addIfFieldCanBeTaken(board, fields, letter - 1, number + numberDirection, color);
        addIfFieldCanBeTaken(board, fields, letter + 1, number + numberDirection, color);
        
        if (isOnStartPosition(currentField, color)) {
            final int startMoveNumber = number + (numberDirection * 2);
            addIfFieldCanBeTaken(board, fields, letter, startMoveNumber, color);
        }
        
        return Collections.unmodifiableSet(fields);
    }

    private int getNumberDirectionBasingOnColor(Color color) {
        int numberDirection = 1;
        if (Color.BLACK == color) {
            numberDirection = -numberDirection;
        }
        return numberDirection;
    }
    
   
    private boolean isOnStartPosition(Field currentField, Color color) {
        return (Color.WHITE == color && currentField.getNumber() == Number._2)
                || (Color.BLACK == color && currentField.getNumber() == Number._7);
    }

}
