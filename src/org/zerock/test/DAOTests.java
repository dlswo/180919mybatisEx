package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.TimeDAO;
import org.zerock.domain.BoardVO;

public class DAOTests {
	
	@Test
	public void testGetTime() {
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("¹ä¸ÔÀ¸·¯");
		vo.setContent("ÀºÁ¦°¡³Ä~");
		vo.setWriter("injae");
		
		System.out.println(new TimeDAO().getTime());
		new BoardDAO().create(vo);
	}
}
