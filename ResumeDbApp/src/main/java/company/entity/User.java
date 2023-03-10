package company.entity;

import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String profileDesc;
    private String phone;
    private Date birthDate;
    private Country country;
    private Country birthPlace;
    private List<UserSkill> skills;


    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name,
                String surname, String email, String profileDesc, String phone, Date birthDate,
                Country country, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profileDesc = profileDesc;
        this.phone = phone;
        this.birthDate = birthDate;
        this.country = country;
        this.birthPlace = birthPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return country;
    }

    public void setNationality(Country country) {
        this.country = country;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", country=" + country +
                ", birthPlace=" + birthPlace +
                ", skills=" + skills +
                '}';
    }
}
