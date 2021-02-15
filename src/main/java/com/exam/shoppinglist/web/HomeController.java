package com.exam.shoppinglist.web;

import com.exam.shoppinglist.model.entity.CategoryName;
import com.exam.shoppinglist.model.view.ProductViewModel;
import com.exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public HomeController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession,
                        Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", this.productService.getTotalPrice());

        model.addAttribute("foods", this.productService
                .getAllByCategoryName(CategoryName.FOOD).stream()
                .map(p -> this.modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toUnmodifiableList()));

        model.addAttribute("drinks", this.productService
                .getAllByCategoryName(CategoryName.DRINK).stream()
                .map(p -> this.modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toUnmodifiableList()));

        model.addAttribute("households", this.productService
                .getAllByCategoryName(CategoryName.HOUSEHOLD).stream()
                .map(p -> this.modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toUnmodifiableList()));

        model.addAttribute("other", this.productService
                .getAllByCategoryName(CategoryName.OTHER).stream()
                .map(p -> this.modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toUnmodifiableList()));

        return "home";
    }
}
