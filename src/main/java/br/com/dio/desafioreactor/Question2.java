package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {

    /*
    Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */
    public Mono<Long> countAdmins(final List<User> users){
        Long admins = users.stream()
                .filter(User::isAdmin)
                .count();

        return Mono.justOrEmpty(admins)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new NullPointerException("Lista vazia")))
                );
    }

}
