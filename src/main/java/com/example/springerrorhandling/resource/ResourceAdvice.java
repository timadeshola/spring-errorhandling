package com.example.springerrorhandling.resource;

import com.example.springerrorhandling.core.exceptions.ApiCallException;
import com.example.springerrorhandling.core.exceptions.CustomException;
import com.example.springerrorhandling.core.exceptions.EmailNotFoundException;
import com.example.springerrorhandling.core.exceptions.ServiceException;
import com.example.springerrorhandling.core.exceptions.model.ErrorDetails;
import com.example.springerrorhandling.core.exceptions.model.ValidationError;
import com.example.springerrorhandling.model.response.AppResponse;
import org.modelmapper.MappingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.NestedServletException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 6:09 PM
 */
@RestControllerAdvice
public class ResourceAdvice {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleCustomException(CustomException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value() != 0 ? ex.getStatus().value() : HttpStatus.PRECONDITION_FAILED.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.valueOf(errorDetails.getCode()))
                .error(errorDetails)
                .build());

    }

    @ExceptionHandler(EmailNotFoundException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleEmailNotFoundException(EmailNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.valueOf(errorDetails.getCode()))
                .error(errorDetails)
                .build());

    }

    @ExceptionHandler(ApiCallException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleApiCallException(ApiCallException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.valueOf(errorDetails.getCode()))
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleServiceException(ServiceException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(0)
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(null)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(ex.getStatus())
                .error(errorDetails)
                .build());

    }

    @ExceptionHandler(NoResultException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleNoResultException(NoResultException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.NO_CONTENT)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(ResourceAccessException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleResourceAccessException(ResourceAccessException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMostSpecificCause().getMessage())
                .code(HttpStatus.REQUEST_TIMEOUT.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.REQUEST_TIMEOUT)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(UnknownHostException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleUnknownHostException(UnknownHostException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getCause().getMessage())
                .code(HttpStatus.REQUEST_TIMEOUT.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.REQUEST_TIMEOUT)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(ex.getRawStatusCode())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(errorDetails.getMessage())
                .status(HttpStatus.valueOf(errorDetails.getCode()))
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler({MappingException.class})
    public final ResponseEntity<AppResponse<ErrorDetails>> handleMappingException(MappingException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class, NestedServletException.class})
    public ResponseEntity<AppResponse<ErrorDetails>> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<AppResponse<ErrorDetails>> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<AppResponse<ErrorDetails>> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<AppResponse<ErrorDetails>> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .details(request.getDescription(true))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<AppResponse<List<ErrorDetails>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        List<ValidationError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error ->
                errors.add(ValidationError.builder()
                        .field(((FieldError) error).getField())
                        .rejectedValue(((FieldError) error).getRejectedValue())
                        .objectName(error.getObjectName())
                        .build()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<List<ErrorDetails>>builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(ErrorDetails.builder()
                        .message(ex.getFieldError().getDefaultMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .details(request.getDescription(true))
                        .timestamp(LocalDateTime.now())
                        .validation(errors)
                        .build())
                .message(ex.getFieldError().getDefaultMessage())
                .build());

    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<AppResponse<List<ErrorDetails>>> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        List<ValidationError> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(error ->
                errors.add(ValidationError.builder()
                        .field(error.getPropertyPath().toString())
                        .objectName(error.getPropertyPath().toString())
                        .rejectedValue(error.getInvalidValue().toString())
                        .build()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AppResponse.<List<ErrorDetails>>builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(ErrorDetails.builder()
                        .message(new ArrayList<>(ex.getConstraintViolations()).get(0).getMessageTemplate())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .details(request.getDescription(true))
                        .timestamp(LocalDateTime.now())
                        .validation(errors)
                        .build())
                .message(new ArrayList<>(ex.getConstraintViolations()).get(0).getMessageTemplate())
                .build());

    }

}
