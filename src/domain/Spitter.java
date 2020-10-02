package domain;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Use class for user's info & Tweets list.
@Entity
@Table(name = "spitter", schema = "spittr_db")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpitter", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @OneToMany
    private List<Spittle> spittleList = new ArrayList<>();;     // User's Tweets list.

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    // Empty constructor.
    public Spitter() {
    }

    // Full constructor.
    public Spitter(Long id, String username, String password, String email, String firstName, String lastName, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        spittleList = new ArrayList<>();
        this.spittleList = null;
        this.description = description;
    }

    // Without id constructor.
    public Spitter(String username, String password, String email, String firstName, String lastName, String description) {
        this.id = null;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        spittleList = new ArrayList<>();
        this.spittleList = null;
        this.description = description;
    }

    // Setters
    // MUST BE UNIQUE.
    public void setId(Long id) { this.id = id; }

    // LENGTH [3-30] chars MUST BE UNIQUE.
    public void setUsername(String username) {
            this.username = username;
    }

    // Max LENGTH [8-32] LIKE [A-Za-z0-9_!@#$]
    public void setPassword(String password) {
            this.password = password;
    }

    // [A-Za-z0-9_/.]@[A-Za-z]{2,7}.com
    public void setEmail(String email) {
            this.email = email;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    // Not null
    public void setSpittleList(ArrayList<Spittle> spittleList) {
            this.spittleList = spittleList;
    }

    //MAX LENGTH [10-128]
    public void setDescription(String description) {
            this.description = description;
    }
        // Getters.

    public Long getId() {
            return id;
    }

    public String getUsername() {
            return username;
    }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public String getFirstName() {
                return firstName;
    }

    public String getLastName() { return lastName; }

    public List<Spittle> getSpittleList() {
            return spittleList;
    }

    public String getDescription() {
            return description;
    }


    @Override
    public String toString() {
            return "Spitter{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", spittleList=" + spittleList +
                    ", description='" + description + '\'' +
                    '}';
    }

    // Class for NULL Checking...
    public boolean checkNull() throws IllegalAccessException {
            for (Field f : getClass().getDeclaredFields()) {
                if (f.get(this) != null)
                    return false;
            }
            return true;
        }

    }
