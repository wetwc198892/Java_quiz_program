package com.example.week3day5.dao;

import com.example.week3day5.config.MySqlDS;
import com.example.week3day5.entity.Choice;
import com.example.week3day5.entity.Question;
import com.example.week3day5.entity.Quiz;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    public QuizDAO() {
        this.ds = MySqlDS.getDs();
    }

    private static final String SELECT_QUIZ = "select a.id as id,name,a.difficulty as difficulty, a.timeLimit as timeLimit,a.description as description,b.id as questionId,b.Description as questionDescription,c.id as choiceId,c.description as choiceDescription,c.isAnswer as isAnswer from quiztypes a INNER JOIN questions b on a.id=b.quizTypeId INNER JOIN choices c on b.id = c.questionId where a.id=? ORDER BY  RAND() LIMIT 10";
    private static final String SELECT_ALL_QUIZ = "select * from quiztypes";

    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = null;
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_ALL_QUIZ);
            rs = ps.executeQuery();
            quizzes = new ArrayList<>();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setTimeLimit(rs.getInt("timeLimit"));
                quiz.setName(rs.getString("name"));
                quiz.setDifficulty(rs.getInt("difficulty"));
                quiz.setId(rs.getInt("id"));
                quiz.setDescription(rs.getString("description"));
                quizzes.add(quiz);
            }
            return quizzes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quizzes;
    }


    public Quiz getQuiz(int id) {
        Quiz quiz = new Quiz();
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_QUIZ);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Question question = null;
            Choice choice;
            while (rs.next()) {
                if (quiz.getDescription() == null) quiz.setDescription(rs.getString("description"));
                if (quiz.getId() == 0) quiz.setId(rs.getInt("id"));
                if (quiz.getName() == null) quiz.setName(rs.getString("name"));
                if (quiz.getDifficulty() == 0) quiz.setDifficulty(rs.getInt("difficulty"));
                if (quiz.getTimeLimit() == 0) quiz.setTimeLimit(rs.getInt("timeLimit"));
                int questionId = rs.getInt("questionId");
                if (question == null) {
                    question = new Question();
                    question.setId(questionId);
                    question.setDescription(rs.getString("questionDescription"));
                }
                choice = new Choice();
                choice.setId(rs.getInt("choiceId"));
                choice.setAnswer(rs.getShort("isAnswer"));
                choice.setDescription(rs.getString("choiceDescription"));
                if (questionId != question.getId()) {
                    quiz.getQuestions().add(question);
                    question = new Question();
                    question.setId(questionId);
                    question.setDescription(rs.getString("questionDescription"));
                }
                question.getChoices().add(choice);
            }
            quiz.getQuestions().add(question);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quiz;
    }
}
