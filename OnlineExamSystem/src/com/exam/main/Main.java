package com.exam.main;

import com.exam.dao.QuestionDAO;
import com.exam.dao.ResultDAO;
import com.exam.model.Question;
import com.exam.model.Result;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static QuestionDAO dao = new QuestionDAO();
    static ResultDAO resultDAO = new ResultDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== ONLINE EXAM SYSTEM =====");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Select Role: ");

            int role = sc.nextInt();

            switch (role) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    takeExam();
                    System.exit(0); // Exit after exam
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    // 🔐 ADMIN MENU
    public static void adminMenu() {

        while (true) {
            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1. Add Question");
            System.out.println("2. Delete Question");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    deleteQuestion();
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    // ➕ ADD QUESTION
    public static void addQuestion() {
        sc.nextLine(); // clear buffer

        System.out.print("Enter Question: ");
        String q = sc.nextLine();

        System.out.print("Option A: ");
        String a = sc.nextLine();

        System.out.print("Option B: ");
        String b = sc.nextLine();

        System.out.print("Option C: ");
        String c = sc.nextLine();

        System.out.print("Option D: ");
        String d = sc.nextLine();

        String correct;
        while (true) {
            System.out.print("Correct Answer (A/B/C/D): ");
            correct = sc.next().toUpperCase();

            if (correct.matches("[ABCD]")) break;
            else System.out.println("❌ Invalid input!");
        }

        Question question = new Question(q, a, b, c, d, correct);
        dao.addQuestion(question);
    }

    // ❌ DELETE QUESTION
    public static void deleteQuestion() {

        // Show all questions first (helpful for user)
        List<Question> list = dao.getAllQuestions();

        if (list.isEmpty()) {
            System.out.println("⚠ No questions available to delete!");
            return;
        }

        System.out.println("\nAvailable Questions:");
        for (Question q : list) {
            System.out.println(q.getId() + " - " + q.getQuestion());
        }

        System.out.print("Enter Question ID to delete: ");
        int id = sc.nextInt();

        dao.deleteQuestion(id);
    }

    // 🎓 STUDENT EXAM
    public static void takeExam() {

        sc.nextLine(); // clear buffer

        // 🔹 Student Details
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        List<Question> questions = dao.getAllQuestions();

        if (questions.isEmpty()) {
            System.out.println("⚠ No questions available!");
            return;
        }

        int score = 0;

        System.out.println("\n===== STARTING EXAM =====");

        for (Question q : questions) {

            System.out.println("\n" + q.getQuestion());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());

            String ans;
            while (true) {
                System.out.print("Your Answer: ");
                ans = sc.next().toUpperCase();

                if (ans.matches("[ABCD]")) break;
                else System.out.println("❌ Invalid input!");
            }

            if (ans.equals(q.getCorrectAnswer())) {
                score++;
            }
        }

        System.out.println("\n✅ Exam Finished!");
        System.out.println("Score: " + score + "/" + questions.size());

        // 🔹 Save result
        Result result = new Result(name, phone, age, score);
        resultDAO.saveResult(result);
    }
}