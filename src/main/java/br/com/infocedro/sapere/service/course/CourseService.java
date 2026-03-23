package br.com.infocedro.sapere.service.course;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.infocedro.sapere.domain.course.Course;
import br.com.infocedro.sapere.dto.course.CourseCreateDTO;
import br.com.infocedro.sapere.dto.course.CourseResponseDTO;
import br.com.infocedro.sapere.repository.course.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseResponseDTO create(CourseCreateDTO dto) {
        Course course = new Course(dto.title(), dto.description());
        Course saved = repository.save(course);

        return toResponse(saved);
    }

    public List<CourseResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CourseResponseDTO toResponse(Course course) {
        return new CourseResponseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.isPublished()
        );
    }
}