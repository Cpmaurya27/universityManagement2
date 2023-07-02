package com.example.universityManagment.service;

import com.example.universityManagment.model.Event;
import com.example.universityManagment.repository.IEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventService {
    @Autowired
    IEventDao iEventDao;

    //add event
    public String addEvent(List<Event> events) {
        iEventDao.saveAll(events);
        return "Event Added Successfully!!!!!.....";
    }

    //get All event
    public List<Event> getAllEvent() {
        return iEventDao.findAll();

    }

    //getEvent By date
    public List<Event> getEventByDate(LocalDate localDate) {
        return iEventDao.findEventByDate(localDate);
    }
    //update event
    public String updateEvent(Event event) {
        if(iEventDao.existsById(event.getEventId())){
            iEventDao.save(event);
            return "Updated successfully";
        }
        return "No Event to update like this,you can add new event with this Id ";
    }
    //delete event by id

    public String deleteEventByEventId(int eventId) {
        if(iEventDao.existsById(eventId)){
            iEventDao.deleteById(eventId);
            return "Deleted successfully";
        }
        return "No Event to delete with this eventId like this ";

    }

}
