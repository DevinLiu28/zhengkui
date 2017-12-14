package com.lanou3g.game;

public class Rank {
    private String nickname;
    private String score;

    @Override
    public String toString() {
        return "Rank{" +
                "user='" + nickname + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getUser() {
        return nickname;
    }

    public void setUser(String user) {
        this.nickname = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
