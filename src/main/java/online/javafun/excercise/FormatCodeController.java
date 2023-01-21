package online.javafun.excercise;

import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormatCodeController {

    private FormatCodeService formatCodeService;

    public FormatCodeController(FormatCodeService formatCodeService) {
        this.formatCodeService = formatCodeService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/formatowanie")
    String formatCode(@RequestParam String unformattedText, Model model) {
        try {
            String formattedText = formatCodeService.formatCode(unformattedText);
            model.addAttribute("formattedText", formattedText);
        } catch (FormatterException e) {
            return "wrong-code";
        }
        model.addAttribute("unformattedText", unformattedText);
        return "code-result";
    }
}
