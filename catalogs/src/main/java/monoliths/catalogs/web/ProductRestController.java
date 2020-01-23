package monoliths.catalogs.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import monoliths.catalogs.domain.usecase.Catalogs;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductRestController {

    private Catalogs catalogs;
    
}