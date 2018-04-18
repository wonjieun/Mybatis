package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * <pre>
 * mybatis
 * MybatisConnectionFactory.java
 * </pre>
 *
 * @title  : 
 * @since  : 2018. 4. 16.
 * @author : user1
 *
 * driver를 load해서 Singleton으로 만들 것이다
 *
 */
public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String res = "mybatis/mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(res);
			
			if( sqlSessionFactory == null ) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
