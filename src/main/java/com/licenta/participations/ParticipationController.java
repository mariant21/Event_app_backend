package com.licenta.participations;

import com.licenta.auth.models.User;
import com.licenta.auth.repository.UserRepository;
import com.licenta.eventfields.EventFields;
import com.licenta.eventfields.EventFieldsRepository;
import com.licenta.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/participations/")
@CrossOrigin(origins ="*", maxAge = 3600)
public class ParticipationController {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventFieldsRepository eventFieldsRepository;

    @GetMapping("")
    public List<Participation> getAllParticipations() {
        return this.participationRepository.findAll()
                .stream()
                .map(submission -> new Participation(submission.getId(), submission.getUser(), submission.getEvent()))
                .collect(Collectors.toList());
    }

    @GetMapping("{userId}")
    public List<Participation> getParticipationsForCurrentUser(@PathVariable(value = "userId") Long userId) {
        return this.participationRepository.findAll()
                .stream()
                .filter(sub -> sub.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    @PostMapping("add/{userId}/{eventId}")
    public ResponseEntity<?> addSubmission(@PathVariable(value = "userId") Long userId,
                                           @PathVariable(value = "eventId") Long eventId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found for this id: " + userId));

        EventFields event = eventFieldsRepository.findById(eventId)
                .orElseThrow(()-> new ResourceNotFoundException("Event not found for this id: " + eventId));

        return ResponseEntity.ok(participationRepository.save(new Participation(
                user,
                event)));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSubmissions(@PathVariable(value = "id") Long partId) {
        this.participationRepository.deleteById(partId);
        return ResponseEntity.ok(partId);
    }
}
