package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase
{
	/** 定义一个Connection 用来连接数据库 */
	private Connection conn = null;
	/** 连接数据库的URL */
	private final String url = "jdbc:mysql://localhost:3307/test";
	/** 指定数据的用户名和密码 */
	private final String username = "root";
	private final String password = "";
	/** 定义一个int记录更新的记录数量 */
	int count = 0;
	/** 定义一个结果集 用于放回查询结果 */
	private ResultSet resultSet = null;
	private PreparedStatement pstmt = null;

	public DataBase()
	{
		conn = connectionDB();
	}

	/**
	 * 建立数据的连接
	 * 
	 * @exception SQLException,
	 *                ClassNotFoundException
	 */
	@SuppressWarnings("finally")
	public Connection connectionDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("连接数据库成功");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("建立数据库发生错误！");
		} finally
		{
			return conn;
		}
	}

	/**
	 * 查询方法
	 * 
	 * @param sql查询sql语句
	 * @return resultSet
	 */
	@SuppressWarnings("finally")
	public ResultSet query(String sql)
	{
		try
		{
			pstmt = conn.prepareStatement(sql);
			/** 查询 */
			resultSet = pstmt.executeQuery();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			return resultSet;
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param sql
	 *            更新sql语句
	 * @return
	 */
	public int update(String sql)
	{
		try
		{
			pstmt = conn.prepareStatement(sql);
			count = pstmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("执行更新出错了");
		}

		return count;

	}

	/** 关闭连接 */
	public boolean coles()
	{
		boolean isColes = false;
		if (resultSet != null)
		{
			try
			{
				resultSet.close();
				resultSet = null;
				isColes = true;
			} catch (SQLException e)
			{
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭结果集发生错误");
			}
		}
		if (pstmt != null)
		{
			try
			{
				pstmt.close();
				pstmt = null;
				isColes = true;
			} catch (SQLException e)
			{
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭pstmt发生异常");
			}
		}
		if (conn != null)
		{
			try
			{
				conn.close();
				conn = null;
				isColes = true;
			} catch (Exception e)
			{
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭conn发生异常");
			}
		}
		return isColes;
	}

	/**
	 * 测试查询的方法
	 * 
	 * @throws SQLException
	 */
	public void testQuery() throws SQLException
	{
		resultSet = query("select * from test.test_1");
		if (resultSet.next())
		{
			System.out.println(resultSet.getString(1));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(2));
		}
	}

	public void testUpdate()
	{
		
		count = update("insert into test.test_1(id,name,age)values('1111111111','aaa111','sex')");
		if (count > 0)
		{
			System.out.println("更新成功");
		}
	}

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
//		DataBase db = new DataBase();
//		/** 调用查询方法 */
//		 db.testQuery();
//		/** 调用更新方法 */
////		db.testUpdate();
//		/** 调用关闭连接方法 */
//		db.coles();

	}
}
