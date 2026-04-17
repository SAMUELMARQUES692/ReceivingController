package dev.samuel.ReceivingController.infra.presentation;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCase;
import dev.samuel.ReceivingController.infra.dto.ReceivingDTO;
import dev.samuel.ReceivingController.infra.mapper.ReceivingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/receiving")
public class ReceivingController {

    private final CadastrarRecebimentoCase cadastrarRecebimentoCase;
    private final ReceivingMapper receivingMapper;

    @PostMapping
    public ResponseEntity<ReceivingDTO> cadastrarRecebimento(@RequestBody ReceivingDTO receivingDTO) {
        Receiving novoRecebimento = cadastrarRecebimentoCase.execute(receivingMapper.toDomain(receivingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(receivingMapper.toDto(novoRecebimento));
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<List<ReceivingDTO>> buscarRecebimento(@PathVariable Long id){

    }*/



}

