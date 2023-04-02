package com.ecommerce.shopping.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.shopping.entity.User;

public class MyUserDetails implements UserDetails {

	@Autowired
	private User theUser;
	
     
    public MyUserDetails(User user) {
        this.theUser = user;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		System.out.println();
		System.out.println("User Role" +theUser.getRole());
		System.out.println();
		authorities.add(new SimpleGrantedAuthority(theUser.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return theUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return theUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return theUser.isEnabled();
	}

}
