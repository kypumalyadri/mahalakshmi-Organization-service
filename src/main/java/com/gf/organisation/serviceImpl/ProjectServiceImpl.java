package com.gf.organisation.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.organisation.entity.Project;
import com.gf.organisation.repository.ProjectRepository;
import com.gf.organisation.service.ProjectService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(@Valid Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProjectById(@Valid Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(@Valid Long id, Project project) {
        Project updateProject = projectRepository.save(project);
        if (updateProject != null) {
            return updateProject;
        } else {
            throw new RuntimeException("Failed to update project");
        }
    }

    @Override
    public Project deleteProject(@Valid Long id) {
        Optional<Project> deleteProject = projectRepository.findById(id);
        if (deleteProject.isPresent()) {
            projectRepository.delete(deleteProject.get());
            return deleteProject.get();
        } else {
            throw new RuntimeException("Project not found");
        }
    }
}
