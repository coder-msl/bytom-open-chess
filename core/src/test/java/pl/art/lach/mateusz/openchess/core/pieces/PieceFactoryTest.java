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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PieceFactoryTest {

    @Test
    public void testCreatePawn() {
        Piece pawn = PieceFactory.getPawnInstance();
        assertTrue(pawn instanceof Piece);
        assertEquals(1, pawn.getValue());
    }

}
