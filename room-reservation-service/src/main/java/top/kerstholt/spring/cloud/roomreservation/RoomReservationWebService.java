package top.kerstholt.spring.cloud.roomreservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationWebService {

    private final RoomClient roomClient;

    // We don't use RestTemplate, we use Feign
//    private final RestTemplate restTemplate;
//    public RoomReservationWebService(RestTemplate restTemplate){
    public RoomReservationWebService(RoomClient roomClient){
        super();
        this.roomClient = roomClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(){
        List<Room> rooms = this.roomClient.getAllRooms();
        List<RoomReservation> roomReservations = new ArrayList<>();
        rooms.forEach(room->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomId(room.getId());
            roomReservations.add(roomReservation);
        });
        return roomReservations;
    }

    // We don't need this anymore, because we use Feign
//    private List<Room> getAllRooms(){
//        // The room-services application has configured spring.application.name=roomservices in bootstrap.properties.
//        //
//        // In the Eureka dashboard you can see that room-services is registered under name 'ROOMSERVICES'.
//        //
//        // Because of the @EnableDiscoveryClient on the @SpringBootApplication, we can use 'ROOMSERVICES' in the URL below.
//        ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange(
//                "http://ROOMSERVICES/rooms",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Room>>() {});
//        return roomResponse.getBody();
//    }
}
