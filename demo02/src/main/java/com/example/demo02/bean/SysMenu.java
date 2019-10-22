package com.example.demo02.bean;

/**
 * @Title: SysMenu.java
 * @Package cn.zhuzi.kindle.bean
 * @Description: TODO(系统菜单表)
 * @author 作者 grq
 * @version 创建时间：2018年9月9日 下午8:03:04
 *
 */
public class SysMenu {
	private String id;// '菜单ID',
	private String name;// '菜单名称',
	private String pid;// '上级菜单ID',
	private String srcurl;// '菜单url',
	private int model;// '菜单类型 1 2 按钮',
	private String auth;// '权限 使用shiro注解使用',
	private int orde;// '排序'
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSrcurl() {
		return srcurl;
	}
	public void setSrcurl(String srcurl) {
		this.srcurl = srcurl;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getOrde() {
		return orde;
	}
	public void setOrde(int orde) {
		this.orde = orde;
	}
	@Override
	public String toString() {
		return "SysMenu [id=" + id + ", name=" + name + ", pid=" + pid + ", srcurl=" + srcurl + ", model=" + model + ", auth=" + auth + ", orde=" + orde + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysMenu other = (SysMenu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
