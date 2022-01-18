package com.example.pocinmemorydbtesting;

import com.example.pocinmemorydbtesting.model.Persona;
import com.example.pocinmemorydbtesting.repository.PersonaRepository;
import com.example.pocinmemorydbtesting.util.DBScriptsConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PocInmemoryDbTestingApplicationTests {

	@Autowired
	private PersonaRepository personaRepository;

	@Test
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
			scripts = {
					DBScriptsConstants.PERSONA
					//  more constants if needed ...
			})
	void removerPersonaConIdEqual1() throws Exception {
		Optional<Persona> optPersona = personaRepository.findById(1L);
		optPersona.ifPresent(persona -> personaRepository.delete(persona));
		Optional<Persona> optPersonaDeleted = personaRepository.findById(1L);
		assertTrue(optPersonaDeleted.isEmpty());
	}

	@Test
	@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
			scripts = {
					DBScriptsConstants.PERSONA
					//  more constants if needed ...
			})
	void obtenerCantidadPersonas() throws Exception {
		List<Persona> personas = personaRepository.findAll();
		assertThat(personas.size(), is(3));
	}



}


