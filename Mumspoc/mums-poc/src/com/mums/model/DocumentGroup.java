package com.mums.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="doc_group")


public class DocumentGroup {
	
	@Id
	@Column(name = "doc_group_id")
	private String documentGroupId;
	@Column(name="doc_group_name")
	private String documentGroupName;

	@OneToMany
	@JoinTable(name = "doc_group_doc", joinColumns = { @JoinColumn(name = "doc_group_id") }, inverseJoinColumns = { @JoinColumn(name = "doc_id") })
	private Set<Document> documents = new HashSet<Document>(
			0);

	@OneToMany
	@JoinTable(name = "doc_group_user", joinColumns = { @JoinColumn(name = "doc_group_id") }, inverseJoinColumns = { @JoinColumn(name = "cdsId") })
	private Set<User> users = new HashSet<User>(
			0);

	
	public DocumentGroup(String documentGroupId, String documentGroupName,
			Set<Document> documents, Set<User> users) {
		super();
		this.documentGroupId = documentGroupId;
		this.documentGroupName = documentGroupName;
		this.documents = documents;
		this.users = users;
	}

	public DocumentGroup(String documentGroupId, String documentGroupName) {
		super();
		this.documentGroupId = documentGroupId;
		this.documentGroupName = documentGroupName;
	}


	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getDocumentGroupId() {
		return documentGroupId;
	}

	public void setDocumentGroupId(String documentGroupId) {
		this.documentGroupId = documentGroupId;
	}

	public String getDocumentGroupName() {
		return documentGroupName;
	}

	public void setDocumentGroupName(String documentGroupName) {
		this.documentGroupName = documentGroupName;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	
	
}


