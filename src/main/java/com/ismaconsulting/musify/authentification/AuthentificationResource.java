package com.ismaconsulting.musify.authentification;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ismaconsulting.musify.entities.Customer;
import com.ismaconsulting.musify.repositories.UserRepository;
import com.ismaconsulting.musify.utils.Security;

@RestController
public class AuthentificationResource {

    private static final int UNAUTHORIZED = 401;
    private static final int SUCCESS = 200;
    private final UserRepository userRepository;

    @Inject
    public AuthentificationResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("authentication/add")
    public Response addUser(@RequestBody final Customer user) throws NoSuchAlgorithmException {

        user.setPassword(Security.hashMD5(user.getPassword()));
        userRepository.save(user);
        return Response.status(SUCCESS).entity("user creation success").build();

    }

    @GetMapping("authentication/check")
    public Response checkAuthentication(final String login, final String password) throws NoSuchAlgorithmException {
        final Optional<Customer> customerOp = userRepository.findById(login);
        if (customerOp.isPresent()) {
            final Customer customer = customerOp.get();
            if (Objects.equals(customer.getPassword(), Security.hashMD5(password))) {
                return Response.status(SUCCESS).entity("authentication success").build();
            } else {
                return Response.status(UNAUTHORIZED).entity("incorrect password").build();
            }
        }
        return Response.status(UNAUTHORIZED).entity("login incorrect").build();
    }

}
