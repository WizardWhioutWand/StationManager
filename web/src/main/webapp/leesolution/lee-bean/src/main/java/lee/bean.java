package lee;

public class bean {

    public String username;
    public String userkey;

    public bean(String username, String userkey) {
        this.username = username;
        this.userkey = userkey;
    }

    public bean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    @Override
    public String toString() {
        return "bean{" +
                "username='" + username + '\'' +
                ", userkey='" + userkey + '\'' +
                '}';
    }
}
