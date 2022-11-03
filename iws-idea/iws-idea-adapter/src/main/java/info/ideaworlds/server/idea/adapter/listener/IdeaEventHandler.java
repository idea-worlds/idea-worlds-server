package info.ideaworlds.server.idea.adapter.listener;

import info.ideaworlds.server.idea.api.IdeaApi;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IdeaEventHandler {
    private final IdeaApi api;

}