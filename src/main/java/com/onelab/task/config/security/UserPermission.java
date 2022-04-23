package com.onelab.task.config.security;

public enum UserPermission {
    AUTHOR_WRITE("author:write"),
    BOOK_WRITE("book:write"),
    GENRE_WRITE("genre:write"),
    BOOK_BUY("book:buy"),
    ANALYSIS_READ("analysis");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
