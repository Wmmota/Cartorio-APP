package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Cartorio;
import com.example.demo.repository.CartorioRepository;



@Controller
@RequestMapping("/cartorios/")
public class CartorioController {

    private final CartorioRepository cartorioRepository;

    @Autowired
    public CartorioController(CartorioRepository cartorioRepository) {
        this.cartorioRepository = cartorioRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Cartorio cartorio) {
        return "add-cartorio";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("cartorios", cartorioRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addCartorio(@Valid Cartorio cartorio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-cartorio";
        }

        cartorioRepository.save(cartorio);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id do cartório inválido:" + id));
        model.addAttribute("cartorio", cartorio);
        return "update-cartorio";
    }

    @PostMapping("update/{id}")
    public String updateCartorio(@PathVariable("id") long id, @Valid Cartorio cartorio, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            cartorio.setId(id);
            return "update-cartorio";
        }

        cartorioRepository.save(cartorio);
        model.addAttribute("Cartorios", cartorioRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id do cartório inválido:" + id));
        cartorioRepository.delete(cartorio);
        model.addAttribute("cartorios", cartorioRepository.findAll());
        return "index";
    }
}