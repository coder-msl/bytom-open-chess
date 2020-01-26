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
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.MoveStrategyFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class QueenTest extends PieceTest {

    private Queen queen;
    
    private PieceMoveStrategy rookStrategy;
    
    private PieceMoveStrategy bishopStrategy;
    
    @Before
    public void setup() {
        queen = new Queen(Color.WHITE);
        rookStrategy = new MoveStrategyFactory().getRookStrategy();
        bishopStrategy = new MoveStrategyFactory().getBishopStrategy();
    }
    
    @Test
    public void queenValueTest() {
        assertEquals(9, queen.getValue());
    }
    
    @Test
    public void rookShouldUseOneStrategyTest_White() {
        Field field = Field.getEmptyField(Field.Letter._A, Field.Number._2);
        Board board = Board.getEmptyBoard();
        Set<Field> queenWhiteFields = queen.getAllFieldsInRange(board, field, Color.WHITE);
        Set<Field> rookStrategyFields = rookStrategy.getAllFieldsInRange(board, field, Color.WHITE);
        Set<Field> bishopStrategyFields = bishopStrategy.getAllFieldsInRange(board, field, Color.WHITE);

        assertEquals(queenWhiteFields.size(), rookStrategyFields.size() + bishopStrategyFields.size());

        assertTrue(queenWhiteFields.containsAll(rookStrategyFields));
        assertTrue(queenWhiteFields.containsAll(bishopStrategyFields));
    }
    
    
    @Test
    public void rookShouldUseOneStrategyTest_Black() {
        Field field = Field.getEmptyField(Field.Letter._A, Field.Number._2);
        Board board = Board.getEmptyBoard();
        Set<Field> queenBlackFields = queen.getAllFieldsInRange(board, field, Color.BLACK);
        Set<Field> rookStrategyFields = rookStrategy.getAllFieldsInRange(board, field, Color.BLACK);
        Set<Field> bishopStrategyFields = bishopStrategy.getAllFieldsInRange(board, field, Color.BLACK);

        assertEquals(queenBlackFields.size(), rookStrategyFields.size() + bishopStrategyFields.size());
        assertTrue(queenBlackFields.containsAll(rookStrategyFields));
        assertTrue(queenBlackFields.containsAll(bishopStrategyFields));
    }
}
