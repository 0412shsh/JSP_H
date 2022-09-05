package com.good.test;

public class JavaBean1 {
	
	public String id;
	public String name;
	public String addr;
	
	public JavaBean1(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "JavaBean1 [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
	
}
