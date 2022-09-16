package com.training.spring.demo.db;

import com.training.spring.demo.rest.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    List<Person> findByNameAndSurnameOrderByName(String name,
                                                 String surname);

    List<Person> findByNameIn(List<String> names);

    @Query("select p from Person p where p.name=?1")
    List<Person> searchName(String name);

    @Query("select p from Person p where p.name=:xyz")
    List<Person> searchName2(@Param("xyz") String name);

    @Query(value = "select * from personel p where p.desc=?1", nativeQuery = true)
    List<Person> searchNativeName(String name);


}
