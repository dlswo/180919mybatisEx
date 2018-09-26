package org.zerock.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zerock.domain.BoardVO;

public class MyBatisLoader {
	
	static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)throws Exception {
		
		String prefix = "org.zerock.mapper.BoardMapper";
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		System.out.println(sqlSessionFactory);
		
		SqlSession session = sqlSessionFactory.openSession(true);
//		String now = session.selectOne("org.zerock.mapper.TimeMapper.getTime"); // 현재 시간 구하는거
//		System.out.println(now);
//		session.close();
		
//		List<BoardVO> list = 
//				session.selectList( prefix + ".select10"); // 리스트 호출
//		System.out.println(list);
		
//		BoardVO vo = new BoardVO();// 인서트추가
//		vo.setTitle("제목");
//		vo.setContent("내용");
//		vo.setWriter("injae");
//		
//		session.insert("org.zerock.mapper.BoardMapper.create", vo);
		
//		int count = session.delete("org.zerock.mapper.BoardMapper.remove", 5701786); // 삭제
//		System.out.println(count);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("page", 2);
		paramMap.put("size", 20);
		
		List<BoardVO> list2 = session.selectList(prefix + ".selectPage", paramMap);
		
		System.out.println(list2);
		
	}
	
}
