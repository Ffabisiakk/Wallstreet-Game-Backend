package pl.hollow.wallstreet.util;

public enum  ApplicationUserPermission {
    TEMP("TEMP");

    private String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
