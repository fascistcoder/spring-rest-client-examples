package com.example.spingrestclient.services;

import api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/12/21
 */
public interface ApiService {
    List<User>getUsers(Integer limit);

    Flux<User> getUsers(Mono<Integer> limit);
}
