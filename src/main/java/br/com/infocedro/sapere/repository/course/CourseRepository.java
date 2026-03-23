package br.com.infocedro.sapere.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.infocedro.sapere.domain.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}   