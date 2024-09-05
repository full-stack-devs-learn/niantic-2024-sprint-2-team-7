package com.nianti.services;

import com.nianti.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class QuestionDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Question> getQuestionByQuizId(int quizId) {
        return null;
    }


    public int getTotalNumberOfQuestionsByQuizId(int quizId) {
        String sql = """
                        SELECT COUNT(*) AS total
                        FROM question
                        WHERE quiz_id = ?;
                    """;

        var row = jdbcTemplate.queryForRowSet(sql, quizId);

        if (row.next()) {
            return row.getInt("total");
        }

        return 0;
    }


    public Question getQuestion(int quizId, int questionNumber){
        String sql = """
                SELECT  *
                FROM question
                WHERE quiz_id = ?
                    AND question_number = ?;
           
                """;
        var row = jdbcTemplate.queryForRowSet(sql, quizId, questionNumber);

        if(row.next()){
            return mapRowToQuestion(row);
        }
        return null;
    }


    private Question mapRowToQuestion(SqlRowSet row) {
        int questionId = row.getInt("question_id");
        int quizId = row.getInt("quiz_id");
        int questionNumber = row.getInt("question_number");
        String questionText = row.getString("question_text");


        return new Question(questionId,quizId,questionNumber, questionText);
    }



}
