package kodlama.io.Kodlama.ioDevsSpring.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.request.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.ioDevsSpring.business.response.language.LanguageResponse;
import kodlama.io.Kodlama.ioDevsSpring.entities.concrates.Language;

public interface LanguageService {
	List<LanguageResponse> getAll();
	LanguageResponse add(CreateLanguageRequest createLanguageRequest );
	LanguageResponse getById(int id);
	boolean delete(int id);
	LanguageResponse update(int id,UpdateLanguageRequest updateLanguageRequest) throws RuntimeException;
	Language getLanguageById(int id);

}

