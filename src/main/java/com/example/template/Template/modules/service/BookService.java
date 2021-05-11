package com.example.template.Template.modules.service;

import com.example.template.Template.modules.data.DAOBook;
import com.example.template.Template.modules.data.UsersBook;
import com.example.template.Template.modules.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //Buscar libro por titulo o categoria.
    public DAOBook findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<DAOBook> findByCategory(String category){
        return this.bookRepository.findAllByCategory(category);
    }

    //Funciones:

    //Como USER:
    //Una para pedir prestados libros como usuario (si la cantidad lo permite)
    public DAOBook borrowBook(Long id){
        DAOBook result = bookRepository.findById(id).orElse(null);

        if (result.getQuantity() > 0){
            result.setQuantity(result.getQuantity() - 1);

            return this.bookRepository.save(result);
        }else
            return null;
    }

    //Una para devolver los libros prestados.
    public void returnBook(Long id){
        DAOBook daoBook= this.bookRepository.findById(id).orElse(null);
        daoBook.setQuantity(daoBook.getQuantity() + 1);
    }

    //Como ADMIN:
    //Agregar libros.
    public DAOBook addBook(DAOBook book){
        return bookRepository.save(book);
    }
    //Borrar libros.
    public boolean deleteBook(Long id){
        try{
            bookRepository.deleteById(id);
            return true;
        }
            catch(Exception e){
            return false;
        }
    }
    //Filtrar libros por disponible/no disponible y/o ordenado por cantidad, titulo, autor o categoria.


}
