package com.tom.sample.example.component;

import org.springframework.stereotype.Component;

/* 
 * Any generic Spring-managed component that doesn't fit into a more specific category.
 * 
 * Functions that are focused on other functions outside the scope that is serving
 * To serve the Book, and can be reused around other functions.
 */

@Component
public class LivrosComponent {

	public void SendEmail() {
		
	}
	
	public void validateData() {
		
	}
	
	// Function much used for user authentication.
	public void extractUsername() {
		
	}
	
}
