package com.orange.craft.repository;

import com.orange.craft.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpersonRepository extends JpaRepository<Person,Long> {


}
