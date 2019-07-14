package com.javalemon.guide;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.service.MessageService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuideApplicationTests {

	@Resource
	MessageService messageService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddMessage() {
		Result result = messageService.addMessage(MessageDTO.builder()
				.content("测试1")
				.sendUserId(1)
				.sendUserName("lemon")
				.receiveUserId(2)
				.createTime(new Date())
				.build());
		System.out.println(result.toString());
	}

	@Test
	public void testListMessage() {
		Result result = messageService.listMessage(2);
		System.out.println(result.toString());
	}

}
