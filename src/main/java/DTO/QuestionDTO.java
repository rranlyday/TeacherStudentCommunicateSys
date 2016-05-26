package DTO;


import model.Question;
import model.User;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class QuestionDTO {
    private  Question question;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
