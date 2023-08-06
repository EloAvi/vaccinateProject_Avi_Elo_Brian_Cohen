package hac.controllers;

import hac.CitizenSummary;
import hac.entity.Citizen;
import hac.service.CitizenService;
import hac.service.City;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CitizenController {
    @Autowired
    private CitizenService citizenService;


    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("citizen", new Citizen());
        return "registration-form";
    }

    @PostMapping("/register")
    public String registerCitizen(@Valid @ModelAttribute("citizen") Citizen citizen, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration-form";
        }
        citizenService.registerCitizen(citizen);
        model.addAttribute("success", "Registration successful!");
        return "redirect:/summary"; // redirect to summary page after successful registration
    }


    @GetMapping("/registration-success")
    public String registrationSuccess() {
        return "registration-success"; // show success page
    }


    @GetMapping("/summary")
    public String showSummary(
            @RequestParam(name = "startDate", required = false) String startDateStr,
            @RequestParam(name = "endDate", required = false) String endDateStr,
            @RequestParam(name = "cityFilter", required = false) City cityFilter,
            Model model) {

        LocalDate startDate = startDateStr != null ? LocalDate.parse(startDateStr) : null;
        LocalDate endDate = endDateStr != null ? LocalDate.parse(endDateStr) : null;

        List<Citizen> citizens = citizenService.getAllCitizens(startDate, endDate, cityFilter);

        model.addAttribute("citizens", citizens);
        model.addAttribute("cities", City.values());

        return "summaryPage";
    }




    @GetMapping("/summary/search")
    public String searchSummary(@RequestParam(name = "startDate", required = false) LocalDate startDate,
                                @RequestParam(name = "endDate", required = false) LocalDate endDate,
                                @RequestParam(name = "city", required = false) City city,
                                Model model) {
        List<Citizen> citizens;

        if (startDate != null && endDate != null) {
            citizens = citizenService.findUsersByDateOfBirthBetween(startDate, endDate);
        } else if (city != null) {
            citizens = citizenService.findUsersByCity(city);
        } else {
            citizens = citizenService.getAllCitizens( startDate,  endDate,  city);
        }

        List<CitizenSummary> citizenSummaries = citizens.stream()
                .map(u -> new CitizenSummary(u, String.join(", ", u.getPreviousConditions().stream().map(Enum::name).collect(Collectors.toList()))))
                .collect(Collectors.toList());


        model.addAttribute("citizenSummaries", citizenSummaries);

        return "summaryPage";
    }


}
