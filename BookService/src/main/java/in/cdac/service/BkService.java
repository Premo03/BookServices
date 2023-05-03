package in.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.entity.Book;
import in.cdac.repo.BookRepository;

@Service
public class BkService {
	@Autowired
	private BookRepository brk;
	
	public Book saveBook(Book bk) {
		return brk.save(bk);
	}
	
	public Book updateBook(Book bk) {
		Book existingBook = brk.findById(bk.getBookid()).orElse(null);
		existingBook.setAuthor(bk.getAuthor());
		existingBook.setName(bk.getName());
		existingBook.setPrice(bk.getPrice());
		existingBook.setQuantity(bk.getQuantity());
		
		return brk.save(existingBook);
	}
	
	public Book getBookDetails(int id) {
		return brk.findById(id).orElse(null);
	}
	
	public List<Book> getAllBookDetails(){
		return brk.findAll();
	}
	
	public String deleteBook(int id) {
		Book bk = brk.findById(id).orElse(null);
		if(bk != null) {
			brk.deleteById(id);
			return "Book of id: " +id+ "was deleted";
		}else {
			return "Sorry book not found";
		}
		
	}
	
	public Book getBookByName(String bookname) {
		return brk.findByName(bookname);
	}
}
