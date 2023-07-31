package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserBean> users = new ArrayList<>();
	
}
