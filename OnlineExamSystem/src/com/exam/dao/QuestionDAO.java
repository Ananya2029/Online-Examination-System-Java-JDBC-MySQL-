package com.exam.dao;

import com.exam.model.Question;
import com.exam.util.DBConnection;

import java.sql.*;
import java.util.*;

public class QuestionDAO {

    // 🔹 FETCH ALL QUESTIONS
    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM questions";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Question q = new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correct_answer")
                );

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 ADD QUESTION
    public void addQuestion(Question q) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO questions (question, optionA, optionB, optionC, optionD, correct_answer) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getOptionA());
            ps.setString(3, q.getOptionB());
            ps.setString(4, q.getOptionC());
            ps.setString(5, q.getOptionD());
            ps.setString(6, q.getCorrectAnswer());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Question added successfully!");
            } else {
                System.out.println("❌ Failed to add question.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE QUESTION BY ID
    public void deleteQuestion(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM questions WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Question deleted successfully!");
            } else {
                System.out.println("❌ No question found with ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}