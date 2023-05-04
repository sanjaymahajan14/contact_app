package com.parth.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parth.entity.Contact;
import com.parth.repository.ContactRepository;
import com.parth.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact savedContact = repo.save(contact);
		if(savedContact.getContactId()!=null) {
			return "Contact saved !!";
		}else {
			return "Contact failed to save !!";
		}
		
		
	}

	@Override
	public List<Contact> getAllContacts() {
		//List<Contact> contacts = repo.findAll();
		List<Contact> contacts = repo.findByActiveSw("Y");
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contact = repo.findById(contactId);
		if(contact.isPresent()) {
			return contact.get();
		}else {
			return null;
		}
		
	}

	@Override
	public String updateContact(Contact contact) {
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "Contact updated!!";
		}else {
			return "No record found";
		}
		
	}

	@Override
	public String deleteContactById(Integer contactId) {
//		if(repo.existsById(contactId)) {
//			repo.deleteById(contactId);
//			return "Contact deleted!!";
//		}else {
//			return "No record found!!";
//		}
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			repo.save(contact);
			return "Contact deleted!!";
			}else {
				return "No record found!!";
		}
	}

}
