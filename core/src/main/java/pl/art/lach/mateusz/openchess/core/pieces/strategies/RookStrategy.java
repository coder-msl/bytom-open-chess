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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class RookStrategy extends LongRangeStrategy {

    @Override
    public Set<Field> getAllFieldsInRange(Field currentField, Color white) {
        final Set<Field> fields = new HashSet<>();
        
        addFieldsInDirection(fields, currentField, Direction.TOP);
        addFieldsInDirection(fields, currentField, Direction.BOTTOM);
        addFieldsInDirection(fields, currentField, Direction.LEFT);
        addFieldsInDirection(fields, currentField, Direction.RIGHT);
        
        return Collections.unmodifiableSet(fields);
    }



}
