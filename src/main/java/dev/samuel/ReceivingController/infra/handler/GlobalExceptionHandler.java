package dev.samuel.ReceivingController.infra.handler;

import dev.samuel.ReceivingController.infra.exception.DuplicateReceivingException;
import dev.samuel.ReceivingController.infra.exception.ReceivingNotFoundException;
import dev.samuel.ReceivingController.infra.exception.TicketNotFoundException;
import dev.samuel.ReceivingController.infra.records.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReceivingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ReceivingNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                "RECEIVING_NOT_FOUND",
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DuplicateReceivingException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedTicket(DuplicateReceivingException exception) {
        ErrorResponse error = new ErrorResponse(
                "TICKET_DUPLICATED",
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundTicket(TicketNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                "TICKET_NOT_FOUND",
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }


}