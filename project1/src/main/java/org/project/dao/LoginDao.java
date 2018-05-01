package org.project.dao;

import org.project.bean.LoginBean;
import static org.project.util.DBController.*;

import java.sql.SQLException;

public class LoginDao {

	private static final String SELECT_BY_USERNAME = "SELECT * FROM login WHERE username=?";



	public String authenticateUser(LoginBean loginBean)
	{
		String ret="";
		try {

			if(connectDB(SELECT_BY_USERNAME)) {
				stmt.setString(1, loginBean.getUsername());
				rs = stmt.executeQuery();

				if (rs.next()) {
					if(loginBean.getUsername().equals(rs.getString(1)) && loginBean.getPassword().equals(rs.getString(2))){
						ret= "success"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					}else{
						ret= "failure";
					}
					disconnectDB();
					return ret;
				} else {
					disconnectDB();
					return "failure";
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return "failure";
	}

}
