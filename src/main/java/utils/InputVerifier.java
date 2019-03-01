package utils;

public class InputVerifier {
    public Boolean verifyPassword(String password) {
        if (password.length() < 6 || password.length() > 50) return false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (!(Character.isDigit(ch) || Character.isAlphabetic(ch) || isAllowedSpecialChar(ch))) {
                return false;
            }
        }

        return true;
    }
    private Boolean isAllowedSpecialChar(char ch) {
        char[] allowed = { '.', '-', '_', '+', '!', '?', '=' };
        for (char allowedChar : allowed) {
            if (ch == allowedChar) return true;
        }
        return false;
    }

    public boolean verifyInitials(String ini) {
        // 2 .. 4
        return ini.length() >= 2 && ini.length() <= 4;
    }

    public boolean verifyUsername(String username) {
        // minimum 2.. maks 20
        return username.length() >= 2 && username.length() <= 20;
    }
}
