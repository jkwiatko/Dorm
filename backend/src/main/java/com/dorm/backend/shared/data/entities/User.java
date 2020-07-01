package com.dorm.backend.shared.data.entities;

import com.dorm.backend.shared.data.entities.base.BaseEntity;
import com.dorm.backend.shared.data.enums.EGender;
import com.dorm.backend.shared.data.enums.EUserCharacteristic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User extends BaseEntity {

    private List<Room> ownedRooms;
    private List<Picture> profilePictures;
    private List<String> interests;
    private List<EUserCharacteristic> inclinations;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private String description;
    private boolean active;
    private EGender gender;
    private String workingIn;
    private String studyingAt;
    private String cleaningPolicy;
    private String smokingPolicy;
    private String petPolicy;
    private String guestsPolicy;

    @OneToMany(mappedBy = "owner")
    public List<Room> getOwnedRooms() {
        return ownedRooms;
    }

    public void setOwnedRooms(List<Room> ownedRooms) {
        this.ownedRooms = ownedRooms;
    }

    @OneToMany(mappedBy = "ofUser", cascade = CascadeType.ALL)
    public List<Picture> getProfilePictures() {
        return profilePictures;
    }

    public void setProfilePictures(List<Picture> profilePictures) {
        this.profilePictures = profilePictures;
    }

    @ElementCollection
    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = EUserCharacteristic.class)
    public List<EUserCharacteristic> getInclinations() {
        return inclinations;
    }

    public void setInclinations(List<EUserCharacteristic> inclinations) {
        this.inclinations = inclinations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Enumerated(value = EnumType.STRING)
    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getWorkingIn() {
        return workingIn;
    }

    public void setWorkingIn(String workingIn) {
        this.workingIn = workingIn;
    }

    public String getStudyingAt() {
        return studyingAt;
    }

    public void setStudyingAt(String studyingAt) {
        this.studyingAt = studyingAt;
    }

    public String getCleaningPolicy() {
        return cleaningPolicy;
    }

    public void setCleaningPolicy(String cleaningPolicy) {
        this.cleaningPolicy = cleaningPolicy;
    }

    public String getSmokingPolicy() {
        return smokingPolicy;
    }

    public void setSmokingPolicy(String smokingPolicy) {
        this.smokingPolicy = smokingPolicy;
    }

    public String getPetPolicy() {
        return petPolicy;
    }

    public void setPetPolicy(String petPolicy) {
        this.petPolicy = petPolicy;
    }

    public String getGuestsPolicy() {
        return guestsPolicy;
    }

    public void setGuestsPolicy(String guestsPolicy) {
        this.guestsPolicy = guestsPolicy;
    }
}
