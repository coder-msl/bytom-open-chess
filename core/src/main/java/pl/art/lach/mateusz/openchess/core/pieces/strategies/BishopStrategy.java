package pl.art.lach.mateusz.openchess.core.pieces.strategies;

import java.util.HashSet;
import java.util.Set;

import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;
import pl.art.lach.mateusz.openchess.core.pieces.Piece.Color;

public class BishopStrategy implements PieceStrategy {

    @Override
    public Set<Field> getAllFieldsInRange(Field currentField, Color white) {
        final Set<Field> fields = new HashSet<>();
        
        addFieldsInDirection(fields, currentField, 1, -1);
        addFieldsInDirection(fields, currentField, -1, 1);
        addFieldsInDirection(fields, currentField, -1, -1);
        addFieldsInDirection(fields, currentField, 1, 1);
        
        return fields;
    }

    private void addFieldsInDirection(Set<Field> fields, Field currentField, int letterDirection, int numberDirection) {
        int fieldLetter = currentField.getLetter().ordinal() + letterDirection;
        int fieldNumber = currentField.getNumber().ordinal() + numberDirection;
        while (Field.isFieldNumberValid(fieldLetter) && Field.isFieldNumberValid(fieldNumber)) {
            Letter letter = Field.Letter.values()[fieldLetter];
            Number number = Field.Number.values()[fieldNumber];
            
            fields.add(Field.getInstance(letter, number));
            
            fieldLetter += letterDirection;
            fieldNumber += numberDirection;
        }
    }

}
