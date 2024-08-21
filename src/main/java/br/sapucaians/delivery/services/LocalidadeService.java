package br.sapucaians.delivery.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sapucaians.delivery.dto.LocalidadeDTO;
import br.sapucaians.delivery.model.LocalidadeModel;
import br.sapucaians.delivery.repository.LocalidadeRepository;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;


    private ModelMapper mapper = new ModelMapper();

    public LocalidadeDTO create(LocalidadeModel model) {
        return mapper.map(repository.save(model), LocalidadeDTO.class);
    }

    public LocalidadeDTO update(Long id, LocalidadeDTO model){
        Optional<LocalidadeModel> model_ = repository.findById(id);

        if(model_.isPresent()){
            LocalidadeModel model2 = LocalidadeModel.builder()
            .id(model_.get().getId())
            .name(model.getName())
            .price(model.getPrice()).build();

            return mapper.map(repository.save(model2), LocalidadeDTO.class);
        }

        throw new RuntimeException("Localidade com ID: %n não encontrado!!!".formatted(id));
    }


    public void delete(Long id){
        Optional<LocalidadeModel> model_ = repository.findById(id);

        if(model_.isPresent()){
            repository.deleteById(model_.get().getId());
            return;
        }

        throw new RuntimeException("Localidade com ID: %n não encontrado!!!".formatted(id));
    }

    public LocalidadeDTO getById(Long id){
        Optional<LocalidadeModel> model = repository.findById(id);

        if(model.isPresent()){
            return mapper.map(model.get(), LocalidadeDTO.class);
        }

        throw new RuntimeException("Localidade com ID: %n não encontrado!!!".formatted(id));
    }

    public List<LocalidadeDTO> getAll(){
        return repository.findAll().stream().map(l -> mapper.map(l, LocalidadeDTO.class)).toList();
    }
}
