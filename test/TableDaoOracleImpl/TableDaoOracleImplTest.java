package TableDaoOracleImpl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bint.dao.impl.TableDaoOracleImpl;
import com.bint.data.Column;
import com.bint.data.Constraint;
import com.bint.data.DataSource;

public class TableDaoOracleImplTest {
	private static DataSource dataSource = new DataSource();
	private TableDaoOracleImpl tableDaoOracle;
	@Before
	public void before(){
		tableDaoOracle = new TableDaoOracleImpl(dataSource);
	}
	
	@Test
	public void getConstriantName(){
		List<Constraint> result = null;
		try {
			result = tableDaoOracle.getConstriantName("class");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Constraint constraint : result){
			System.err.println(constraint.getContraintName());
		}
	}
	
	@Test
	public void isPrimaryKey(){
		Column column = new Column(null);
		column.setName("class");
		try {
			tableDaoOracle.isPrimaryKey(column, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
