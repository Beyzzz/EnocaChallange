package kodlama.io.Kodlama.ioDevsSpring.apiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.LanguageService;
import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.language.LanguageResponse;

@RestController
@RequestMapping("/api/language")
public class LanguageApiControllers {
	LanguageService languageService;
	SubTechnologyService subTechnologyService;

	@Autowired
	public LanguageApiControllers(LanguageService languageService, SubTechnologyService subTechnologyService) {
		super();
		this.languageService = languageService;
		this.subTechnologyService= subTechnologyService;
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
	List<LanguageResponse> getAllList = languageService.getAll();
  if(getAllList.isEmpty()) {
	  return ResponseEntity.noContent().build();
	  }
  return new ResponseEntity(getAllList,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> add(CreateLanguageRequest createLanguageRequest) {
		LanguageResponse language = languageService.add(createLanguageRequest);
		return new ResponseEntity(language,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		boolean delete =languageService.delete(id);
		if(delete) {
			return new ResponseEntity<>("Silme işlemi başarılı", HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
		}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateLanguageRequest updateLanguageRequest){
		LanguageResponse getAllLanguageResponse= languageService.update(id, updateLanguageRequest);
		return new ResponseEntity<>(getAllLanguageResponse,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return new ResponseEntity(languageService.getById(id), HttpStatus.OK);
		
	}
	@GetMapping("/{id}/technologies")
	public ResponseEntity<?> getTechnologyOfLanguage(@PathVariable int id){
		return new ResponseEntity(subTechnologyService.getTechnologyOfLanguage(id),HttpStatus.OK);
	}
}
