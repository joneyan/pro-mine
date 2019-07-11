package com.jone.pro.admin;

import com.jone.pro.admin.rocketmq.Foo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication()
@EnableAspectJAutoProxy
@ComponentScan(value = "com.**")
@MapperScan("com.jone.pro.mapper")
public class ProAdminApplication {


	/*public interface MySource {
		@Output("output1")
		MessageChannel output1();

		@Output("output2")
		MessageChannel output2();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(ProAdminApplication.class, args);
	}


	/*@Bean
	public CustomRunner customRunner() {
		return new CustomRunner();
	}

	public static class CustomRunner implements CommandLineRunner {
		@Autowired
		private SenderService senderService;

		@Override
		public void run(String... args) throws Exception {
			int count = 5;
			for (int index = 1; index <= count; index++) {
				String msgContent = "msg-" + index;
				if (index % 3 == 0) {
					senderService.send(msgContent);
				}
				else if (index % 3 == 1) {
					senderService.sendWithTags(msgContent, "tagStr");
				}
				else {
					senderService.sendObject(new Foo(index, "foo"), "tagObj");
				}
			}
		}
	}

	public static class CustomRunnerWithTransactional implements CommandLineRunner {
		@Autowired
		private SenderService senderService;

		@Override
		public void run(String... args) throws Exception {
			// COMMIT_MESSAGE message
			senderService.sendTransactionalMsg("transactional-msg1", 1);
			// ROLLBACK_MESSAGE message
			senderService.sendTransactionalMsg("transactional-msg2", 2);
			// ROLLBACK_MESSAGE message
			senderService.sendTransactionalMsg("transactional-msg3", 3);
			// COMMIT_MESSAGE message
			senderService.sendTransactionalMsg("transactional-msg4", 4);
		}
	}*/
}
