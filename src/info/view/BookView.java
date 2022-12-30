package info.view;

import java.util.ArrayList;

import info.vo.BookVO;

//도서 정보 출력하는 Object
public class BookView {
	public void View(ArrayList<BookVO> bvoList) {
		for(BookVO bvo : bvoList) {
			System.out.println("도서 번호: "+bvo.getIsbn()+"\t");
			System.out.println("도서 제목: "+bvo.getBookName()+"\t");
			System.out.println("도서 출판사: "+bvo.getPublish()+"\t");
			System.out.println("도서 저자명: "+bvo.getAuthor()+"\t");
			System.out.println("도서 가격"+bvo.getPrice()+"\t");
			System.out.println("도서 카테고리: "+bvo.getCategory()+"\t");
			
		}
	}
}
