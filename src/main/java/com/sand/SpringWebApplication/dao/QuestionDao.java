package com.sand.SpringWebApplication.dao;

import com.sand.SpringWebApplication.objectRelationalMapping.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {
    //This is called HibernateQueryLanguage
    List<Questions> findByCategory(String category);

    List<Questions> findByDifficultylevel(String difficultyLevel);
}
