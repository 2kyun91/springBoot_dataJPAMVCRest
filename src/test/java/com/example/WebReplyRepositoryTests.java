package com.example;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.WebBoard;
import com.example.dto.WebReply;
import com.example.persistence.WebReplyRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebReplyRepositoryTests {
	
	@Autowired
	WebReplyRepository webReplyRepository;
	
	@Test
	public void testInsertReplies() {
		Long[] arr = {301L, 302L, 303L};
		
		Arrays.stream(arr).forEach(num -> {
			WebBoard board = new WebBoard();
			board.setBno(num);
			
			IntStream.range(0, 10).forEach(i -> {
				WebReply reply = new WebReply();
				reply.setReplyText("댓글..." + i);
				reply.setReplyer("댓글 작성자..." + i);
				reply.setBoard(board);
				
				webReplyRepository.save(reply);
			});
		});
	}
}
