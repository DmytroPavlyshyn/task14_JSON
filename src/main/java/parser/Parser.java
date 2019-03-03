package parser;

import java.io.IOException;
import java.util.List;

public interface Parser<T> {
    List<T> readJSON();
    void writeJSON(List<T> list);
}
