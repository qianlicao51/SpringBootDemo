package com.example.demo02.dao;

import com.example.demo02.bean.Dic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DicRepository extends JpaRepository<Dic,Integer> {
}
