package com.ministerioculto;

import com.ministerioculto.entity.Songs;
import com.ministerioculto.repository.SongsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MinisterioCultoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MinisterioCultoApplication.class, args);
		SongsRepository songsRepository = context.getBean(SongsRepository.class);


		Songs songs1 = new Songs(null,
				"quien ire",
				"marcos witt",
				"fa mayor",
				"letra completa");

		Songs songs2 = new Songs(null,
				"conmigo danza",
				"willy",
				"fa mayor",
				"letra completa");

		Songs songs3 = new Songs(null,
				"quiero volver",
				"willy",
				"fa mayor",
				"letra completa");

		Songs songs4 = new Songs(null,
				"oceano",
				"willy",
				"fa mayor",
				"letra completa");

		songsRepository.save(songs1);
		songsRepository.save(songs2);
		songsRepository.save(songs3);
		songsRepository.save(songs4);
		System.out.println("Cantidad de libros guardados "+songsRepository.findAll().size());









	}

}
