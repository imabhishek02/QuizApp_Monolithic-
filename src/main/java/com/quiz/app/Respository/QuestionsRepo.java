package com.quiz.app.Respository;


import com.quiz.app.Entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM questions q WHERE q.category=:category")
    List<Questions> findQuestionsByCategory(String category);
}
