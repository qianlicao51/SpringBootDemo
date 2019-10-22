package com.example.demo02.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Title: DbType.java
 * @Package cn.zhuzi.test.bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年9月3日 下午7:08:57
 *
 */
public class DbType {
	private String name;
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public DbType(String name, String comment) {
		super();
		this.name = name;
		this.comment = comment;
	}

	public DbType() {

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "name", "comment");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "name", "comment");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
