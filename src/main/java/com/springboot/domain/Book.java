package com.springboot.domain;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import com.springboot.validator.BookId;

public class Book {
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}
	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}
	@BookId
	@Pattern(regexp="^ISBN123[1-9]$", message="{Pattern.book.bookId}")
	private String bookId; 			// 도서 ID
	
	@Size(min=4, max=50, message="{Size.book.name}")
	private String name;			// 도서 제목
	
	@Min(value=0, message="{Min.book.unitPrice}")
	@Digits(integer=8, fraction=2, message="{Digits.book.unitPrice}")
	@NotNull(message="{NotNull.book.unitPrice}")
	private BigDecimal unitPrice;	// 가격
	private String author;			// 저자
	private String description;		// 설명
	private String publisher;		// 출판사
	private String category;		// 분류
	private long unitsInStock;		// 재고 수
	private String releaseDate;		// 출판일(월/년)
	private String condition;		// 신규도서 or 중고도서 or 전자책
	private String fileName; 		// 도서 이미지 파일
	private MultipartFile bookImage; // 도서 이미지
}
