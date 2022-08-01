package pojos;
public class Registrant {
    private String createdBy;
    private String createdDate;
    private String email;
    private String firstName;
    private int id;
    private String imageUrl;
    private String langKey;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String lastName;
    private String login;
    private String password;
    private String ssn;
    //Pojo: constructors / getters and setters / toString
    public Registrant() {
    }
    public Registrant(String email, String firstName, String langKey, String lastName, String login, String password, String ssn) {
        this.email = email;
        this.firstName = firstName;
        this.langKey = langKey;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.ssn = ssn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getLangKey() {
        return langKey;
    }
    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String toString() {
        return "Registrant{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", langKey='" + langKey + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}