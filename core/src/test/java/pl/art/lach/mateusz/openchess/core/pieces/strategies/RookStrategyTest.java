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
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static pl.art.lach.mateusz.openchess.core.Color.WHITE;

import java.util.Set;

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
public class RookStrategyTest {
    
    private final RookStrategy rookStrategy = new RookStrategy();
    
    private final PieceFactory pieceFactory = new PieceFactory();

    @Test
    public void bishopFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        Board board = Board.getEmptyBoard();
        final Set<Field> fields = rookStrategy.getAllFieldsInRange(board, fieldC4, WHITE);
        
        Field fieldB4 = Field.getEmptyField(Letter._B, Number._4);
        Field fieldA4 = Field.getEmptyField(Letter._A, Number._4);
        
        Field fieldD4 = Field.getEmptyField(Letter._D, Number._4);
        Field fieldE4 = Field.getEmptyField(Letter._E, Number._4);
        Field fieldF4 = Field.getEmptyField(Letter._F, Number._4);
        Field fieldG4 = Field.getEmptyField(Letter._G, Number._4);
        Field fieldH4 = Field.getEmptyField(Letter._H, Number._4);
        
        Field fieldC5 = Field.getEmptyField(Letter._C, Number._5);
        Field fieldC6 = Field.getEmptyField(Letter._C, Number._6);
        Field fieldC7 = Field.getEmptyField(Letter._C, Number._7);
        Field fieldC8 = Field.getEmptyField(Letter._C, Number._8);
        
        Field fieldC3 = Field.getEmptyField(Letter._C, Number._3);
        Field fieldC2 = Field.getEmptyField(Letter._C, Number._2);
        Field fieldC1 = Field.getEmptyField(Letter._C, Number._1);
        
        assertThat(fields, hasItems(fieldB4, fieldA4));
        assertThat(fields, hasItems(fieldD4, fieldE4, fieldF4, fieldG4, fieldH4));
        assertThat(fields, hasItems(fieldC5, fieldC6, fieldC7, fieldC8));
        assertThat(fields, hasItems(fieldC1, fieldC2, fieldC3));
        
     }
     
    @Test
    public void bishopFieldsInRangeTestWithObstacles_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        
        //blocker pieces
        Piece pawn = pieceFactory.getPawnInstance(WHITE);
        Field fieldA4 = Field.getField(Letter._A, Number._4, pawn);
        Field fieldE4 = Field.getField(Letter._E, Number._4, pawn);
        Field fieldC7 = Field.getField(Letter._C, Number._7, pawn);
        Field fieldC2 = Field.getField(Letter._C, Number._2, pawn);
      
        Board board = Board.Builder.ofEmptyBoard()
                .setField(fieldA4)
                .setField(fieldE4)
                .setField(fieldC7)
                .setField(fieldC2)
                .build();
        
        Set<Field> fields = rookStrategy.getAllFieldsInRange(board, fieldC4, WHITE);
        
        assertThat(fields, hasItems(Field.getEmptyField(Letter._B, Number._4)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._D, Number._4)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._C, Number._6)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._C, Number._3)));
        
        assertThat(fields, not(hasItems(fieldA4, fieldE4, fieldC7, fieldC2)));
        
        //fields behind blocked pieces
        Field fieldA3 = Field.getEmptyField(Letter._A, Number._3);
        Field fieldE5 = Field.getEmptyField(Letter._E, Number._5);
        Field fieldC8 = Field.getEmptyField(Letter._C, Number._8);
        Field fieldC1 = Field.getEmptyField(Letter._C, Number._1);

        assertThat(fields, not(hasItems(fieldA3, fieldE5, fieldC8, fieldC1)));
     }
     
     

}
