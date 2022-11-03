package info.ideaworlds.server.idea.event;

import lombok.Data;

@Data
public class IdeaRemovedEvent {

    private Long id;

    public static IdeaRemovedEvent of(Long id) {
        IdeaRemovedEvent event = new IdeaRemovedEvent();
        event.setId(id);
        return event;
    }

}
