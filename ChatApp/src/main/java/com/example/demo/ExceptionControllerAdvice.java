package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
class ExceptionControllerAdvice {
	private static Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);

	@SuppressWarnings("unchecked")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<JSONObject> handleValidationExceptions(MethodArgumentNotValidException ex) {
		JSONObject response = new JSONObject();
		JSONArray details = new JSONArray();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			JSONObject detail = new JSONObject();
			try {
				detail.put(((FieldError) error).getField(), error.getDefaultMessage());
				details.add(detail);
			} catch (Exception e) {
				logger.error(e);
			}
		});
		response.put("code", "VALERRCOD");
		response.put("message", "Validation Failed");
		response.put("details", details);

		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
	}

}
