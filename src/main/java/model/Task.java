package model;

import java.util.Date;

public class Task {
    private Integer id;

    private String taskTitle;

    private String taskDecription;

    private Integer problemSquareId;

    private Integer pulisherId;

    private Date pulishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public String getTaskDecription() {
        return taskDecription;
    }

    public void setTaskDecription(String taskDecription) {
        this.taskDecription = taskDecription == null ? null : taskDecription.trim();
    }

    public Integer getProblemSquareId() {
        return problemSquareId;
    }

    public void setProblemSquareId(Integer problemSquareId) {
        this.problemSquareId = problemSquareId;
    }

    public Integer getPulisherId() {
        return pulisherId;
    }

    public void setPulisherId(Integer pulisherId) {
        this.pulisherId = pulisherId;
    }

    public Date getPulishTime() {
        return pulishTime;
    }

    public void setPulishTime(Date pulishTime) {
        this.pulishTime = pulishTime;
    }
}