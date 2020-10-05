package domain;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Use class for user's info & Tweets list.

//The cascade attribute is set to CascadeType.ALL, meaning that all the JPA and Hibernate entity state transitions
// (e.g., persist, merge, remove) are passed from the parent Post entity to the PostComment child entities.

//The orphanRemoval attribute is going to instruct the JPA provider to trigger a remove entity state transition when
// a PostComment entity is no longer referenced by its parent Post entity.

@Entity
@Table(name = "spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpitter", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "email",  unique = true, nullable = false, length = 45)
    private String email;

    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    // LAZY = fetch when needed
    // EAGER = fetch immediately
    @OneToMany (mappedBy = "ownerId")
    private List<Spittle> spittleList = new ArrayList<Spittle>();;     // User's Tweets Object list.

    @Column(name = "description", nullable = false, length = 100)
    private String description;


    // Constructors.
    public Spitter() {
    }

    public Spitter(Long id, String username, String password, String email, String firstName, String lastName, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        spittleList = new ArrayList<Spittle>();
        this.spittleList = null;
        this.description = description;
    }

    public Spitter(String username, String password, String email, String firstName, String lastName, String description) {
        this.id = null;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        spittleList = new ArrayList<Spittle>();
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

    /* [A-Za-z0-9_/.]@[A-Za-z]{2,7}.com */
    public void setEmail(String email) {
            this.email = email;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    // Add a set of tweets.
    public void setSpittleList(ArrayList<Spittle> spittleList) {
            this.spittleList = spittleList;
    }

    // Add single tweet
    public void setSingleSpittle(Spittle spittle){this.spittleList.add(spittle);}

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

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName;}

    public List<Spittle> getSpittleList() { return spittleList; }

    public String getDescription() {
            return description;
    }

    // Class for NULL Checking...
    public boolean valid() {

        if (this.username != null && this.password != null && this.firstName != null &&
                this.lastName != null && this.description != null && this.email != null) {
            return true;
        } else {
            return false;
        }
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
                    ", description='" + description + '\'' +
                    '}';
    }


}
