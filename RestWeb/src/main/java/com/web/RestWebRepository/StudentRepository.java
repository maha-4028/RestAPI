package com.web.RestWebRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.RestWebModel.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
