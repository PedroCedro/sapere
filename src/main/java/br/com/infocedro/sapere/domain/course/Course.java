package br.com.infocedro.sapere.domain.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean published;

    public Course(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Título obrigatório");       }
        this.title = title;
        this.description = description;
        this.published = false;
    }

    public void updateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Título inválido");
        }
        this.title = title;
    }

    public void updateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descrição inválida");
        }
        this.description = description;
    }

    public void publish() {
        if  (this.title == null || this.title.isBlank()) {
            throw new IllegalStateException("Título obrigatório para publicar");
        }
        this.published = true;
    }
}