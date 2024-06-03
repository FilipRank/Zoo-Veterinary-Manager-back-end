package rs.nemamvebsajt.spring_test_project_2.error;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ErrorController {

    Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    public ErrorModel handleException(Exception e, HttpServletRequest request) {
        ErrorModel model = new ErrorModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage(e.getMessage());
        model.setPath(request.getContextPath());
        return model;
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ErrorModel handleHttpMessageConversionException(Exception e, HttpServletRequest request) {
        ErrorModel model = new ErrorModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage("No message available.");
        model.setPath(request.getContextPath());
        logger.error("An exception occurred!", e);
        return model;
    }

}
