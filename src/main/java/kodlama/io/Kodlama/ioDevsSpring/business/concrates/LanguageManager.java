package kodlama.io.Kodlama.ioDevsSpring.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.ioDevsSpring.business.abstracts.LanguageService;
import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.language.LanguageResponse;
import kodlama.io.Kodlama.ioDevsSpring.core.utils.LanguageTool;
import kodlama.io.Kodlama.ioDevsSpring.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;

@Service
public class LanguageManager implements LanguageService {
	LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public List<LanguageResponse> getAll() {

		return LanguageTool.toResponseList(languageRepository.findAll());
	}

	@Override
	public LanguageResponse add(CreateLanguageRequest createLanguageRequest) {
		Language language = LanguageTool.toLanguage(createLanguageRequest);

		return LanguageTool.toLanguageResponse(this.languageRepository.save(language));

	}

	@Override
	public LanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) throws RuntimeException {
		Language inDbLanguage = languageRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Language bulunamadı"));

		inDbLanguage.setName(updateLanguageRequest.getName());
		return LanguageTool.toLanguageResponse(languageRepository.save(inDbLanguage));
	}

	@Override
	public LanguageResponse getById(int id) {
		Language inDbLanguage = languageRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Language bulunamadı"));
		return LanguageTool.toLanguageResponse(inDbLanguage) ;
	}

	@Override
	public boolean delete(int id) {
		Optional<Language> language= languageRepository.findById(id);
		if(language.isEmpty()) {
			return false;
		}
		languageRepository.deleteById(id);
		return true;

	}

	@Override
	public Language getLanguageById(int id) {
		
		return languageRepository.findById(id).orElseThrow(()-> new RuntimeException("Language bulunamadı"));
	}



}
