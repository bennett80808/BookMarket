# BookMarket
BookMarket with SpringBoot

README
Controller - Service - Repository 구성.

http://localhost:8080/BookMarket/home
에서 시작하시면 됩니다.

* 시큐리티 처리( home 에서 add a book 시, http://localhost:8080/BookMarket/login)
로그인
아이디 : Admin
비밀번호 : Admin1234


* 도서 이미지 파일 업로드 기능(http://localhost:8080/BookMarket/books/add)
업로드할 이미지 파일은 C:\upload 로 저장되도록 설정되어 있습니다.

* 도서 이미지 파일 다운로드 기능(http://localhost:8080/BookMarket/books/book?id=ISBN1234)

* 다국어 처리 기능 (http://localhost:8080/BookMarket/books/add)

* 유효성 검사

- Bean Validation 이용 :
도서 아이디가 ISBN123으로 시작하여 1부터 9까지 숫자중 하나가 오는지 확인.
도서명의 문자길이가 4~50인지 검사.
도서 가격이 최소 0이상인지 검사
도서 가격이 정수 8자리와 소수점 2자리 이내인지 검사
도서 가격이 Null 인지 검사

- ConstraintValidator 인터페이스 이용 :
입력된 도서ID가 저장소 객체에 있는지 유효성 검사

- Validator 인터페이스 이용 : 
가격이 10000원 이상인 경우에는 재고수를 99개 이상 등록할 수 없게 함.

* 예외 처리
@ResponseStatus (http://localhost:8080/BookMarket/books/IT교육서)
@ExceptionHandler(http://localhost:8080/BookMarket/books/book?id=ISBN0000)
@ControllerAdvice (http://localhost:8080/BookMarket/books/IT교육서)

* 로그 기록
Log4j2, HandlerInterceptor
C:\log에 monitor.log 로 저장.

*RESTful 웹서비스를 이용해 도서 쇼핑몰의 장바구니 구현
