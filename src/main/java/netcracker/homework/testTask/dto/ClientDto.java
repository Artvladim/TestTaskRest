package netcracker.homework.testTask.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ClientDto {

    @NotBlank(message = "Имя не должно быть пустым")
    @Length(min = 1, max = 20, message = "Длина имени от 1 до 20")
    private String name;

    @NotBlank
    @Length(min = 1, max = 20, message = "Длина имени от 1 до 20")
    private String sureName;

    @NotBlank
    private String gender;

    @NotBlank
    @Min(value = 18, message = "Минимальный возраст клиента = 18 лет")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
