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
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach
 */
public class KnightStrategyTest {

    private KnightStrategy knightStrategy = new KnightStrategy();

    @Test
    public void knightFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        Board board = Board.getEmptyBoard();
        Set<Field> fields = knightStrategy.getAllFieldsInRange(board, fieldC4, Color.WHITE);

        Field fieldA3 = Field.getEmptyField(Letter._A, Number._3);
        Field fieldA5 = Field.getEmptyField(Letter._A, Number._5);

        Field fieldB2 = Field.getEmptyField(Letter._B, Number._2);
        Field fieldB6 = Field.getEmptyField(Letter._B, Number._6);

        Field fieldD2 = Field.getEmptyField(Letter._D, Number._2);
        Field fieldD6 = Field.getEmptyField(Letter._D, Number._6);

        Field fieldE3 = Field.getEmptyField(Letter._E, Number._3);
        Field fieldE5 = Field.getEmptyField(Letter._E, Number._5);

        assertThat(fields, hasItems(fieldA3, fieldA5));
        assertThat(fields, hasItems(fieldB2, fieldB6));
        assertThat(fields, hasItems(fieldD2, fieldD6));
        assertThat(fields, hasItems(fieldE3, fieldE5));

    }

    @Test
    public void knightFieldsInRangeTest_A1() {
        Field fieldA1 = Field.getEmptyField(Letter._A, Number._1);
        Board board = Board.getEmptyBoard();
        Set<Field> fields = knightStrategy.getAllFieldsInRange(board, fieldA1, Color.WHITE);

        Field fieldC2 = Field.getEmptyField(Letter._C, Number._2);
        Field fieldB3 = Field.getEmptyField(Letter._B, Number._3);

        assertThat(fields, hasItems(fieldC2, fieldB3));

    }
    
    @Test
    public void knightFieldsInRangeTest_H8() {
        Field fieldH8 = Field.getEmptyField(Letter._H, Number._8);
        Board board = Board.getEmptyBoard();
        Set<Field> fields = knightStrategy.getAllFieldsInRange(board, fieldH8, Color.WHITE);
        
        Field fieldF7 = Field.getEmptyField(Letter._F, Number._7);
        Field fieldG6 = Field.getEmptyField(Letter._G, Number._6);
        
        assertThat(fields, hasItems(fieldF7, fieldG6));
        
    }
    
    @Test
    public void knightFieldsInRangeTest_A8() {
        Field fieldA8 = Field.getEmptyField(Letter._A, Number._8);
        Board board = Board.getEmptyBoard();
        Set<Field> fields = knightStrategy.getAllFieldsInRange(board, fieldA8, Color.WHITE);
        
        Field fieldB6 = Field.getEmptyField(Letter._B, Number._6);
        Field fieldC7 = Field.getEmptyField(Letter._C, Number._7);
        
        assertThat(fields, hasItems(fieldB6, fieldC7));
        
    }
}
