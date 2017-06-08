package com.test.new_test_project.persistence.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.new_test_project.persistence.entity.BankOfice;

/**
 * Created by aamitreikin on 06.06.17.
 */
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private Boolean activ = true;
    private Long bankOficeId;

    @JsonCreator
    public UserDTO(@JsonProperty("id")Long id,
                    @JsonProperty("lastName")String lastName,
                   @JsonProperty("firstName")String firstName,
                   @JsonProperty("activ")Boolean activ,
                   @JsonProperty("bankOfice")Long bankOfice) {
        this.id=id;
        this.lastName=lastName;
        this.firstName=firstName;
        this.activ=activ;
        this.bankOficeId=bankOfice;
    }

    public UserDTO(Long id, String lastName, String firstName, Boolean activ, BankOfice bankOfice){
        this(id, lastName,firstName,activ, bankOfice.getId());
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getBankOficeId() {
        return bankOficeId;
    }

    public void setBankOficeId(Long bankOficeId) {
        this.bankOficeId = bankOficeId;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (lastName != null ? !lastName.equals(userDTO.lastName) : userDTO.lastName != null) return false;
        return firstName != null ? firstName.equals(userDTO.firstName) : userDTO.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }
}
