package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.Announcements;

public interface AnnouncementsService {
	Announcements createAnnouncements ( @Valid Announcements announcements);
	
	Optional<Announcements>getAnnouncementById( @Valid Long id);
	
	List<Announcements>getAllAnnouncements();
	
	Announcements updateAnnouncements(@Valid Long id, Announcements announcements);
	
	Announcements deleteAnnouncements(@Valid  long id);

}
