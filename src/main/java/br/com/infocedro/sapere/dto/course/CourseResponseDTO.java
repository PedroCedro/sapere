package br.com.infocedro.sapere.dto.course;

public record CourseResponseDTO(
        Long id,
        String title,
        String description,
        boolean published) {
}