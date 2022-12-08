package kodlama.io.Kodlama.ioDevsSpring.apiControllers;

import java.util.List;

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

import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.subTechnology.SubTechnologyResponse;
@RestController
@RequestMapping("/api/technology")
public class SubTechnologyApiControllers {
	
	SubTechnologyService subTechnologyService;

	public SubTechnologyApiControllers(SubTechnologyService subTechnologyService) {
		super();
		this.subTechnologyService = subTechnologyService;
	}


	
	@GetMapping
	public ResponseEntity<?>  getAll(){
		List<SubTechnologyResponse> getAllList = subTechnologyService.getAll();
		if(getAllList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		 return new ResponseEntity(getAllList,HttpStatus.OK);
}
	
	@PostMapping
	public ResponseEntity<?> add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		SubTechnologyResponse subTechnology = subTechnologyService.add(createSubTechnologyRequest);
		return new ResponseEntity(subTechnology,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		boolean delete =subTechnologyService.delete(id);
		if(delete) {
			return new ResponseEntity<>("Silme işlemi başarılı", HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
		}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest){
		SubTechnologyResponse getAllSubTechnologyResponse= subTechnologyService.update(id, updateSubTechnologyRequest);
		return new ResponseEntity<>(getAllSubTechnologyResponse,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return new ResponseEntity(subTechnologyService.getById(id), HttpStatus.OK);
		
	}
}
