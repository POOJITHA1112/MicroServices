package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long did;
	private String dname;
	private String daddress;
	private int dcode;
	
}
