package idv.victor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.tomcat.util.buf.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.victor.dao.UserRepository;
import idv.victor.entity.Users;
import idv.victor.utils.EncryptUtil;

@Service
public class MemberService {

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private EncryptUtil encryptUtil;
	
	public String doSave(Users user) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonmap = new HashMap();
		if(Objects.nonNull(user)) {
			jsonmap.put("status", "ok");
			user.setId(ObjectId.get().toHexString());
			user.setPassword(EncryptUtil.md5Hash(user.getPassword()));
			userRepository.save(user);
			jsonmap.put("results", user);
		}else {
			jsonmap.put("status", "fail");			
		}
		
		try {
			result = mapper.writeValueAsString(jsonmap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail to write json\"}";
		}
		return result;
	}
	
	public String doUpdate(String id,Users user) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonmap = new HashMap();
		Users userToEdit;
		if(Objects.isNull(id)||id.equals("")) {
			jsonmap.put("status","emptyBlank");
		}else {
			jsonmap.put("status", "ok");
			Optional<Users> optional = userRepository.findById(id);
			userToEdit = optional.orElse(null);
			if(Objects.nonNull(userToEdit)) {
				userToEdit.setPassword(EncryptUtil.md5Hash(user.getPassword()));
				userToEdit.setEmail(user.getEmail());
				userRepository.save(userToEdit);
				jsonmap.put("results", userToEdit);
			}else {
				jsonmap.put("status", "fail");

			}
		}
		try {
			result = mapper.writeValueAsString(jsonmap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail to write json\"}";
		}
		return result;
	}
	
	public String findOne(String id) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonmap = new HashMap();
		Users userToFind;
		if(Objects.isNull(id)||id.equals("")) {
			jsonmap.put("status","emptyBlank");
		}else {
			jsonmap.put("status", "ok");
			Optional<Users> optional = userRepository.findById(id);
			userToFind = optional.orElse(null);
			if(Objects.nonNull(userToFind)) {
				jsonmap.put("results", userToFind);
			}else {
				jsonmap.put("status", "fail");

			}
		}
		try {
			result = mapper.writeValueAsString(jsonmap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail to write json\"}";
		}
		return result;
	}
	
	public String findAll() {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonmap = new HashMap();
		List<Users> users = userRepository.findAll();
		if(users.size()>0) {
			jsonmap.put("status", "ok");
			jsonmap.put("result", users);
		}else {
			jsonmap.put("status","no data");
		}
		try {
			result = mapper.writeValueAsString(jsonmap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail to write json\"}";
		}
		return result;
	}
	
	public String deleteUser(String id) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonmap = new HashMap();
		Optional<Users> options = userRepository.findById(id);
		Users userToEdit = options.orElse(null);
		if(Objects.nonNull(userToEdit)) {
			jsonmap.put("status", "ok");
			userRepository.delete(userToEdit);
		}else {
			jsonmap.put("status", "not found");
		}
		try {
			result = mapper.writeValueAsString(jsonmap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail to write json\"}";
		}
		return result;
	}
}
