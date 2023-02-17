package fr.epita.movies.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movies")

public class Movie {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "director")
    private String director;
    @Column(name = "poster")
    private String poster;
    @Column(name = "release")
    private Date release;
    @Column(name = "description")
    private String description;

    public Movie(Long id, String name, String category, String director,String poster, String description, Date release) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.director = director;
        this.poster = poster;
        this.description = description;
        this.release = release;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", poster='" + poster + '\'' +
                ", release=" + release +
                ", description='" + description + '\'' +
                '}';
    }
}
