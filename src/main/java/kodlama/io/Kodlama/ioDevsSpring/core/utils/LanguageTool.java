package kodlama.io.Kodlama.ioDevsSpring.core.utils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.language.LanguageResponse;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;

public class LanguageTool {
	public static LanguageResponse toLanguageResponse(Language language) {
		LanguageResponse getAllLanguageResponse = new LanguageResponse();
		getAllLanguageResponse.setId(language.getId());
		getAllLanguageResponse.setName(language.getName());

		return getAllLanguageResponse;
	}
 public static List<LanguageResponse> toResponseList(List<Language> languageList){
	 return languageList.stream().map(LanguageTool::toLanguageResponse).collect(Collectors.toList());
 }
	public static Language toLanguage(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		return language;

	}

}
