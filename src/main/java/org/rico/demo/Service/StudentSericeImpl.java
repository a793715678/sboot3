package org.rico.demo.Service;

import org.rico.demo.domain.Student;
import org.rico.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Rico.Chen on 2017/2/23.
 */
@Service
@Transactional
public class StudentSericeImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return this.studentRepository.findStudent(id);
    }
}
