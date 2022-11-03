package info.ideaworlds.server.idea.app.executor;

import info.ideaworlds.server.idea.app.converter.IdeaConverter;
import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import info.ideaworlds.server.idea.domain.IdeaEntity;
import info.ideaworlds.server.idea.event.IdeaAddedEvent;
import info.ideaworlds.server.idea.event.IdeaRemovedEvent;
import info.ideaworlds.server.idea.event.IdeaUpdatedEvent;
import info.ideaworlds.server.idea.infra.data.Idea;
import info.ideaworlds.server.idea.infra.repo.IdeaRepo;
import dev.simpleframework.util.SimpleSpringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 通用命令（简单增删改）执行器
 */
@Component
@RequiredArgsConstructor
public class IdeaCommonCommand {
    private final IdeaRepo repo;

    public Long add(IdeaModifyArgs args) {
        Idea data = IdeaConverter.toData(args);
        IdeaEntity entity = IdeaEntity.create().data(data);
        this.repo.save(entity);

        IdeaAddedEvent event = IdeaAddedEvent.of(entity.id(), args);
        SimpleSpringUtils.publishEvent(event);
        return entity.id();
    }

    public void update(Long id, IdeaModifyArgs args) {
        Idea data = IdeaConverter.toData(args);
        data.setId(id);

        IdeaEntity entity = this.repo.findEntity(id).data(data);
        this.repo.save(entity);

        IdeaUpdatedEvent event = IdeaUpdatedEvent.of(id, args);
        SimpleSpringUtils.publishEvent(event);
    }

    public void removeById(Long id) {
        this.repo.deleteById(id);

        IdeaRemovedEvent event = IdeaRemovedEvent.of(id);
        SimpleSpringUtils.publishEvent(event);
    }

}
