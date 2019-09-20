/*package com.paru.enterprices.admin.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paru.enterprices.database.dao.PersonDAO;
import com.paru.enterprices.database.entity.Person;
import com.paru.enterprices.database.entity.Role;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public UserDetails loadUserByUsername(String mobNo) throws UsernameNotFoundException {
		List<Person> persons = personDAO.byMobNo(mobNo);
		if(persons.isEmpty()){
			throw new UsernameNotFoundException(mobNo);
		}
		UserCreds userCreds = new UserCreds();
		userCreds.setMobNo(mobNo);
		Person person = persons.get(0);
		userCreds.setPassword(person.getUser().getPassword());
		Set<Role> roleList = person.getUser().getRoles();
		List<String> roles = new ArrayList<>();
		for (Role role : roleList) {
			roles.add(role.getName());
			userCreds.setRoles(roles);	
		}
		UserPrincipal userPrincipal = new UserPrincipal(userCreds);
		return userPrincipal;
	}

}
*/