package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.BookView;
import info.vo.BookDAO;
import info.vo.BookVO;

public class BookController {
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;

	ArrayList<BookVO> bvoList;
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in); //String
		Scanner s2 = new Scanner(System.in); //int
		
		ArrayList<Integer> isbn = new ArrayList<Integer>();
		ArrayList<String> bookName = new ArrayList<String>();
		ArrayList<String> publish = new ArrayList<String>();
		ArrayList<String> author = new ArrayList<String>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		ArrayList<String> category = new ArrayList<String>();
		
		int flag = CONTINUE;
		//책 정보 입력
		System.out.println("===== 도서 관리 시스템 =====");
		while(true){
			if(flag==1) {
				System.out.println("도서 번호");
				isbn.add(s2.nextInt());
				
				System.out.println("도서 제목");
				bookName.add(s1.next());
				
				System.out.println("출판사");
				publish.add(s1.next());
				
				System.out.println("저자명");
				author.add(s2.next());
				
				System.out.println("가격");
				price.add(s1.nextInt());
				
				System.out.println("카테고리");
				category.add(s2.next());
				
			}else if(flag == EXIT) {
				break;
			}
			
			System.out.println("계속 입력하시겠습니까?(계속: 1, 종료: 0): ");
			flag = s2.nextInt();
			System.out.println("----------------------------------------------------------------");
		
		}
		
		BookDAO dao = new BookDAO();
		
		for(int i=0; i< isbn.size(); i++) {
			BookVO bvo = new BookVO(isbn.get(i),  bookName.get(i),publish.get(i), author.get(i), price.get(i), category.get(i));
			dao.insert(bvo);
		}
		
		//화면 출력
		BookView bView = new BookView();
		bView.View(dao.select());
		
		s1.close();
		s2.close();

	}
	

}
