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
/**
 * @author: Mateusz Sławomir Lach 
 */
public class FieldFacade {
    
    public static final int FIELDS_LENGTH = Field.Number.values().length;
    
    private static final Field[][] EMPTY_FIELDS_CACHE = createEmptyFields();

    private static Field[][] createEmptyFields() {
        Field[][] fields = new Field[FIELDS_LENGTH][FIELDS_LENGTH];
        for (int i = Field.Number._1.ordinal(); i < FIELDS_LENGTH; i++) {
            for (int j = Field.Letter._A.ordinal(); j < FIELDS_LENGTH; j++) {
                Field.Letter letter = Field.Letter.values()[i];
                Field.Number number = Field.Number.values()[j];
                fields[i][j] = Field.getEmptyField(letter, number);
            }
        }
        return fields;
    }
    
    public Field getEmptyFieldInstance(Letter letter, Number number) {
        return EMPTY_FIELDS_CACHE[letter.ordinal()][number.ordinal()];
    }
    

}
