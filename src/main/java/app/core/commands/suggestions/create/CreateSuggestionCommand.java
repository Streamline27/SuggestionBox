package app.core.commands.suggestions.create;

import app.core.commands.DomainCommand;

/**
 * Created by Vladislav on 12/28/2015.
 */
public class CreateSuggestionCommand implements DomainCommand<CreateSuggestionResult>{

    private String title;

    public CreateSuggestionCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
