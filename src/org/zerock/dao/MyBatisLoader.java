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
//		String now = session.selectOne("org.zerock.mapper.TimeMapper.getTime"); // ���� �ð� ���ϴ°�
//		System.out.println(now);
//		session.close();
		
//		List<BoardVO> list = 
//				session.selectList( prefix + ".select10"); // ����Ʈ ȣ��
//		System.out.println(list);
		
//		BoardVO vo = new BoardVO();// �μ�Ʈ�߰�
//		vo.setTitle("����");
//		vo.setContent("����");
//		vo.setWriter("injae");
//		
//		session.insert("org.zerock.mapper.BoardMapper.create", vo);
		
//		int count = session.delete("org.zerock.mapper.BoardMapper.remove", 5701786); // ����
//		System.out.println(count);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("page", 2);
		paramMap.put("size", 20);
		
		List<BoardVO> list2 = session.selectList(prefix + ".selectPage", paramMap);
		
		System.out.println(list2);
		
	}
	
}
