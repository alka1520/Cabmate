package com.masai.Service.Admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Exception.LoginException;
import com.masai.Repository.AdminDao;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao;

	@Override
	public Admin createAdmin(Admin admin) {
		System.out.println(admin);
			return admindao.save(admin);
		
	}
	
	

}
