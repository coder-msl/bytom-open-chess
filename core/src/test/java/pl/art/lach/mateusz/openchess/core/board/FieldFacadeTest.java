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

import static org.junit.Assert.*;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class FieldFacadeTest {
    
    private FieldFacade fieldFacade = new FieldFacade();

    @Test
    public void testEmptyFieldShouldBeSameInstance() {
        Field fieldA1 = fieldFacade.getEmptyFieldInstance(Field.Letter._A, Field.Number._1);
        assertEquals(Field.Number._1, fieldA1.getNumber());
        assertEquals(Field.Letter._A, fieldA1.getLetter());
        
        Field fieldA1_2 = fieldFacade.getEmptyFieldInstance(Field.Letter._A, Field.Number._1);
        assertEquals(Field.Number._1, fieldA1_2.getNumber());
        assertEquals(Field.Letter._A, fieldA1_2.getLetter());
        
        assertSame(fieldA1, fieldA1_2);
    }

    @Test
    public void testEmptyField() {
        Field fieldA1 = fieldFacade.getEmptyFieldInstance(Letter._A, Number._1);
        
        assertEquals(Field.Number._1, fieldA1.getNumber());
        assertEquals(Field.Letter._A, fieldA1.getLetter());
        assertEquals(fieldA1, Field.getEmptyField(Letter._A, Number._1));
    }
}
