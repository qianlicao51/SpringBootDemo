package com.example.demo01.dao;

import com.example.demo01.bean.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {


}