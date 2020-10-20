package com.example.pccw.entity;

public class Login {
	
	public static void main(String args[]) {
          int x=5;
          switch(x) {
          case 5: x++;
          }
		System.out.println(x);
		
		String a = "7\\us\\uss";
		
		System.out.print(a.lastIndexOf("\\uss"));
		
	}
	
	
	private String email;
	private String password;
	
    public Login() {
		
	}
    
    public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
