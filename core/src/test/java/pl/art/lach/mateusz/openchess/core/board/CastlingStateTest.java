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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
@RunWith(MockitoJUnitRunner.class)
public class CastlingStateTest {
    
    @Mock
    private Board positiveScenarioBoard;
    
    @Mock
    private Board negativeScenarioBoard;
    
    
    @Before
    public void setupPositiveScenarioBoard() {
        
        Field h1 = mock(Field.class);
        when(h1.isEmpty()).thenReturn(false);
        
        Field e1 = mock(Field.class);
        when(e1.isEmpty()).thenReturn(false);
        
        Field a1 = mock(Field.class);
        when(a1.isEmpty()).thenReturn(false);
        
        Field a8 = mock(Field.class);
        when(a8.isEmpty()).thenReturn(false);
        
        Field h8 = mock(Field.class);
        when(h8.isEmpty()).thenReturn(false);
        
        Field e8 = mock(Field.class);
        when(e8.isEmpty()).thenReturn(false);
        
        when(positiveScenarioBoard.getField(Letter._H, Number._1))
            .thenReturn(h1);
        
        when(positiveScenarioBoard.getField(Letter._E, Number._1))
            .thenReturn(e1);
        
        when(positiveScenarioBoard.getField(Letter._A, Number._1))
            .thenReturn(a1);
                
        when(positiveScenarioBoard.getField(Letter._A, Number._8))
              .thenReturn(a8);
        
        when(positiveScenarioBoard.getField(Letter._H, Number._8))
              .thenReturn(h8);
        
        when(positiveScenarioBoard.getField(Letter._E, Number._8))
              .thenReturn(e8);
        
    }
    
    @Before
    public void setupNegativeScenarioBoard() {
        
        Field h1 = mock(Field.class);
        when(h1.isEmpty()).thenReturn(true);
        
        Field e1 = mock(Field.class);
        when(e1.isEmpty()).thenReturn(true);
        
        Field a1 = mock(Field.class);
        when(a1.isEmpty()).thenReturn(false);
        
        Field a8 = mock(Field.class);
        when(a8.isEmpty()).thenReturn(false);
        
        Field h8 = mock(Field.class);
        when(h8.isEmpty()).thenReturn(true);
        
        Field e8 = mock(Field.class);
        when(e8.isEmpty()).thenReturn(true);
        
        when(negativeScenarioBoard.getField(Letter._H, Number._1))
            .thenReturn(h1);
        
        when(negativeScenarioBoard.getField(Letter._E, Number._1))
            .thenReturn(e1);
        
        when(negativeScenarioBoard.getField(Letter._A, Number._1))
            .thenReturn(a1);
                
        when(negativeScenarioBoard.getField(Letter._A, Number._8))
              .thenReturn(a8);
        
        when(negativeScenarioBoard.getField(Letter._H, Number._8))
              .thenReturn(h8);
        
        when(negativeScenarioBoard.getField(Letter._E, Number._8))
              .thenReturn(e8);
        
    }
    
    @Test
    public void testRightCastlingPossibleForWhite() {
        CastlingState state = CastlingState.getInitialState();
        assertTrue(state.isRightCastlingPossible(positiveScenarioBoard, Color.WHITE));
    }

    @Test
    public void testLeftCastlingPossible() {
        CastlingState state = CastlingState.getInitialState();
        assertTrue(state.isLeftCastlingPossible(positiveScenarioBoard, Color.WHITE));
    }
    
    @Test
    public void testLeftCastlingPossibleForBlack() {
        CastlingState state = CastlingState.getInitialState();
        assertTrue(state.isLeftCastlingPossible(positiveScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testLeftCastlingNotPossibleForBlackAfterReturnOfKing() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isLeftCastlingPossible(positiveScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testRightCastlingNotPossibleForWhiteAfterReturnOfKing() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isRightCastlingPossible(positiveScenarioBoard, Color.WHITE));
        assertFalse(state.isRightCastlingPossible(positiveScenarioBoard, Color.BLACK));
    }

    
    @Test
    public void testLeftCastlingNotPossible_KingMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isLeftCastlingPossible(negativeScenarioBoard, Color.WHITE));
        assertFalse(state.isLeftCastlingPossible(negativeScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testLeftCastlingNotPossible_LeftRookMovedAndReturned() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setLeftRookMotioned();
        assertFalse(state.isLeftCastlingPossible(negativeScenarioBoard, Color.WHITE));
        assertFalse(state.isLeftCastlingPossible(negativeScenarioBoard, Color.BLACK));
        assertFalse(state.isLeftCastlingPossible(positiveScenarioBoard, Color.WHITE));
        assertFalse(state.isLeftCastlingPossible(positiveScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testLeftCastlingNotPossible_RightRookMovedAndReturned() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setRightRookMoved();
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.WHITE));
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.BLACK));
        assertFalse(state.isRightCastlingPossible(positiveScenarioBoard, Color.WHITE));
        assertFalse(state.isRightCastlingPossible(positiveScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testRightCastlingNotPossible_RookMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setRightRookMoved();
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.WHITE));
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.BLACK));
    }
    
    @Test
    public void testRightCastlingNotPossible_KingMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.WHITE));
        assertFalse(state.isRightCastlingPossible(negativeScenarioBoard, Color.BLACK));
    }
    

}
