package com.allSales.exceptionHandler;

public class AccessDeniedException extends RuntimeException {
    String link;

    public AccessDeniedException(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
