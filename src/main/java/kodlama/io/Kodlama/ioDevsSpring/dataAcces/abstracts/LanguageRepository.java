package kodlama.io.Kodlama.ioDevsSpring.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
