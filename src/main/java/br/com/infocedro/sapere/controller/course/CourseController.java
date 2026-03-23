package br.com.infocedro.sapere.controller.course;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.infocedro.sapere.dto.course.CourseCreateDTO;
import br.com.infocedro.sapere.dto.course.CourseResponseDTO;
import br.com.infocedro.sapere.service.course.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<CourseResponseDTO> list() {
        return service.list();
    }
}