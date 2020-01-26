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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.MoveStrategyFactory;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy;

/**
 * @author: Mateusz Sławomir Lach 
 */
public abstract class Piece {

    private final int value;
    
    private final List<PieceMoveStrategy> strategies = new ArrayList<>();
    
    private final char symbol;
    
    private final MoveStrategyFactory strategyFactory = new MoveStrategyFactory();
    
    private final Color color;
    
    Piece(int value, char symbol, Color color) {
        this.value = value;
        this.symbol = symbol;
        this.color = color;
    }
        
    int getValue() {
        return value;
    }
    
    char getSymbol() {
        return symbol;
    }
    
    public Color getColor() {
        return color;
    }
    
    List<PieceMoveStrategy> getStrategies() {
        return strategies;
    }
    
    MoveStrategyFactory getStrategyFactory() {
        return strategyFactory;
    }

    public Set<Field> getAllFieldsInRange(Board board, Field currentField, Color color) {
        Set<Field> fields = new HashSet<>();
        strategies.forEach((strategy) -> {
            fields.addAll(strategy.getAllFieldsInRange(board, currentField, color));
        });
        return fields;
    }
}
