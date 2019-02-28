//package com.rumango.entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the nodes database table.
// * 
// */
//@Entity
//@Table(name="nodes")
//@NamedQuery(name="Node.findAll", query="SELECT n FROM Node n")
//public class Node implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(unique=true, nullable=false)
//	private Long id;
//
//	@Column(name="created_at")
//	private Timestamp createdAt;
//
//	private String name;
//
//	@ManyToOne
//	@JoinColumn(name="tag_id")
//	//@Column(name="tag_id")
//	private Tag tagId;
//
//	@Column(name="updated_at")
//	private Timestamp updatedAt;
//
//	public Node() {
//	}
//
//	public Long getId() {
//		return this.id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Timestamp getCreatedAt() {
//		return this.createdAt;
//	}
//
//	public void setCreatedAt(Timestamp createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Tag getTagId() {
//		return this.tagId;
//	}
//
//	public void setTagId(Tag tagId) {
//		this.tagId = tagId;
//	}
//
//	public Timestamp getUpdatedAt() {
//		return this.updatedAt;
//	}
//
//	public void setUpdatedAt(Timestamp updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
////	@Override
////	public String toString() {
////		return "Node [id=" + id + ", createdAt=" + createdAt + ", name=" + name + ", tagId=" + tagId + ", updatedAt="
////				+ updatedAt + "]";
////	}
//
//
//}