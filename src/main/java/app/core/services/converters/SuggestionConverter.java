package app.core.services.converters;

import app.core.domain.Suggestion;
import app.dto.SuggestionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 2/18/2016.
 */
@Component
public class SuggestionConverter {

    public List<SuggestionDTO> toDTOs(List<Suggestion> suggestions) {
        List<SuggestionDTO> suggestionDTOs = new ArrayList<>();
        for (Suggestion suggestion : suggestions) suggestionDTOs.add(toDTO(suggestion));
        return  suggestionDTOs;
    }

    public SuggestionDTO toDTO(Suggestion suggestion) {
        SuggestionDTO suggestionDTO = new SuggestionDTO();
        suggestionDTO.setId(suggestion.getId());
        suggestionDTO.setTitle(suggestion.getTitle());
        suggestionDTO.setUpvotes(suggestion.getUpvotes());
        return suggestionDTO;
    }

    public List<Suggestion> fromDTOs(List<SuggestionDTO> suggestionDTOs) {
        List<Suggestion> suggestions = new ArrayList<>();
        for (SuggestionDTO suggestionDTO: suggestionDTOs) suggestions.add(fromDTO(suggestionDTO));
        return suggestions;
    }

    public Suggestion fromDTO(SuggestionDTO suggestionDTO) {
        return new Suggestion(suggestionDTO.getId(), suggestionDTO.getTitle(), suggestionDTO.getUpvotes());
    }

}
