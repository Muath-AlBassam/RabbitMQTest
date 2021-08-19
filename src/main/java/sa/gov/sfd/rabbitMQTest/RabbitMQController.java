package sa.gov.sfd.rabbitMQTest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbit")
public class RabbitMQController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitListener(queues = "${testQueue.rabbitmq.queue}")
    public void listen(AttendanceDTO dto) {
        // throw new IllegalArgumentException();
        System.out.println("Recieved data");
        System.out.println(dto.toString());
    }

    @PostMapping("/send")
    public void send(@RequestBody AttendanceDTO dto) {
        System.out.println("Sending data");
        rabbitTemplate.convertAndSend("testQueue.exchange", "testQueue.routingkey", dto);
    }

}