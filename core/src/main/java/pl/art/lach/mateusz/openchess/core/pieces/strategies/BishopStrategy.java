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

import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import pl.art.lach.mateusz.openchess.core.pieces.Piece.Color;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class BishopStrategy implements PieceStrategy {

    @Override
    public Set<Field> getAllFieldsInRange(Field currentField, Color white) {
        final Set<Field> fields = new HashSet<>();
        
        addFieldsInDirection(fields, currentField, 1, -1);
        addFieldsInDirection(fields, currentField, -1, 1);
        addFieldsInDirection(fields, currentField, -1, -1);
        addFieldsInDirection(fields, currentField, 1, 1);
        
        return fields;
    }

    private void addFieldsInDirection(Set<Field> fields, Field currentField, int letterDirection, int numberDirection) {
        int fieldLetter = currentField.getLetter().ordinal() + letterDirection;
        int fieldNumber = currentField.getNumber().ordinal() + numberDirection;
        while (Field.isFieldNumberValid(fieldLetter) && Field.isFieldNumberValid(fieldNumber)) {
            Letter letter = Field.Letter.values()[fieldLetter];
            Number number = Field.Number.values()[fieldNumber];
            
            fields.add(Field.getInstance(letter, number));
            
            fieldLetter += letterDirection;
            fieldNumber += numberDirection;
        }
    }

}
