package com.rumango.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumango.entity.User;

public interface DashboardRepo extends JpaRepository<User, String>{

}
