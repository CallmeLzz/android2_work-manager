package com.nhom1.mobile.core;

public class Task {
    private int fId;
    public Task(int Id, String Title, String Descript, String Team, String Begin, String End) {
        this.fId = Id;
        this.fTitle = Title;
        this.fDescript = Descript;
        this.fTeam = Team;
        this.fBegin = Begin;
        this.fEnd = End;
    }

    public Task() {
        this.fId = -1;
        this.fTitle = "";
        this.fDescript = "";
        this.fTeam = "";
        this.fBegin = "";
        this.fEnd = "";
    }

    public int getId() {
        return fId;
    }

    public void setId(int fId) {
        this.fId = fId;
    }

    public String getTitle() {
        return fTitle;
    }

    public void setTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getDescript() {
        return fDescript;
    }

    public void setDescript(String fDescript) {
        this.fDescript = fDescript;
    }

    public String getTeam() {
        return fTeam;
    }

    public void setTeam(String fTeam) {
        this.fTeam = fTeam;
    }

    public String getBegin() {
        return fBegin;
    }

    public void setBegin(String fBegin) {
        this.fBegin = fBegin;
    }

    public String getEnd() {
        return fEnd;
    }

    public void setEnd(String fEnd) {
        this.fEnd = fEnd;
    }

    private String fTitle;
    private String fDescript;
    private String fTeam;
    private String fBegin;
    private String fEnd;

}
