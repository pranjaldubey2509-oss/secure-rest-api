package secureapi.service;

import secureapi.dto.*;

public interface AuthService {

    String register(RegisterRequest request);

    String login(LoginRequest request);
}