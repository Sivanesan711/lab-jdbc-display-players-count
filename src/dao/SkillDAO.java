package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public TreeMap<String,Integer> skillCount() throws SQLException, Exception
	{
		int count = 0;
		TreeMap<String,Integer> treemap = new TreeMap<String,Integer>();
		
		ConnectionManager con = new ConnectionManager();
		Skill skill = null;
		
		String sql = "select name, count(name) from name_skill group by name";
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			skill = new Skill(null, sql);
			skill.setSkillName(rs.getString("name"));
			count = rs.getInt("count(name)");
			treemap.put(skill.getSkillName(),count);
		}
		return treemap;
	}
}
