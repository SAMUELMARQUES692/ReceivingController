package dev.samuel.ReceivingController.infra.presentation;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.usecases.AtualizarRecebimentoCase;
import dev.samuel.ReceivingController.core.usecases.BuscarRecebimentoCase;
import dev.samuel.ReceivingController.core.usecases.BuscarRecebimentoPorIdCase;
import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCase;
import dev.samuel.ReceivingController.infra.dto.ReceivingDTO;
import dev.samuel.ReceivingController.infra.mapper.ReceivingMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/receiving")
public class ReceivingController {

    private final CadastrarRecebimentoCase cadastrarRecebimentoCase;
    private final BuscarRecebimentoCase buscarRecebimentoCase;
    private final BuscarRecebimentoPorIdCase buscarRecebimentoPorIdCase;
    private final AtualizarRecebimentoCase atualizarRecebimentoCase;
    private final ReceivingMapper receivingMapper;

    @PostMapping
    public ResponseEntity<ReceivingDTO> cadastrarRecebimento(@RequestBody ReceivingDTO receivingDTO) {
        Receiving novoRecebimento = cadastrarRecebimentoCase.execute(receivingMapper.toDomain(receivingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(receivingMapper.toDto(novoRecebimento));
    }

    @GetMapping
    public ResponseEntity<List<ReceivingDTO>> buscarRecebimento(){
       List<Receiving> recebimentos = buscarRecebimentoCase.execute();
       List<ReceivingDTO> dtos = receivingMapper.toDtoList(recebimentos);
       return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Receiving buscarRecebimentoId = buscarRecebimentoPorIdCase.execute(id);

        if (buscarRecebimentoId != null) {
            ReceivingDTO buscaConvertida = receivingMapper.toDto(buscarRecebimentoId);
            return ResponseEntity.ok(buscaConvertida);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recebimento com ID " + id + " não existe em nossos registros");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceivingDTO> atualizarRecebimento(@PathVariable Long id, @RequestBody @Valid ReceivingDTO receivingDTO) {
       Receiving converter = receivingMapper.toDomain(receivingDTO);
       Receiving atualizarRecebimento = atualizarRecebimentoCase.execute(id, converter);
       return ResponseEntity.ok(receivingMapper.toDto(atualizarRecebimento));
    }



}

