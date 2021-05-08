package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {
    private final Random random = new Random();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("form", new RegistraceForm());
        return modelAndView;
    }

    @PostMapping("")
    public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }

        //věk musi byt mezi 9 a 15 roky (včetně)
        LocalDate datumNarozeni = LocalDate.parse(form.getDatum());
        Period period = datumNarozeni.until(LocalDate.now());
        int vek = period.getYears();

        // vek neni OK
        if ((vek < 9) || (vek > 15)) {
            bindingResult.rejectValue("datum", "", "Je nám líto, věk dítěte musí být mezi 9 a 15 roky.");
            return "formular";
        }

        //bud neni vybrany zadny sport nebo jen jeden
        if (form.getSport() == null || form.getSport().size() < 2) {
            bindingResult.rejectValue("sport", "", "Musíte vybrat alespoň dva sporty.");
            return "formular";
        }

        //vse OK, vratim rekapitulaci objednavky
        return new ModelAndView("rekapitulace")
                .addObject("form", form);
    }
}
