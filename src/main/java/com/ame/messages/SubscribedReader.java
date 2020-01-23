package com.ame.messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.dsl.kafka.Kafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

@SpringBootApplication
/**
 * Main class for reading a Kafka topic from a java application
 * 
 * @author Antoine Meheut
 * 
 */
public class SubscribedReader {

	@Autowired
	PollableChannel consumerChannel;

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(SubscribedReader.class).run(args);

		List<String> valid_topics = Arrays.asList("AME_AME.IN", "XXX");

		List<String> topics = new ArrayList<String>();
		if (args.length > 0) {
			for (String arg : args) {
				if (valid_topics.contains(arg))
					topics.add(arg);
			}
		}

		context.getBean(SubscribedReader.class).run(context, topics);
		context.close();
	}

	private void run(ConfigurableApplicationContext context, List<String> topics) {

		System.out.println("Start reading alert messages ...");
		PollableChannel consumerChannel = context.getBean("consumerChannel", PollableChannel.class);

		for (String topic : topics)
			addAnotherListenerForTopics(topic);

		Message<?> received = consumerChannel.receive();
		while (received != null) {
			received = consumerChannel.receive();
			System.out.println("Alert received " + received.getPayload());
		}
	}

	@Autowired
	private IntegrationFlowContext flowContext;

	@Autowired
	private KafkaProperties kafkaProperties;

	public void addAnotherListenerForTopics(String... topics) {
		Map<String, Object> consumerProperties = kafkaProperties.buildConsumerProperties();
		IntegrationFlow flow = IntegrationFlows
				.from(Kafka.messageDrivenChannelAdapter(
						new DefaultKafkaConsumerFactory<String, String>(consumerProperties), topics))
				.channel("consumerChannel").get();
		this.flowContext.registration(flow).register();
	}
}
