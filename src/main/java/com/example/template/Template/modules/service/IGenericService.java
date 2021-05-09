package com.example.template.Template.modules.service;

import java.io.IOException;
import java.util.Optional;

public interface IGenericService<T, ID> {

    public T insert(T object) throws Exception;

    public Optional<T> findById(ID id) throws IOException;

    public Iterable<T> findAll() throws IOException;

    public T update(T object) throws Exception;

    public void delete(ID object) throws Exception;

}
