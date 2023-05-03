package in.cdac.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.entity.Book;
import in.cdac.service.BkService;

@RestController
public class BookController {
	
	@Autowired
	private BkService bks;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book bk) {
		return bks.saveBook(bk);
	}
	
	@GetMapping("/allbooks")
	public List<Book> getAllBooks()
	{
		return bks.getAllBookDetails();
	}
	
	@PutMapping("/updatebook")
	public Book  updateBookDetails(@RequestBody Book bk) {
		return bks.updateBook(bk);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public String deleteBookDetails(@PathVariable int id) {
		return bks.deleteBook(id);
	}
	
	@GetMapping("/book/{id}")
	public Book setSelectedBookDetails(@PathVariable int id) {
		return bks.getBookDetails(id);
	}
	
	@GetMapping("/book/name/{name}")
	public Book getSelectedBookByName(@PathVariable String name) {
		return bks.getBookByName(name);
	}
}
