package gsfuture.api.exception;

import gsfuture.domain.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> notFound(ResourceNotFoundException ex, HttpServletRequest req) {
        return ResponseEntity.status(404).body(
                new ApiError(
                        LocalDateTime.now(), 404, "Not Found",
                        ex.getMessage(), req.getRequestURI(), null
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex, HttpServletRequest req) {

        List<FieldErrorDetail> fields = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> new FieldErrorDetail(f.getField(), f.getDefaultMessage()))
                .toList();

        return ResponseEntity.status(400).body(
                new ApiError(
                        LocalDateTime.now(), 400, "Bad Request",
                        "Dados inválidos.", req.getRequestURI(), fields
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> generic(Exception ex, HttpServletRequest req) {
        ex.printStackTrace();
        return ResponseEntity.status(500).body(
                new ApiError(
                        LocalDateTime.now(), 500, "Internal Error",
                        ex.getMessage(), req.getRequestURI(), null
                )
        );
    }
}
