package com.example.mysite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysite.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
	List<Guestbook> findAllByOrderByRegDateDesc();
}
