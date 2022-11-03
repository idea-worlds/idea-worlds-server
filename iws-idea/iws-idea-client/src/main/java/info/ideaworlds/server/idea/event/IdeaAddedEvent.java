package info.ideaworlds.server.idea.event;

import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import lombok.Data;

@Data
public class IdeaAddedEvent {

    private Long id;
    private IdeaModifyArgs args;

    public static IdeaAddedEvent of(Long id, IdeaModifyArgs args) {
        IdeaAddedEvent event = new IdeaAddedEvent();
        event.setId(id);
        event.setArgs(args);
        return event;
    }

}
