package dev.samuel.ReceivingController.infra.presentation;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.usecases.*;
import dev.samuel.ReceivingController.infra.dto.ReceivingDTO;
import dev.samuel.ReceivingController.infra.mapper.ReceivingMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/receiving")
public class ReceivingController {

    private final CadastrarRecebimentoCase cadastrarRecebimentoCase;
    private final BuscarRecebimentoCase buscarRecebimentoCase;
    private final BuscarRecebimentoPorIdCase buscarRecebimentoPorIdCase;
    private final AtualizarRecebimentoCase atualizarRecebimentoCase;
    private final DeletarRecebimentoCase deletarRecebimentoCase;
    private final ReceivingMapper receivingMapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarRecebimento(@RequestBody ReceivingDTO receivingDTO) {
        Receiving novoRecebimento = cadastrarRecebimentoCase.execute(receivingMapper.toDomain(receivingDTO));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do Evento: ", receivingMapper.toDto(novoRecebimento));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ReceivingDTO>> buscarRecebimento(){
       List<Receiving> recebimentos = buscarRecebimentoCase.execute();
       List<ReceivingDTO> dtos = receivingMapper.toDtoList(recebimentos);
       return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceivingDTO> buscarPorId(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(receivingMapper.toDto(buscarRecebimentoPorIdCase.execute(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivingDTO> atualizarRecebimento(@PathVariable Long id, @RequestBody @Valid ReceivingDTO receivingDTO) {
       Receiving converter = receivingMapper.toDomain(receivingDTO);
       Receiving atualizarRecebimento = atualizarRecebimentoCase.execute(id, converter);
       return ResponseEntity.ok(receivingMapper.toDto(atualizarRecebimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecebimento(@PathVariable Long id) {
        deletarRecebimentoCase.execute(id);
        return ResponseEntity.noContent().build();
    }


}

