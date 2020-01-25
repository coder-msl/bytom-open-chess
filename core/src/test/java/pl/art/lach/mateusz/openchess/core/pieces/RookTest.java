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
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.MoveStrategyFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class RookTest extends PieceTest {

    private Rook whiteRook = new Rook(Color.WHITE);
    
    private Rook blackRook = new Rook(Color.WHITE);
    
    @Test
    public void rookValueTest() {
        

        assertEquals(5, whiteRook.getValue());
    }
    
    @Test
    public void rookShouldUseOneStrategyTest() {
        PieceMoveStrategy rookStrategy = new MoveStrategyFactory().getRookStrategy();
        Field field = Field.getEmptyField(Field.Letter._A, Field.Number._2);
        shouldContainAllFieldsAsStrategy(whiteRook, rookStrategy, field);
        shouldContainAllFieldsAsStrategy(whiteRook, rookStrategy, field);
    }
}
