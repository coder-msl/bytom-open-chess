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
import pl.art.lach.mateusz.openchess.core.pieces.strategies.RookStrategy;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class KnightTest extends PieceTest {

    
    @Test
    public void knightValueTest() {
        Knight rook = new Knight();

        assertEquals(3, rook.getValue());
    }
    
    @Test
    public void rookShouldUseOneStrategyTest() {
        Rook rook = new Rook();
        RookStrategy rookStrategy = new RookStrategy();
        Field field = Field.getInstance(Field.Letter._C, Field.Number._4);
        pieceShouldContainsAllFieldsReturnedByStrategyTest(rook, rookStrategy, field, Color.WHITE);
        pieceShouldContainsAllFieldsReturnedByStrategyTest(rook, rookStrategy, field, Color.BLACK);
    }
}
