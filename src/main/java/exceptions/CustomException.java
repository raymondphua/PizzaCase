package exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Raymond Phua on 10-11-2016.
 */
@Data
@AllArgsConstructor
public class CustomException extends Exception {

    private static final long serialVersionUID = -923394585528818428L;
    private String errorCode;
    private String errorMessage;
}
