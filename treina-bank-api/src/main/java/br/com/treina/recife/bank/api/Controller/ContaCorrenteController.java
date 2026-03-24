package br.com.treina.recife.bank.api.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas-correntes")
public class ContaCorrenteController {

    @Autowired
    private COntaCorrenteService contaCorrentService;

    
    
}
