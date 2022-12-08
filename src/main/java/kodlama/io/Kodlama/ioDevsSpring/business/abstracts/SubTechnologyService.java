package kodlama.io.Kodlama.ioDevsSpring.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.subTechnology.SubTechnologyResponse;

public interface SubTechnologyService {
	List<SubTechnologyResponse> getAll();

	boolean delete(int id);

	SubTechnologyResponse update(int id,UpdateSubTechnologyRequest updateSubTechnologyRequest);

	SubTechnologyResponse add(CreateSubTechnologyRequest createSubTechnologyRequest);
	
	SubTechnologyResponse getById(int id);
    List<SubTechnologyResponse> getTechnologyOfLanguage(int id);
	
	

}