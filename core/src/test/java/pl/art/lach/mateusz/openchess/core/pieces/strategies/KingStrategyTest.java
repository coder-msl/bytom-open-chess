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
public class KingStrategyTest {
    
    private final KingStrategy kingStrategy = new KingStrategy();
    
    private final PieceFactory pieceFactory = new PieceFactory();

    @Test
    public void kingFieldsInRangeTest_E1() {
        Field fieldE1 = Field.getEmptyField(Letter._E, Number._1);
        Board board = Board.getEmptyBoard();
        final Set<Field> fields = kingStrategy.getAllFieldsInRange(board, fieldE1, WHITE);
        
        Field fieldD1 = Field.getEmptyField(Letter._D, Number._1);
        Field fieldD2 = Field.getEmptyField(Letter._D, Number._2);
        
        Field fieldE2 = Field.getEmptyField(Letter._E, Number._2);
        
        Field fieldF2 = Field.getEmptyField(Letter._F, Number._2);
        Field fieldF1 = Field.getEmptyField(Letter._F, Number._1);
        
        assertThat(fields, hasItems(fieldD1, fieldD2, fieldE2, fieldF2, fieldF1));
     }
    
    @Test
    public void kingFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        Board board = Board.getEmptyBoard();
        final Set<Field> fields = kingStrategy.getAllFieldsInRange(board, fieldC4, WHITE);
        
        Field fieldC3 = Field.getEmptyField(Letter._C, Number._3);
        Field fieldC5 = Field.getEmptyField(Letter._C, Number._5);
        
        Field fieldB4 = Field.getEmptyField(Letter._B, Number._4);
        Field fieldB3 = Field.getEmptyField(Letter._B, Number._3);
        Field fieldB5 = Field.getEmptyField(Letter._B, Number._5);
        
        Field fieldD4 = Field.getEmptyField(Letter._D, Number._4);
        Field fieldD3 = Field.getEmptyField(Letter._D, Number._3);
        Field fieldD5 = Field.getEmptyField(Letter._D, Number._5);
        
        assertThat(fields, hasItems(fieldC3, fieldC5));
        assertThat(fields, hasItems(fieldB4, fieldB3, fieldB5));
        assertThat(fields, hasItems(fieldD4, fieldD3, fieldD5));
     }
    
    
    @Test
    public void testWhiteKingRightAndLeftCastling() {
        
        Piece king = pieceFactory.getKingInstance(WHITE);
        Piece rookH1 = pieceFactory.getRookInstance(WHITE);
        Piece rookA1 = pieceFactory.getRookInstance(WHITE);
        
        Field fieldH1 = Field.getField(Letter._H, Number._1, rookH1);
        Field fieldA1 = Field.getField(Letter._A, Number._1, rookA1);
        Field fieldE1 = Field.getField(Letter._E, Number._1, king);
        
        Board board = Board.Builder.ofEmptyBoard()
                .setField(fieldH1)
                .setField(fieldE1)
                .setField(fieldA1)
                .build();
        
        final Set<Field> fields = kingStrategy.getAllFieldsInRange(board, fieldE1, WHITE);

        Field fieldF1 = Field.getEmptyField(Letter._F, Number._1);
        Field fieldG1 = Field.getEmptyField(Letter._G, Number._1);
        Field fieldD1 = Field.getEmptyField(Letter._D, Number._1);
        
        assertThat(fields, hasItems(fieldF1, fieldG1, fieldD1));
    }

}
