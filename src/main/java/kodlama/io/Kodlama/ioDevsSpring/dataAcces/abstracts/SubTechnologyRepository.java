package kodlama.io.Kodlama.ioDevsSpring.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer>{
List<SubTechnology> findAllByLanguage_Id(int id);
}
