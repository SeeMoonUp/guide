package com.javalemon.guide;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.model.dto.GroupDTO;
import com.javalemon.guide.model.dto.GroupTagDTO;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.model.dto.UserDTO;
import com.javalemon.guide.service.GroupService;
import com.javalemon.guide.service.GroupTagService;
import com.javalemon.guide.service.MessageService;
import com.javalemon.guide.service.UserService;
import com.qiniu.util.Auth;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuideApplicationTests {

	@Resource
	MessageService messageService;

	@Resource
	GroupService groupService;

	@Resource
	GroupTagService groupTagService;

	@Resource
	UserService userService;

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

	@Test
	public void testGroup() {
		Result miss = groupService.addGroup(GroupDTO.builder().createTime(new Date()).userId(2).groupName("miss").sort(1).status(1).build());
		System.out.println(miss);
		Result<List<GroupDTO>> listResult = groupService.listGroup(2);
		System.out.println(listResult);
	}

	@Test
	public void testGroupTag() {
		Result miss = groupTagService.addGroupTag(GroupTagDTO.builder().createTime(new Date()).userId(2).groupName("miss").groupId(1).tagName("wiki").tagLink("https://www.baidu.com/").sort(1).status(1).build());
		System.out.println(miss);
		Result<List<GroupTagDTO>> listResult = groupTagService.listGroupTag(2, 1);
		System.out.println(listResult);
	}

	@Test
	public void addUser() {
		Result result = userService.addUser(UserDTO.builder()
				.createTime(new Date())
				.name("123")
				.email("123")
				.password("123")
				.build()
		);
		System.out.println(result);
	}

	@Test
	public void testGetToken() {
		String accessKey = "CM1Xk5INASWuZfY8AX6f5xOVXx4_MlMo7ETRej-J";
		String secretKey = "1KuZD2XPAHmQRB9072ZsdwmjF1_uHKtdhuTy60wW";
		String bucket = "bit-video";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		System.out.println(upToken);
		System.out.println(UUID.randomUUID().toString());
	}

}
