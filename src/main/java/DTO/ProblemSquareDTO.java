package DTO;

import model.ProblemSquare;
import model.User;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class ProblemSquareDTO {

    private ProblemSquare problemSquare;

    private User user ;

    public ProblemSquare getProblemSquare() {
        return problemSquare;
    }

    public void setProblemSquare(ProblemSquare problemSquare) {
        this.problemSquare = problemSquare;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
