package com.codegym.model;

public class Mail {
    private String languages;
    private String pageSizes;
    private boolean spamsFilter;
    private String Signature;

    public Mail() {
    }

    public Mail(String languages, String pageSizes, boolean spamsFilter, String signature) {
        this.languages = languages;
        this.pageSizes = pageSizes;
        this.spamsFilter = spamsFilter;
        Signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(String pageSizes) {
        this.pageSizes = pageSizes;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
