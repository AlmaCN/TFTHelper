package com.cnade.betfthelper.util;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class Utility {

    public static Specification equalsSpecification(String campo, String valore) {
        return (root, query, cb) -> cb.equal(root.get(campo), valore);
    }
    public static Specification equalsSpecification(String campoId, String campo, Object valore) {
        return (root, query, cb) -> cb.equal(root.get(campoId).get(campo), valore);
    }

    public static Specification betweenSpecification(String campo, String valore1, String valore2) {
        return (root, query, cb) -> cb.between(root.get(campo), valore1, valore2);
    }

    public static Specification inSpecification(String campo, List<String> list) {
        return (root, query, cb) -> cb.in(root.get(campo)).value(list);
    }

}
