package com.bulamen7.shop.model.user;

import javax.validation.constraints.Pattern;
import java.util.Objects;

public class RegistrationForm {
    private String name;
    private String login;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    private String email;
    private String repeatedPassword;

    public RegistrationForm() {
    }

    public RegistrationForm(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            this.repeatedPassword = repeatedPassword;
        }
        throw new IllegalArgumentException("Password isnt same");
    }

    @Override
    public String toString() {
        return "NewUserForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationForm that = (RegistrationForm) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(repeatedPassword, that.repeatedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, login, password, repeatedPassword);
    }
}
