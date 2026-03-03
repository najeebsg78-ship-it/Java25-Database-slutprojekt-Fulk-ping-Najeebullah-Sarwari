package se.najeeb.library.Modell;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String ePost;
    private String password;

    private User(){};

    public User(int userId, String firstName, String lastName, String ePost, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ePost = ePost;
        this.password = password;
    }

    public User(String firstName, String lastName, String ePost, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ePost = ePost;
        this.password = password;
    }

    public int getUserId() {
        return userId;
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

    public String getePost() {
        return ePost;
    }

    public void setePost(String ePost) {
        this.ePost = ePost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ePost='" + ePost + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
