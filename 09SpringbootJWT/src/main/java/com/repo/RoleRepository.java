package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.RoleBean;

public interface RoleRepository extends JpaRepository<RoleBean, Long>{

}
