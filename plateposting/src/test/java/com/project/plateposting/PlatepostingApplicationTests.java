package com.project.plateposting;

import com.project.plateposting.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlatepostingApplicationTests {

	@Test
	void createTable(){
		Member member = Member.builder()
				.name("park").email("a.naver.com").build();
	}

}
