package KodlamaIo.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);

}
