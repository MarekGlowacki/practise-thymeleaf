package online.javafun.excercise;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
public class FormatCodeService {

    String formatCode(String source) throws FormatterException {
        return new Formatter().formatSource(source);
    }
}
