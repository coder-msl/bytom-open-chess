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
package pl.art.lach.mateusz.openchess.core.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.KingStrategy;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class KingTest extends PieceTest {

    
    @Test
    public void rookValueTest() {
        King king = new King();
        assertEquals(0, king.getValue());
    }
    
    @Test
    public void rookShouldUseOneStrategyTest() {
        King king = new King();
        KingStrategy kingStrategy = new KingStrategy();
        Field field = Field.getInstance(Field.Letter._E, Field.Number._1);
        shouldContainAllFieldsAsStrategy(king, kingStrategy, field, Color.WHITE);
        shouldContainAllFieldsAsStrategy(king, kingStrategy, field, Color.BLACK);
    }
}
