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
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class KingStrategyTest {
    
    private final KingStrategy kingStrategy = new KingStrategy();

    @Test
    public void kingFieldsInRangeTest_E1() {
        Field fieldE1 = Field.getInstance(Letter._E, Number._1);
        final Set<Field> fields = kingStrategy.getAllFieldsInRange(fieldE1, Color.WHITE);
        
        Field fieldD1 = Field.getInstance(Letter._D, Number._1);
        Field fieldD2 = Field.getInstance(Letter._D, Number._2);
        
        Field fieldE2 = Field.getInstance(Letter._E, Number._2);
        
        Field fieldF2 = Field.getInstance(Letter._F, Number._2);
        Field fieldF1 = Field.getInstance(Letter._F, Number._1);
        
        assertThat(fields, hasItems(fieldD1, fieldD2, fieldE2, fieldF2, fieldF1));
     }
    
    @Test
    public void kingFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getInstance(Letter._C, Number._4);
        final Set<Field> fields = kingStrategy.getAllFieldsInRange(fieldC4, Color.WHITE);
        
        Field fieldC3 = Field.getInstance(Letter._C, Number._3);
        Field fieldC5 = Field.getInstance(Letter._C, Number._5);
        
        Field fieldB4 = Field.getInstance(Letter._B, Number._4);
        Field fieldB3 = Field.getInstance(Letter._B, Number._3);
        Field fieldB5 = Field.getInstance(Letter._B, Number._5);
        
        Field fieldD4 = Field.getInstance(Letter._D, Number._4);
        Field fieldD3 = Field.getInstance(Letter._D, Number._3);
        Field fieldD5 = Field.getInstance(Letter._D, Number._5);
        
        assertThat(fields, hasItems(fieldC3, fieldC5));
        assertThat(fields, hasItems(fieldB4, fieldB3, fieldB5));
        assertThat(fields, hasItems(fieldD4, fieldD3, fieldD5));
     }

}
