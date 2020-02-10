package top.kerstholt.spring.cloud.roomreservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * This Feign interface automatically creates a client for the 'roomservices' client
 * through Eureka and Ribbon!
 *
 * The value "roomservices" should match the 'spring.application.name' in the bootstrap.properties
 * of the room-services application (which will be registered under name ROOMSERVICES in Eureka).
 */
@FeignClient("roomservices")
public interface RoomClient {

    @GetMapping("/rooms")
    public List<Room> getAllRooms();

    @GetMapping("/rooms/{id}")
    public List<Room> getRooms(@PathVariable("id") long id);
}
