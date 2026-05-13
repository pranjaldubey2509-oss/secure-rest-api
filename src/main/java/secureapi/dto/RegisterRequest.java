package secureapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {

    @Email
    private String email;

    @Size(min = 6)
    private String password;
}