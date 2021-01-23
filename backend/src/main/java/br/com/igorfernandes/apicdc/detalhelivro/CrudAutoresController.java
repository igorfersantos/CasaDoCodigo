package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
class CrudAutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/api/autores")
    @Transactional
    public void novo(@Valid @RequestBody NovoAutorForm form){
        Autor novoAutor = form.NovoAutor();
        autorRepository.save(novoAutor);
    }
}
