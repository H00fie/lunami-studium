package bm.app.lunamistudium.technology.japanese.application;

import bm.app.lunamistudium.technology.japanese.application.port.JapaneseUseCase;
import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import bm.app.lunamistudium.technology.japanese.domain.JapaneseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class JapaneseService implements JapaneseUseCase {

    private final JapaneseRepository japaneseRepository;

    @Override
    public List<Flashcard> findAll() {
        return japaneseRepository.findAll();
    }

    @Override
    public Flashcard addFlashcard(CreateFlashcardCommand command) {
        return japaneseRepository.save(command.toFlashcard());
    }

    @Override
    public void removeById(Long id) {
        japaneseRepository.deleteById(id);
    }
}
