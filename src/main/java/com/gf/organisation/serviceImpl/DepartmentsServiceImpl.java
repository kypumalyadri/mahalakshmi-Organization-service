package com.gf.organisation.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.Departments;
import com.gf.organisation.repository.DepartmentsRepository;
import com.gf.organisation.service.DepartmentsService;



@Service
@Transactional
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Override
    public Departments createDepartments(@Valid Departments departments) {
        return departmentsRepository.save(departments);
    }

    @Override
    public Optional<Departments> getByDepartmentId(@Valid Long id) {
        return departmentsRepository.findById(id);
    }

    @Override
    public List<Departments> getAllDepartments() {
        return departmentsRepository.findAll();
    }

    @Override
    public Departments updateDepartments(@Valid Departments departments) {
        if (departmentsRepository.existsById(departments.getId())) {
            return departmentsRepository.save(departments);
        } else {
          
            throw new IllegalArgumentException("Department does not exist.");
        }
    }

    @Override
    public Departments deletedDepartmentsById(@Valid long id) {
        Optional<Departments> optionalDepartments = departmentsRepository.findById(id);
        if (optionalDepartments.isPresent()) {
            Departments deletedDepartments = optionalDepartments.get();
            departmentsRepository.deleteById(id);
            return deletedDepartments;
        } else {
           
            throw new IllegalArgumentException("Department does not exist.");
        }
    }
}
