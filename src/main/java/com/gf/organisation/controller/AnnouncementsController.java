package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.Announcements;
import com.gf.organisation.service.AnnouncementsService;

@RestController
@RequestMapping(value = "/Announcements")
@CrossOrigin(origins = "*")
public class AnnouncementsController {
    private static final Logger log = LoggerFactory.getLogger(AnnouncementsController.class);

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping(value = "/save")
    public ResponseEntity<Announcements> createAnnouncements(@Valid @RequestBody Announcements announcements) {
        log.info("Creating new announcement: {}", announcements);
        Announcements createdAnnouncement = announcementsService.createAnnouncements(announcements);
        log.info("Announcement created: {}", createdAnnouncement);
        return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAnnouncementById(@Valid Long id) {
        log.info("Fetching announcement by ID: {}", id);
        Optional<Announcements> announcements = announcementsService.getAnnouncementById(id);
        if (announcements.isPresent()) {
            Announcements getAnnouncements = announcements.get();
            log.info("Found announcement: {}", getAnnouncements);
            return new ResponseEntity<>(getAnnouncements, HttpStatus.ACCEPTED);
        } else {
            log.info("Announcement not found for ID: {}", id);
            return new ResponseEntity<>(announcements, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Announcements>> getAllAnnouncements() {
        log.info("Fetching all announcements");
        List<Announcements> announcements = announcementsService.getAllAnnouncements();
        if (announcements.isEmpty()) {
            log.info("No announcements found");
            return new ResponseEntity<>(announcements, HttpStatus.NOT_FOUND);
        } else {
            log.info("Found {} announcements", announcements.size());
            return new ResponseEntity<>(announcements, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Announcements> updateAnnouncements(@Valid Long id, @RequestBody Announcements announcements) {
        log.info("Updating announcement: {}", announcements);
        Announcements updatedAnnouncements = announcementsService.updateAnnouncements(id, announcements);
        if (updatedAnnouncements != null) {
            log.info("Announcement updated: {}", updatedAnnouncements);
            return new ResponseEntity<>(updatedAnnouncements, HttpStatus.ACCEPTED);
        } else {
            log.info("Failed to update announcement");
            return new ResponseEntity<>(updatedAnnouncements, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Announcements> deleteAnnouncements(@Valid @PathVariable Long id) {
        log.info("Deleting announcement with ID: {}", id);
        Announcements deletedAnnouncement = announcementsService.deleteAnnouncements(id);
        if (deletedAnnouncement != null) {
            log.info("Announcement deleted: {}", deletedAnnouncement);
            return new ResponseEntity<>(deletedAnnouncement, HttpStatus.OK);
        } else {
            log.info("Announcement not found for ID: {}", id);
            return new ResponseEntity<>(deletedAnnouncement, HttpStatus.NOT_FOUND);
        }
    }
}
