package com.springboot.repository;
import java.util.List;
import com.springboot.domain.Book;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
	List<Book> getAllBookList();
	Book getBookById(String bookId);
	void setNewBook(Book book);
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}
