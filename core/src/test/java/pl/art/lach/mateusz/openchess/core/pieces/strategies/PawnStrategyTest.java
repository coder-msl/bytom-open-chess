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

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.board.Field;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PawnStrategyTest {

    @Test
    public void pawnWhiteColorFieldsInRangeTest() {
        PieceStrategy pawnStrategy = new PawnStrategy();
        Field currentField = Field.getInstance(Field.Letter._A, Field.Number._2);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(currentField);
        
        Field expected1 = Field.getInstance(Field.Letter._A, Field.Number._3);
        Field expected2 = Field.getInstance(Field.Letter._A, Field.Number._4);
        Field expected3 = Field.getInstance(Field.Letter._B, Field.Number._3);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }

}
