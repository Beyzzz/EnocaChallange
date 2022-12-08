package kodlama.io.Kodlama.ioDevsSpring.core.utils;

import java.util.List;
import java.util.stream.Collectors;

import kodlama.io.Kodlama.ioDevsSpring.business.request.subTechonology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.subTechnology.SubTechnologyResponse;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.SubTechnology;

public class SubTechnologyTools {
	public static SubTechnologyResponse toSubTechnologyResponse(SubTechnology subTechnology ) {
		SubTechnologyResponse getSubTechnologyResponse = new SubTechnologyResponse();
		getSubTechnologyResponse.setId(subTechnology.getTechnologId());
		getSubTechnologyResponse.setName(subTechnology.getTechnologyName());
		getSubTechnologyResponse.setLanguage_id(subTechnology.getLanguage().getId());
		return getSubTechnologyResponse;
	}
	public static List<SubTechnologyResponse> toSubTechnologyResponseList(List<SubTechnology> subTechnologyList){
		return subTechnologyList.stream().map(SubTechnologyTools:: toSubTechnologyResponse).collect(Collectors.toList());
	}
	
	public static SubTechnology toSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest, Language language) {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setTechnologyName(createSubTechnologyRequest.getTechnologyName());
		subTechnology.setLanguage(language);
		return  subTechnology;
	}

}
