package com.spo.ecommerce.infrastructure.controller;

import com.spo.ecommerce.application.service.StockService;
import com.spo.ecommerce.application.service.ValidateStock;
import com.spo.ecommerce.domain.Product;
import com.spo.ecommerce.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Product product = new Product();
        product.setId(id);
        List<Stock> stockList = stockService.getStockByProduct(product);
        model.addAttribute("stocks", stockList);
        model.addAttribute("idProduct", id);
        return "admin/stock/show";
    }

    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model) {
        model.addAttribute("idProduct", id);
        return "admin/stock/create";
    }

    @PostMapping("/save-unit-product")
    public String save(Stock stock, @RequestParam("idProduct") Integer idProduct) {
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("inventario");
        Product product = new Product();
        product.setId(idProduct);
        stock.setProduct(product);
        stockService.saveStock(validateStock.calculateBalance(stock));

        return "redirect:/admin/products/show";
    }
}
