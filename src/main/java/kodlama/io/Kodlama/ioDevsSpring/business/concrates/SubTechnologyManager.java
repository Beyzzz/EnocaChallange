package kodlama.io.Kodlama.ioDevsSpring.business.concrates;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.LanguageService;
import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.subTechnology.SubTechnologyResponse;
import kodlama.io.Kodlama.ioDevsSpring.core.utils.SubTechnologyTools;
import kodlama.io.Kodlama.ioDevsSpring.dataAcces.abstracts.SubTechnologyRepository;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.SubTechnology;
@Service
public class SubTechnologyManager implements SubTechnologyService {
	SubTechnologyRepository subTechnologyRepository;
	LanguageService languageService;

	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, LanguageService languageService) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
		this.languageService= languageService;
	}

	@Override
	public List<SubTechnologyResponse> getAll() {
		
		return SubTechnologyTools.toSubTechnologyResponseList(this.subTechnologyRepository.findAll());
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubTechnologyResponse update(int id, UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology inDbSubTechnology= subTechnologyRepository.findById(id).orElseThrow(()-> new RuntimeException("SubTechnology bulunamadı"));
		inDbSubTechnology.setTechnologyName(updateSubTechnologyRequest.getTechnologyName());
		Language language = languageService.getLanguageById(updateSubTechnologyRequest.getLanguageId());
		inDbSubTechnology.setLanguage(language);
	
		
		
		return SubTechnologyTools.toSubTechnologyResponse(subTechnologyRepository.save(inDbSubTechnology));
	}

	@Override
	public SubTechnologyResponse add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		// TODO Auto-generated method stub
		SubTechnology subTechnology = SubTechnologyTools.toSubTechnology(createSubTechnologyRequest, languageService.getLanguageById(createSubTechnologyRequest.getLanguageId()));
		return SubTechnologyTools.toSubTechnologyResponse(subTechnologyRepository.save(subTechnology));
	
	}

	@Override
	public SubTechnologyResponse getById(int id) {
		// TODO Auto-generated method stub
		SubTechnology inDbSubTechnology = subTechnologyRepository.findById(id).orElseThrow(()-> new RuntimeException("Sub Technology bulunamadı"));
		
		
		return SubTechnologyTools.toSubTechnologyResponse(inDbSubTechnology);
	}

	@Override
	public List<SubTechnologyResponse> getTechnologyOfLanguage(int id) {
		List<SubTechnology> subTechnologies=subTechnologyRepository.findAllByLanguage_Id(id);
		
		return SubTechnologyTools.toSubTechnologyResponseList(subTechnologies);
	}

	

}
