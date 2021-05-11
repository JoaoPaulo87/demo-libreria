package com.example.template.Template.modules.repository;

import com.example.template.Template.modules.data.UsersBook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BorrowedRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<UsersBook> getData(HashMap<String, Object> conditions){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsersBook> query= cb.createQuery(UsersBook.class);
        Root<UsersBook> root = query.from(UsersBook.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "id":
                    predicates.add(cb.equal (root.get(field), (Integer)value));
                    break;
                case "id_book":
                    predicates.add(cb.equal (root.get(field), (Long)value));
                    break;
                case "id_user":
                    predicates.add(cb.equal (root.get(field), value));
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
