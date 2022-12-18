package com.masai.Service.Admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Customer;
import com.masai.Entities.Driver;
import com.masai.Entities.UserSession;
import com.masai.Exception.AdminException;
import com.masai.Exception.BookingException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.DriverException;
import com.masai.Repository.AdminDao;
import com.masai.Repository.BookingDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.UserSessionDao;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private DriverDao driverdao;
	
	@Autowired
	private UserSessionDao usersessiondao;
	
	@Autowired
	private BookingDao bookingdao;

	@Override
	public Admin createAdmin(Admin admin) {
		Admin a=admindao.findByPhone(admin.getPhone());
		if(a!=null) {
			throw new AdminException("Admin alrady exists");
		}
			return admindao.save(admin);
		
	}

	//Driver Service
	@Override
	public Driver addDriverbyAdmin(Driver driver,String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
		
		Driver d=driverdao.findByPhone(driver.getPhone());
		if(d!=null) {
			throw new DriverException("Driver already exists with that information");
		}
		
		return driverdao.save(driver);
	}else {
		throw new AdminException("Not logged in, LogIn first");
	}
	}

	
	//Driver Service
	@Override
	public Driver deleteDriver(Integer id) throws DriverException{
		Optional<Driver> d=driverdao.findById(id);
		if(d.isPresent()) {
			Driver dri=d.get();
			driverdao.delete(dri);
			return dri;
		}
		throw new DriverException("Driver not found");
		
	}

	@Override
	public Admin deleteAdmin(String sessionid) throws AdminException{
		UserSession us=usersessiondao.findBySessionId(sessionid);
		Optional<Admin> d=admindao.findById( us.getUserid());
		if(d.isPresent()) {
			Admin dri=d.get();
			admindao.delete(dri);
			usersessiondao.delete(us);
			return dri;
			
		}
		throw new AdminException("Error Occured, Unable to Delete Admin");
	}

	@Override
	public Admin updateAdmin(Admin admin, String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			 admin.setAdminId(us.getUserid());
			 return admindao.save(admin);
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}
		
		
		
		
	}

	@Override
	public String updatePassword(String email, String phone, String password) {
		Admin a=admindao.findByPhone(phone);
		if(a.getEmail().equals(email)) {
			a.setPassword(password);
			admindao.save(a);
			return "Password Updated Successfully!";
		}
		throw new AdminException("User doesn't exist");
	}

	@Override
	public Admin viewAdminDetails(String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			return admindao.findById(us.getUserid()).get();
			
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}
	}

	//Driver Service
	

	@Override
	public List<Admin> viewAdmins(String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			List<Admin> list=admindao.findAll();
			return list;
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}
	}

	//Booking Service
	@Override
	public List<Booking> viewBookings(String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			List<Booking> list=bookingdao.findAll();
			if(list.size()==0) {
				throw new BookingException("No Booking Exists");
			}
			return list;
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}	
	}

	//Booking Service
	@Override
	public List<Booking> viewBookingsByDate(String date, String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			LocalDate d=LocalDate.parse(date);
			List<Booking> list=bookingdao.getBookingsByDate(d, sessionid);
			if(list.size()==0) {
				throw new BookingException("No Booking Exists On Date : "+date);
			}
			return list;
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}	
		
	}
	
	@Override
	public List<Booking> findByBookingStatus(Boolean bookingstatus) {
		List<Booking> bookinglist = new ArrayList<>();
		if(bookingstatus) {
			bookinglist = bookingdao.findByBookingStatus(true);
		}else {
			bookinglist = bookingdao.findByBookingStatus(false);
		}
		
		return bookinglist;
	}
	
	//Booking Service

	@Override
	public List<Booking> viewBookingsByDateSpan(String startdate, String enddate, String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		
		LocalDate sld = LocalDate.parse(startdate);
		LocalDate eld = LocalDate.parse(enddate);
		
		if(us!=null) {
			List<Booking> list=bookingdao.getBookingsByDateSpan(sld, eld, sessionid);
			if(list.size()==0) {
				throw new BookingException("No Booking Exists on given Date span");
			}
			return list;
		}else {
			throw new AdminException("Not logged in, LogIn first");
		}	
	}

	
	
	

}
