package Sourse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Field {
    private final HashMap<Integer,Figure> field;
    public Field(){
        field = new HashMap<>();
        field.put(0, Figure.EMPTY);
        field.put(1, Figure.EMPTY);
        field.put(2, Figure.EMPTY);
        field.put(3, Figure.EMPTY);
        field.put(4, Figure.EMPTY);
        field.put(5, Figure.EMPTY);
        field.put(6, Figure.EMPTY);
        field.put(7, Figure.EMPTY);
        field.put(8, Figure.EMPTY);
    }
    public Map<Integer, Figure> getField() {
        return field;
    }
    public int getEmptyFieldIndex() {
        return field.entrySet().stream()
                .filter(e -> e.getValue() == Figure.EMPTY)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }
    public List<Figure> getFieldData() {
        return field.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
