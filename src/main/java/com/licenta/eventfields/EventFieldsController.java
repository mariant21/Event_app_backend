package com.licenta.eventfields;

import com.licenta.exceptions.ResourceNotFoundException;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
public class EventFieldsController {

    @Autowired
    private EventFieldsRepository   eventFieldsRepository;
    //get events
    @GetMapping("event")
    public List<EventFields>  getAllEvent(){

        return this.eventFieldsRepository.findAll();
    }
    //get event by id
    @GetMapping("getEvent/{id}")
    public ResponseEntity<EventFields> getFieldsById(@PathVariable(value = "id") Long eventId)
        throws ResourceNotFoundException{
        EventFields event =eventFieldsRepository.findById(eventId)
                .orElseThrow(()-> new ResourceNotFoundException("Event not found for this id ::" + eventId));
                return ResponseEntity.ok().body(event);
    }

    //save event
    @PostMapping("event")
    public EventFields createEvent(@RequestBody EventFields eventFields){
        return this.eventFieldsRepository.save(eventFields);
    }

    //update event
    @PostMapping("events/{id}")
    public ResponseEntity<EventFields> updateEvent(@PathVariable(value = "id") Long  eventId,
                                                    @RequestBody EventFields eventDetails) throws ResourceNotFoundException{
        EventFields eventFields = eventFieldsRepository.findById(eventId)
                .orElseThrow(()-> new ResourceNotFoundException("Event not found for this id ::" + eventId));
        eventFields.setTitle(eventDetails.getTitle());
        eventFields.setDescription(eventDetails.getDescription());
        eventFields.setBeginDate(eventDetails.getBeginDate());
        eventFields.setEndDate(eventDetails.getEndDate());
        eventFields.setPrice(eventDetails.getPrice());
        eventFields.setPicture(eventDetails.getPicture());

        final EventFields updatedEvent = eventFieldsRepository.save(eventFields);
        return ResponseEntity.ok(updatedEvent);
    }

    //delete event
    @DeleteMapping("events/{id}")
    public Map<String, Boolean> deleteEvents(@PathVariable(value = "id") Long eventId)
            throws ResourceNotFoundException{
        EventFields eventFields = eventFieldsRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id ::" + eventId));

            eventFieldsRepository.delete(eventFields);

            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

            return response;

    }
}
