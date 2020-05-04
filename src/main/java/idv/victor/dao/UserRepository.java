package idv.victor.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import idv.victor.entity.Users;

public interface UserRepository extends MongoRepository<Users,String>{

	public Users findByUserid(String userid);
}
