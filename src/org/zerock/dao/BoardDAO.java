package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.domain.BoardVO;

public class BoardDAO {
	
	private String prefix = 
			"org.zerock.mapper.BoardMapper";
	
	public void create(BoardVO vo) {
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			session.insert(prefix + ".create", vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
