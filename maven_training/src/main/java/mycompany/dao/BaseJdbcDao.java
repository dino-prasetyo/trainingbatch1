package mycompany.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:dino.prasetyo@sigma.co.id">Dino Prasetyo</a>
 * @version $Revision:$
 *          Date: 4/8/14 2:51
 */
public class BaseJdbcDao
{
	protected final JdbcTemplate jdbcTemplate;
	protected final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public BaseJdbcDao(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void createTable()
	{
		
		String sql="CREATE TABLE EMPLOYEE ( ID VARCHAR(10), NAME VARCHAR(20))";
		jdbcTemplate.execute(sql);
	}
	public void insertRecord()
	{
		Map param = new HashMap();
		String sql="INSERT INTO EMPLOYEE(ID, NAME) VALUES (:id,:name)";
		param.put("id", 100);
		param.put("name", "Test 100");
		namedJdbcTemplate.update(sql, param);
		
		param.clear();
		param.put("id", 101);
		param.put("name", "Test 101");
		namedJdbcTemplate.update(sql, param);
		
		param.clear();
		param.put("id", 102);
		param.put("name", "Test 102");
		namedJdbcTemplate.update(sql, param);
		
	}
	public void insertRecord(String id, String nama)
	{
		Map param = new HashMap();
		String sql="INSERT INTO EMPLOYEE(ID, NAME) VALUES (:id,:name)";
		param.put("id", id);
		param.put("name", nama);
		namedJdbcTemplate.update(sql, param);
	}

	public int countRecord()
	{
		String sql = "select count(*) from EMPLOYEE";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public void select()
	{
		String sql = "select * from EMPLOYEE";
		jdbcTemplate.setFetchSize(3);
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
		int count=0;
		while(sqlRowSet.next())
		{
			//int id = sqlRowSet.getInt("ID");
			//String firstName = sqlRowSet.getString("NAME");
			count++;
		}

		System.out.println("count = " + count);

		int countMaxRows=0;
		jdbcTemplate.setMaxRows(1);
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> ignored : maps)
		{
			countMaxRows++;
		}
		System.out.println("countMaxRows = " + countMaxRows);
	}
	@SuppressWarnings("unused")
	public void selectMaxRow()
	{
		String sql = "select * from EMPLOYEE";
		jdbcTemplate.setFetchSize(100);
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : maps)
		{
			Integer id = Integer.valueOf(row.get("ID").toString());
			String firstName = row.get("NAME").toString();
		}

	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createNomor()
	{
	
	}
	
	public void saveUser()
	{
		createNomor();
	}
}
