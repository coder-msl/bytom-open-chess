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
package pl.art.lach.mateusz.openchess.core;

import java.util.Arrays;

import pl.art.lach.mateusz.openchess.core.board.Field;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class Board {
    
    private final int NUMBER_OF_FIELDS = Field.Number.values().length;
    
    private final Field[][] fields = new Field[NUMBER_OF_FIELDS][NUMBER_OF_FIELDS];
    
    public Board() {
        initializeFields();
    }

    private final void initializeFields() {
      for (int i = Field.Number._1.ordinal(); i < NUMBER_OF_FIELDS; i++) {
          for (int j = Field.Letter._A.ordinal(); j < NUMBER_OF_FIELDS; j++) {
              Field.Letter letter = Field.Letter.values()[i];
              Field.Number number = Field.Number.values()[j];
              fields[i][j] = new Field(letter, number);
          }
      }
    }

    public boolean isInBoard(int fieldNumber) {
        return fieldNumber >= Field.Number._1.ordinal()
                && fieldNumber <= Field.Number._8.ordinal();
    }

    public Field[][] getFields() {
        return Arrays.copyOf(fields, fields.length);
    }

}
