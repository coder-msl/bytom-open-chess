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

/**
 * @author: Mateusz Sławomir Lach 
 */
public class MoveStrategyFactory {
    
    private static final KingStrategy KING_STRATEGY = new KingStrategy();
    private static final RookStrategy ROOK_STRATEGY = new RookStrategy();
    private static final BishopStrategy BISHOP_STRATEGY = new BishopStrategy();
    private static final KnightStrategy KNIGHT_STRATEGY = new KnightStrategy();
    private static final PieceMoveStrategy PAWN_STRATEGY = new PawnStrategy(); 

    public PieceMoveStrategy getPawnStrategy() {
        return PAWN_STRATEGY;
    }
    
    public PieceMoveStrategy getKnightStrategy() {
        return KNIGHT_STRATEGY;
    }
    
    public PieceMoveStrategy getBishopStrategy() {
        return BISHOP_STRATEGY;
    }
    
    public PieceMoveStrategy getRookStrategy() {
        return ROOK_STRATEGY;
    }
    
    public PieceMoveStrategy getKingStrategy() {
        return KING_STRATEGY;
    }
}
