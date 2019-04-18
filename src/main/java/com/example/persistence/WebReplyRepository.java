package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dto.WebBoard;
import com.example.dto.WebReply;

public interface WebReplyRepository extends CrudRepository<WebReply, Long>{
	
	@Query(value = "select * from tbl1_webreplies r where r.board_bno = ?1 and r.rno > 0 order by r.rno asc", nativeQuery = true)
	public List<WebReply> getRepliesOfBoard(WebBoard board);
}
