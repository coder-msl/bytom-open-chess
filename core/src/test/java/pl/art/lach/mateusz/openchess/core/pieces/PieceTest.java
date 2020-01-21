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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.Set;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceStrategy;

/**
 * @author: Mateusz Sławomir Lach 
 */
abstract class PieceTest {

    public void shouldContainAllFieldsAsStrategy(final Piece piece, 
            final PieceStrategy strategy, final Field field, final Color color) {

        Set<Field> fieldsFromPiece = piece.getAllFieldsInRange(field, color);
        Set<Field> fieldsFromStrategy = strategy.getAllFieldsInRange(field, color);

        
        fieldsFromPiece.forEach((element) -> {
            assertThat(fieldsFromStrategy, hasItem(element));
        });
    }
    
}
