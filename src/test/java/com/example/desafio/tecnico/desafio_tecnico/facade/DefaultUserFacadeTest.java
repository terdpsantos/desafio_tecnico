package com.example.desafio.tecnico.desafio_tecnico.facade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.example.desafio.tecnico.dto.UserDTO;
import com.example.desafio.tecnico.facade.UserFacade;

@SpringBootTest
public class DefaultUserFacadeTest {

	@Autowired
	UserFacade userFacade;

	@Test
	void saveCase1() {

		final UserDTO dto = this.getDTO();

		if (Objects.nonNull(dto)) {
			userFacade.delete(getDTO().getId());
		}

		assertThat(Objects.nonNull(userFacade.save(this.populate())));
	}

	@Test
	void getCase1() {
		final List<UserDTO> users = userFacade.getAllUsers();
		assertThat(!users.isEmpty());
	}

	@Test
	void updateCase1() {
		final UserDTO dto = this.getDTO();
		UserDTO user = new UserDTO();

		user = Objects.isNull(dto) ? userFacade.save(this.populate()) : this.getDTO();
		user.setName("Teste de atualização");
		assertThat(Objects.nonNull(userFacade.update(user)));
	}

	@Test
	void deleteCase1() {

		final UserDTO dto = this.getDTO();

		if (Objects.isNull(dto)) {
			userFacade.save(this.populate());
		}

		final String result = userFacade.delete(getDTO().getId());
		assertThat(StringUtils.isNotBlank(result));
	}

	private UserDTO populate() {
		final UserDTO dto = new UserDTO();
		dto.setName("Teste");
		dto.setEmail("teste@gmail.com");
		dto.setDocument("teste document");
		return dto;
	}

	private UserDTO getDTO() {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		try {
			userDTOs = userFacade.getAllUsers();
		} catch (Exception e) {
			userFacade.save(this.populate());
		} finally {
			return CollectionUtils.isEmpty(userDTOs) ? null
					: userDTOs.stream().filter(u -> u.getName().contains("Teste")).toList().get(0);
		}
	}

}
