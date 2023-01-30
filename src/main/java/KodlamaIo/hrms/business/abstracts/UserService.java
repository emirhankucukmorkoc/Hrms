package KodlamaIo.hrms.business.abstracts;

import KodlamaIo.hrms.core.entities.User;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;

public interface UserService {
	DataResult<User> findByEmail(String email);

	Result add(User user);

}
