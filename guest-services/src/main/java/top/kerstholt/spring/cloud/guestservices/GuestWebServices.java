package top.kerstholt.spring.cloud.guestservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {
    private final GuestRepository repository;

    public GuestWebServices(GuestRepository repository){
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id){
        // No error handling (no guest found for id) but good enough for demo-purposes.
        return this.repository.findById(id).get();
    }
}
