package sa.gov.sfd.rabbitMQTest;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //------------------- testQueue ----------------------------------------------------------------------------

    @Value(value = "${testQueue.rabbitmq.queue}")
    private String testQueueQueue;
    private final static String testQueueExchange = "testQueue.exchange";
    private final static String testQueueRoutingKey = "testQueue.routingkey";
    private final static String testQueueDLQ = "testQueue.dlq";
    private final static String testQueueDLX = "testQueue.dlx";

    @Bean
    public Queue testQueueQueue() {
        return QueueBuilder
                .durable(testQueueQueue)
                .withArgument("x-dead-letter-exchange", testQueueDLX)
                .build();
    }

    @Bean
    public DirectExchange testQueueExchange() {
        return new DirectExchange(testQueueExchange);
    }

    @Bean
    public Binding testQueueBinding() {
        return BindingBuilder
                .bind(testQueueQueue())
                .to(testQueueExchange())
                .with(testQueueRoutingKey);
    }

    //---- testQueue DeadLetterQueue (dlq) ----

    @Bean
    public Queue testQueueDLQ() {
        return QueueBuilder
                .durable(testQueueDLQ)
                .build();
    }

    @Bean
    public FanoutExchange testQueueDLX() {
        return new FanoutExchange(testQueueDLX);
    }

    @Bean
    public Binding leaveLawsApprovalDLQBinding() {
        return BindingBuilder
                .bind(testQueueDLQ())
                .to(testQueueDLX());
    }

    //------------------- Message Converter ----------------------------------------------------------------------------

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
