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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PawnStrategyTest {
    
    private final PieceMoveStrategy pawnStrategy = new PawnStrategy();

    @Test
    public void pawnFieldsInRangeTest_WhiteColor_A2() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._A, Field.Number._2);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.WHITE);
        
        Field expected1 = Field.getEmptyField(Field.Letter._A, Field.Number._3);
        Field expected2 = Field.getEmptyField(Field.Letter._A, Field.Number._4);
        Field expected3 = Field.getEmptyField(Field.Letter._B, Field.Number._3);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }
    
    @Test
    public void pawnFieldsInRangeTest_WhiteColor_B2() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._B, Field.Number._2);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.WHITE);
        
        Field expected1 = Field.getEmptyField(Field.Letter._A, Field.Number._3);
        Field expected2 = Field.getEmptyField(Field.Letter._B, Field.Number._4);
        Field expected3 = Field.getEmptyField(Field.Letter._B, Field.Number._3);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }
    
    @Test
    public void pawnFieldsInRangeTest_WhiteColor_B3() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._B, Field.Number._3);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.WHITE);
        
        Field expected1 = Field.getEmptyField(Field.Letter._B, Field.Number._4);
        Field expected2 = Field.getEmptyField(Field.Letter._A, Field.Number._4);
        Field expected3 = Field.getEmptyField(Field.Letter._C, Field.Number._4);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }
    
    @Test
    public void pawnFieldsInRangeTest_WhiteColor_B8() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._B, Field.Number._8);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.WHITE);
        
        assertNotNull(fields);
        assertEquals(0, fields.size());
    }
    
    @Test
    public void pawnFieldsInRangeTest_WhiteColor_B1() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._B, Field.Number._1);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.BLACK);
        
        assertNotNull(fields);
        assertEquals(0, fields.size());
    }
    
    @Test
    public void pawnFieldsInRangeTest_BlackColor_A7() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._A, Field.Number._7);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.BLACK);
        
        Field expected1 = Field.getEmptyField(Field.Letter._A, Field.Number._6);
        Field expected2 = Field.getEmptyField(Field.Letter._B, Field.Number._6);
        Field expected3 = Field.getEmptyField(Field.Letter._A, Field.Number._5);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }
    
    @Test
    public void pawnFieldsInRangeTest_BlackColor_C6() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._C, Field.Number._6);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.BLACK);
        
        Field expected1 = Field.getEmptyField(Field.Letter._C, Field.Number._5);
        Field expected2 = Field.getEmptyField(Field.Letter._D, Field.Number._5);
        Field expected3 = Field.getEmptyField(Field.Letter._B, Field.Number._5);
        
        assertThat(fields, hasItems(expected1, expected2, expected3));
    }
    
    @Test
    public void pawnFieldsInRangeTest_BlackColor_H6() {
        Board board = Board.getEmptyBoard();
        Field currentField = Field.getEmptyField(Field.Letter._H, Field.Number._6);
        Set<Field> fields = pawnStrategy.getAllFieldsInRange(board, currentField, Color.BLACK);
        
        Field expected1 = Field.getEmptyField(Field.Letter._H, Field.Number._5);
        Field expected2 = Field.getEmptyField(Field.Letter._G, Field.Number._5);
        
        assertThat(fields, hasItems(expected1, expected2));
    }
}
