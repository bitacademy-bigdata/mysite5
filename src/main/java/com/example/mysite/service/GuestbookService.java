package com.example.mysite.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysite.domain.Guestbook;
import com.example.mysite.repository.GuestbookRepository;

@Service
@Transactional
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public List<Guestbook> getMessageList() {
		//return guestbookRepository.findAllByOrderByRegDateDesc();
		return guestbookRepository.findAll(new Sort(Sort.Direction.DESC, "regDate"));
	}
	
	public List<Guestbook> getMessageList( Long startNo ) {
		return null; //guestbookRepository.findAll( startNo );
	}	
	
	public boolean deleteMessage( Guestbook guestbook ){
		guestbookRepository.delete( guestbook );
		return true;
	}
	
	public void writeMessage( Guestbook guestbook ) {
		guestbook.setRegDate( new Date() );
		guestbookRepository.save(guestbook);
	}
}