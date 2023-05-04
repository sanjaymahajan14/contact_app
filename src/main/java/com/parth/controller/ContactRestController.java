package com.parth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.entity.Contact;
import com.parth.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@PostMapping
	public String createContact(@RequestBody Contact contact) {
		return service.saveContact(contact);
	}
	
	@GetMapping
	public List<Contact> getAllContacts() {
		return service.getAllContacts();
	}
	
	@GetMapping("/{contactId}")
	public Contact getContact(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}
	
	@PutMapping
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}
	
	@DeleteMapping("/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}

}
