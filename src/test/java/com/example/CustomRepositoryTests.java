package com.example;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.persistence.CustomCrudRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CustomRepositoryTests {
	
	@Autowired
	CustomCrudRepository customCrudRepository;
	
//	@Test
//	public void test1() {
//		Pageable pageable = PageRequest.of(0, 10, Direction.DESC, "bno");
//		
//		String type = "t";
//		String keyword = "10";
//		
//		Page<Object[]> result = customCrudRepository.getCustomPage(type, keyword, pageable);
//		
//		log.info("" + result);
//		log.info("Total pages : " + result.getTotalPages()); // 전체 페이지 수 
//		log.info("Total size : " + result.getTotalElements()); // 전체 데이터 수
//		
//		result.getContent().forEach(arr -> {
//			log.info(Arrays.toString(arr));
//		});
//	}
	
	@Test
	public void testWriter() {
		
		Pageable pageable = PageRequest.of(0, 10, Direction.DESC, "bno");
		
		String type = "w";
		String keyword = "user09";
		
		Page<Object[]> result = customCrudRepository.getCustomPage(type, keyword, pageable);

		System.out.println("result : " + result);
		
		log.info("" + result);
		log.info("TOTAL PAGES" + result.getTotalPages());
		log.info("TOTAL SIZE" + result.getTotalElements());
		
		result.getContent().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
}
