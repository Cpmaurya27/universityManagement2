package com.example.universityManagment.controller;

import com.example.universityManagment.model.Event;
import com.example.universityManagment.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    //add event
    @PostMapping("/")
    public String addEvent(@Valid @RequestBody List<Event> events) {
        return eventService.addEvent(events);
    }

    //Get All Event
    @GetMapping(value = "/")
    public List<Event> getAllEvent(){
        return eventService.getAllEvent();
    }

    //get Event by date
    @GetMapping("/date/{date}")
    public List<Event> getEventByDate(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventByDate(localDate);
    }
    //update event
    @PutMapping("/")
    public String updateEventByEventId(@RequestBody Event event){
        return eventService.updateEvent(event);
    }
    //delete event by id
    @DeleteMapping("/{eventId}")
    public String deleteEventByEventId(@PathVariable int eventId){
        return eventService.deleteEventByEventId(eventId);
    }
}
