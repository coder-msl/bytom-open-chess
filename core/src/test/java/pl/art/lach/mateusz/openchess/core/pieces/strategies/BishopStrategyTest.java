package pl.art.lach.mateusz.openchess.core.pieces.strategies;

import java.util.Set;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import pl.art.lach.mateusz.openchess.core.pieces.Piece;
import pl.art.lach.mateusz.openchess.core.pieces.PieceFactory;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static pl.art.lach.mateusz.openchess.core.Color.BLACK;
import static pl.art.lach.mateusz.openchess.core.Color.WHITE;

public class BishopStrategyTest {
    
    private final PieceMoveStrategy bishopStrategy = new BishopStrategy();
    
    private final PieceFactory pieceFactory = new PieceFactory();

    @Test
    public void bishopFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        Board board = Board.getEmptyBoard();
        final Set<Field> fields = bishopStrategy.getAllFieldsInRange(board, fieldC4, Color.WHITE);
        
        Field fieldB5 = Field.getEmptyField(Letter._B, Number._5);
        Field fieldA6 = Field.getEmptyField(Letter._A, Number._6);
        
        Field fieldD5 = Field.getEmptyField(Letter._D, Number._5);
        Field fieldE6 = Field.getEmptyField(Letter._E, Number._6);
        Field fieldF7 = Field.getEmptyField(Letter._F, Number._7);
        Field fieldG8 = Field.getEmptyField(Letter._G, Number._8);
        
        Field fieldB3 = Field.getEmptyField(Letter._B, Number._3);
        Field fieldA2 = Field.getEmptyField(Letter._A, Number._2);
        
        Field fieldD3 = Field.getEmptyField(Letter._D, Number._3);
        Field fieldE2 = Field.getEmptyField(Letter._E, Number._2);
        Field fieldF1 = Field.getEmptyField(Letter._F, Number._1);
        
        assertThat(fields, hasItems(fieldB5, fieldA6));
        assertThat(fields, hasItems(fieldD5, fieldE6, fieldF7, fieldG8));
        assertThat(fields, hasItems(fieldB3, fieldA2));
        assertThat(fields, hasItems(fieldD3, fieldE2, fieldF1));
        
     }
    
    @Test
    public void bishopFieldsInRangeTestWithObstacles_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        //blocker pieces
        Piece pawn = pieceFactory.getPawnInstance(WHITE);
        
        Field fieldA2 = Field.getField(Letter._A, Number._2, pawn);
        Field fieldA6 = Field.getField(Letter._A, Number._6, pawn);
        
        Field fieldE2 = Field.getField(Letter._E, Number._2, pawn);
        Field fieldE6 = Field.getField(Letter._E, Number._6, pawn);
      
        Board board = Board.Builder.ofEmptyBoard()
                .setField(fieldA2)
                .setField(fieldA6)
                .setField(fieldE2)
                .setField(fieldE6)
                .build();
        
        Set<Field> fields = bishopStrategy.getAllFieldsInRange(board, fieldC4, BLACK);
        
        assertThat(fields, hasItems(Field.getEmptyField(Letter._B, Number._2)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._B, Number._5)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._D, Number._3)));
        assertThat(fields, hasItems(Field.getEmptyField(Letter._D, Number._5)));
        
        assertThat(fields, not(hasItems(fieldA2, fieldA6, fieldE2, fieldE6)));
        
        //fields behind blocked pieces
        Field fieldF7 = Field.getEmptyField(Letter._F, Number._7);
        Field fieldF1 = Field.getEmptyField(Letter._F, Number._1);

        assertThat(fields, not(hasItems(fieldF7, fieldF1)));
     }

}
