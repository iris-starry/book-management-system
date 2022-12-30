package info.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import info.vo.BookVO;

public class BookView2 extends JPanel {
	JTable table;
	DefaultTableModel model;
	ArrayList<BookVO> bookVOList;
	String[] header = {"도서번호","도서명","출판사","저자명","도서가격","카테고리"};
	String[] categoryNames = {"IT도서","소설","비소설","경제","사회"};
	JPanel panS;
	JComboBox<String> categoryCombo;
	JLabel[] lbls = new JLabel[header.length];
	JTextField[] tf = new JTextField[header.length-1];
	JButton btnAdd = new JButton("도서추가");
	
	
	public BookView2() {
		setLayout(new BorderLayout());
		
		categoryCombo = new JComboBox<String>(categoryNames);
		
		panS = new JPanel();
		panS.setLayout(new GridLayout(4,4));
		for(int i=0; i < header.length; i++) {
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);
			if(i<header.length-1) {
				tf[i] = new JTextField();
				panS.add(tf[i]);
			}else
				panS.add(categoryCombo);
		}
		
		for(int i=0; i<3; i++) {
			panS.add(new JLabel(" "));
		}
		panS.add(btnAdd);
	}
	
	//Jtable 관련 메소드
	public void initView() {
		model = new DefaultTableModel(header, bookVOList.size()) {
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}
	public void putResult() {
		model.setRowCount(bookVOList.size());
		BookVO vo = null;
		for(int i=0; i<bookVOList.size(); i++) {
			vo=bookVOList.get(i);
			model.setValueAt(vo.getIsbn(), i, 0);
			model.setValueAt(vo.getBookName(), i,1);
			model.setValueAt(vo.getPublish(), i,2);
			model.setValueAt(vo.getAuthor(), i,3);
			model.setValueAt(vo.getPrice(), i,4);
			model.setValueAt(vo.getCategory(), i,5);
			
			
		}
	}

	public void setBookVOList(ArrayList<BookVO> bookVOList) {
		this.bookVOList = bookVOList;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public BookVO neededInsertData() {
		BookVO vo = new BookVO();
		vo.setIsbn(Integer.parseInt(tf[0].getText()));
		vo.setBookName(tf[1].getText());
		vo.setPublish(tf[2].getText());
		vo.setAuthor(tf[3].getText());
		vo.setPrice(Integer.parseInt(tf[4].getText()));
		vo.setCategory((String)categoryCombo.getSelectedItem());
		return vo;
	}
	
	public void initInsertData() {
		for(int i=0; i< tf.length; i++) {
			tf[i].setText("");
		}
		categoryCombo.setSelectedIndex(0);
	}
}
