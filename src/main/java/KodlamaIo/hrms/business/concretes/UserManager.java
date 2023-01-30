package KodlamaIo.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.UserService;
import KodlamaIo.hrms.core.dataAccess.UserDao;
import KodlamaIo.hrms.core.entities.User;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;


@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {

		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "User found");
	}

	
}
