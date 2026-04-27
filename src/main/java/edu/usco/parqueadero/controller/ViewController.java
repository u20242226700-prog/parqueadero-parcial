package edu.usco.parqueadero.controller;

import edu.usco.parqueadero.repository.VehiculoRepository;
import edu.usco.parqueadero.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private VehiculoRepository vehiculoRepo;

    @Autowired
    private TipoVehiculoRepository tipoRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("vehiculos", vehiculoRepo.findAll());
        model.addAttribute("tipos", tipoRepo.findAll());
        return "home";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
} 