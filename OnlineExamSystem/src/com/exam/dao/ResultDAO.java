package com.exam.dao;

import com.exam.model.Result;
import com.exam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResultDAO {

    public void saveResult(Result r) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO results (name, phone, age, score) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, r.getName());
            ps.setString(2, r.getPhone());
            ps.setInt(3, r.getAge());
            ps.setInt(4, r.getScore());

            ps.executeUpdate();

            System.out.println("✅ Result saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}