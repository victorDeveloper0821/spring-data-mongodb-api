package idv.victor.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="members")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Users {

	@Id
	private String id;
	
	private String userid;
	private String password;
	private String email;
}
