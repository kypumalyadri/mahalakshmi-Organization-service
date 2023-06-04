package com.gf.organisation.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gf.organisation.entity.Announcements;
import com.gf.organisation.repository.AnnouncementsRepository;
import com.gf.organisation.service.AnnouncementsService;



@Service
@Transactional

public class AnnouncementsServiceImpl  implements AnnouncementsService{
	
	@Autowired
	private AnnouncementsRepository announcementsReopsitory;
	
	@Override
	public Announcements createAnnouncements(@Valid Announcements announcements) {
		return announcementsReopsitory.save(announcements);
	}
	@Override
	public Optional<Announcements>getAnnouncementById( @Valid Long id){
		return announcementsReopsitory.findById(id);
	}
	@Override
	public List<Announcements>getAllAnnouncements(){
		return announcementsReopsitory.findAll();
	}
	@Override
	public Announcements updateAnnouncements(@Valid Long id, Announcements announcements) {
		return announcementsReopsitory.save(announcements);
	}
	@Override
	public Announcements deleteAnnouncements(@Valid  long id) {
		Optional<Announcements>existingAnnouncements = announcementsReopsitory.findById(id);
		if (existingAnnouncements.isPresent()) {
			Announcements announcements = existingAnnouncements.get();
			announcementsReopsitory.deleteById(id);
			return announcements;
			
		} else {
			return null;

		}
	}

	}


