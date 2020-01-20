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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.Piece.Color;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PawnStrategy;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PawnTest extends PieceTest {

    @Test
    public void wasShiftedByTwoFieldsTest() {
        Pawn pawn = new Pawn();
        
        Field from = Field.getInstance(Field.Letter._A, Field.Number._7);
        Field to = Field.getInstance(Field.Letter._A, Field.Number._5);
        
        assertTrue(pawn.wasShiftedByTwoFields(from, to));
    }
    
    @Test
    public void wasntShiftedByTwoFieldsTest() {
        Pawn pawn = new Pawn();
        
        Field from = Field.getInstance(Field.Letter._A, Field.Number._7);
        Field to = Field.getInstance(Field.Letter._A, Field.Number._6);
        
        assertFalse(pawn.wasShiftedByTwoFields(from, to));
    }

    
    @Test
    public void pawnValueTest() {
        Pawn pawn = new Pawn();

        assertEquals(1, pawn.getValue());
    }
    
    @Test
    public void pawnShouldUseOneStrategyTest() {
        Pawn pawn = new Pawn();
        PawnStrategy pawnStrategy = new PawnStrategy();
        Field field = Field.getInstance(Field.Letter._A, Field.Number._2);
        pieceShouldReturnSameFieldsAsStrategyTest(pawn, pawnStrategy, field, Color.WHITE);
        pieceShouldReturnSameFieldsAsStrategyTest(pawn, pawnStrategy, field, Color.BLACK);
    }
}
