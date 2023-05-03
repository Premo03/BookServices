package in.cdac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	Book findByName(String name);

}
