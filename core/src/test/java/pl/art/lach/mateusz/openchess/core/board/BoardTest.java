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

import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import pl.art.lach.mateusz.openchess.core.pieces.Piece;
import pl.art.lach.mateusz.openchess.core.pieces.PieceFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class BoardTest {
    
    private Board board = Board.getEmptyBoard();

    @Test
    public void isInBoardTest() {
        assertTrue(Field.isFieldNumberValid(0));
        assertTrue(Field.isFieldNumberValid(1));
        assertTrue(Field.isFieldNumberValid(2));
        assertTrue(Field.isFieldNumberValid(3));
        assertTrue(Field.isFieldNumberValid(4));
        assertTrue(Field.isFieldNumberValid(5));
        assertTrue(Field.isFieldNumberValid(6));
        assertTrue(Field.isFieldNumberValid(7));
        
        assertFalse(Field.isFieldNumberValid(8));
        assertFalse(Field.isFieldNumberValid(9));
        assertFalse(Field.isFieldNumberValid(-1));
    }
    
    @Test
    public void boardHasBeenCorrectlyInitiatedTest() {
        Field[][] fields = board.getFields();
        
        for (Field[] row : fields) {
            for (Field column : row) {
                assertNotNull(column);
                assertTrue(column instanceof Field);
            }
        }
    }
    
    @Test
    public void boardFieldsHasCorrectNumbersTest() {
        Field[][] fields = board.getFields();
                
        assertEquals(Field.Letter._A, fields[0][0].getLetter());
        assertEquals(Field.Number._1, fields[0][0].getNumber());
        
        assertEquals(Field.Letter._H, fields[7][7].getLetter());
        assertEquals(Field.Number._8, fields[7][7].getNumber());
    }
    
    @Test
    public void boardBuilderAdjustFieldTest() {
        Piece piece = new PieceFactory().getPawnInstance();
        Field field = Field.getOccupiedField(Letter._B, Number._2, piece);
        Board adjustedBoard = new Board.Builder(board)
                .setField(field)
                .build();
        
        Field givenField = adjustedBoard.getField(field.getLetter(), field.getNumber());
        assertSame(piece, givenField.getPiece());
    }

}
