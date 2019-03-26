package com.example.springbookscrudapp.service;

import java.util.Set;
/**
 * @author platoiscoding.com
 */
public interface CrudService<T, ID> {
    /**
     * GET all Objects from DB
     * @return all Objects from Database
     */
    Set<T> getAll();

    /**
     * finds an Object by its ID
     * @param id    Database ID of Object
     * @return      Object
     */
    T findById(ID id);

    /**
     * creates new Object and saves it in Database
     * @param tDetails   field values
     * @return           new Object
     */
    Long create(T tDetails);

    /**
     * updates Object from Database with field values in taskDetails
     * @param id        Database ID of Object
     * @param tDetails  field values
     * @return          updated Object
     */
    void update(ID id, T tDetails);

    /**
     * deletes Object from Database
     * @param id    Database ID of Object
     */
    void delete(ID id);
}
