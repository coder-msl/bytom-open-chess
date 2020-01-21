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

import java.util.HashSet;
import java.util.Set;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PawnStrategy implements PieceStrategy {

    @Override
    public Set<Field> getAllFieldsInRange(Field currentField, Color color) {
        final Set<Field> fields = new HashSet<>();
        final int numberDirection = getNumberDirectionBasingOnColor(color);
        
        final int letter = currentField.getLetter().ordinal();
        final int number = currentField.getNumber().ordinal();
        addIfCoordinatesAreValid(fields, letter, number + numberDirection);
        addIfCoordinatesAreValid(fields, letter - 1, number + numberDirection);
        addIfCoordinatesAreValid(fields, letter + 1, number + numberDirection);
        
        if (isOnStartPosition(currentField, color)) {
            addIfCoordinatesAreValid(fields, letter, number + (numberDirection * 2));
        }
        
        return fields;
    }

    private int getNumberDirectionBasingOnColor(Color color) {
        int numberDirection = 1;
        if (Color.BLACK == color) {
            numberDirection = -numberDirection;
        }
        return numberDirection;
    }
    
    private void addIfCoordinatesAreValid(Set<Field> fields, int letterOrdinal, int numberOrdinal) {
        if (Field.isFieldNumberValid(letterOrdinal) && Field.isFieldNumberValid(numberOrdinal)) {
            Field.Letter letter = Field.Letter.values()[letterOrdinal];
            Field.Number number = Field.Number.values()[numberOrdinal];
            Field fieldInRange = Field.getInstance(letter, number);
            fields.add(fieldInRange);
        }
    }
    
    private boolean isOnStartPosition(Field currentField, Color color) {
        return (Color.WHITE == color && currentField.getNumber() == Number._2)
                || (Color.BLACK == color && currentField.getNumber() == Number._7);
    }

}
