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

import java.util.HashMap;
import java.util.Map;

import pl.art.lach.mateusz.openchess.core.Color;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PieceFactory {
    
    private static final Map<Class<? extends Piece>, Piece> WHITE_PIECES = new HashMap<>();
    private static final Map<Class<? extends Piece>, Piece> BLACK_PIECES = new HashMap<>();
    
    static {
        WHITE_PIECES.put(Pawn.class, new Pawn(Color.WHITE));
        WHITE_PIECES.put(King.class, new King(Color.WHITE));
        WHITE_PIECES.put(Rook.class, new Rook(Color.WHITE));
    }
    
    static {
        BLACK_PIECES.put(Pawn.class, new Pawn(Color.BLACK));
        BLACK_PIECES.put(King.class, new King(Color.BLACK));
        BLACK_PIECES.put(Rook.class, new Rook(Color.BLACK));
    }
    
    public Piece getPawnInstance(final Color color) {
        return color == Color.WHITE ? 
                WHITE_PIECES.get(Pawn.class) 
                : BLACK_PIECES.get(Pawn.class);
    }

    public Piece getKingInstance(final Color color) {
        return color == Color.WHITE ?
                WHITE_PIECES.get(King.class)
                : BLACK_PIECES.get(King.class);
    }

    public Piece getRookInstance(final Color color) {
        return color == Color.WHITE ? 
                WHITE_PIECES.get(Rook.class) 
                : BLACK_PIECES.get(Rook.class);
    }

}
