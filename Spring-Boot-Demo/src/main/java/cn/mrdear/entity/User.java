package cn.mrdear.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * @author Niu Li
 * @date 2016/8/12
 */
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8302324903615166327L;
	
	private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
    	this.id = id;
        this.username = username;
        this.password = password;
    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
