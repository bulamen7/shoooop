package com.bulamen7.shop.model.authentication;

import java.util.Objects;

public class NewPasswordForm {
    private String password;
    private String repeatedPassword;

    public NewPasswordForm() {
    }

    public NewPasswordForm(String newPassword, String repeatedNewPassword) {
        this.password = newPassword;
        this.repeatedPassword = repeatedNewPassword;
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
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public String toString() {
        return "NewPasswordForm{" +
                "newPassword='" + password + '\'' +
                ", repeatedNewPassword='" + repeatedPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewPasswordForm that = (NewPasswordForm) o;
        return Objects.equals(password, that.password) && Objects.equals(repeatedPassword, that.repeatedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, repeatedPassword);
    }
}
