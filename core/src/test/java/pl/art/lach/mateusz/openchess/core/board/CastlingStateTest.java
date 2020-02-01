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

/**
 * @author: Mateusz Sławomir Lach 
 */
public class CastlingStateTest {

    @Test
    public void testRightCastlingPossible() {
        CastlingState state = CastlingState.getInitialState();
        assertTrue(state.isRightCastlingPossible());
    }

    @Test
    public void testLeftCastlingPossible() {
        CastlingState state = CastlingState.getInitialState();
        assertTrue(state.isLeftCastlingPossible());
    }
    
    @Test
    public void testLeftCastlingNotPossible_KingMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isLeftCastlingPossible());
    }
    
    
    @Test
    public void testLeftCastlingNotPossible_RookMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setLeftRookMotioned();
        assertFalse(state.isLeftCastlingPossible());
    }
    
    @Test
    public void testRightCastlingNotPossible_RookMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setRightRookMoved();
        assertFalse(state.isRightCastlingPossible());
    }
    
    
    @Test
    public void testRightCastlingNotPossible_KingMoved() {
        CastlingState state = CastlingState.getInitialState();
        state = state.setKingMoved();
        assertFalse(state.isRightCastlingPossible());
    }
    

}
