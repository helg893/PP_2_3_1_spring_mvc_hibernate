package web.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "длина должна быть от 2 до 30 символов")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "длина должна быть от 2 до 30 символов")
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "поле не должно быть пустым")
    @Email(message = "должен быть корректный адрес e-mail")
    private String email;

    public User() { }
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
