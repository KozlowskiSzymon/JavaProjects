package io.github.mat3e.lang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class LangService {

    private LangRepository repository;

    LangService(LangRepository repository) {
        this.repository = repository;
    }

    List<LangDTO> findAll(){

        List<LangDTO> listToTransfer = new ArrayList<>();
        var results = repository.findAll();
        for (Lang lang: results){
            listToTransfer.add(new LangDTO(lang));
        }
        return listToTransfer;
    }
}
