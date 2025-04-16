import java.util.ArrayList;
import java.util.List;

public class WebApp {
    private List<User> users;

    public WebApp() {
        users = new ArrayList<>();
        users.add(new User("admin", "password123"));
        users.add(new User("user1", "pass1"));
    }

    public boolean vulnerableLogin(String username, String password) {
        if (username.contains("' OR 1=1 --")) {
            System.out.println("SQL Injection detected: bypassing authentication");
            System.out.println("Constructed query would be: SELECT * FROM users WHERE username = '' OR 1=1 --' AND password = '...' (returns all users)");
            return true;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean secureLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String vulnerableComment(String comment) {
        return "<div>" + comment + "</div>";
    }

    public String secureComment(String comment) {
        String escaped = comment.replace("<", "<").replace(">", ">");
        return "<div>" + escaped + "</div>";
    }
}