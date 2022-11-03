package info.ideaworlds.server.idea.event;

import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import lombok.Data;

@Data
public class IdeaUpdatedEvent {

    private Long id;
    private IdeaModifyArgs args;

    public static IdeaUpdatedEvent of(Long id, IdeaModifyArgs args) {
        IdeaUpdatedEvent event = new IdeaUpdatedEvent();
        event.setId(id);
        event.setArgs(args);
        return event;
    }

}
