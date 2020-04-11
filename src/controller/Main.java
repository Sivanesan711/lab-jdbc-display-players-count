package controller;

import java.sql.SQLException;
import java.util.Map.Entry;

import dao.SkillDAO;
import utility.ConnectionManager;

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
		
		SkillDAO skldao = new SkillDAO();
		for(Entry<String,Integer> entry: skldao.skillCount().entrySet())
		{
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}
