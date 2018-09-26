package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;

public class TimeDAO {
	
	private final String prefix = "org.zerock.mapper.TimeMapper";
	
	public String getTime() {
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			
			return session.selectOne(prefix + ".getTime");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
