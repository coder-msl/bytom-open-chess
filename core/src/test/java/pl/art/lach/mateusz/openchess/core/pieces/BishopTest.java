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
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceStrategy;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.StrategyFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class BishopTest extends PieceTest {

    private Bishop bishop = new Bishop();
    
    private PieceStrategy strategy = new StrategyFactory().getBishopStrategy();
    
    @Test
    public void pawnValueTest() {
        assertEquals(3, bishop.getValue());
    }
    
    @Test
    public void bishopShouldUseOneStrategyTest_A2() {
        Field field = Field.getOccupiedField(Field.Letter._A, Field.Number._2, bishop);
        shouldContainAllFieldsAsStrategy(bishop, strategy, field, Color.WHITE);
    }
    
    @Test
    public void bishopShouldUseOneStrategyTest_E5() {
        Field field = Field.getFreeField(Field.Letter._E, Field.Number._5);
        shouldContainAllFieldsAsStrategy(bishop, strategy, field, Color.BLACK);
    }
}
