package info.ideaworlds.server.idea.app.service;

import info.ideaworlds.server.idea.api.IdeaApi;
import info.ideaworlds.server.idea.app.executor.IdeaCommonCommand;
import info.ideaworlds.server.idea.app.executor.IdeaCommonQuery;
import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import info.ideaworlds.server.idea.model.IdeaPageQueryArgs;
import info.ideaworlds.server.idea.model.IdeaResponse;
import dev.simpleframework.core.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 接口实现门面，转发请求到具体的执行器
 */
@Service
@RequiredArgsConstructor
public class IdeaService implements IdeaApi {
    private final IdeaCommonCommand commonCommand;
    private final IdeaCommonQuery commonQuery;

    @Override
    public Long addIdea(IdeaModifyArgs args) {
        return this.commonCommand.add(args);
    }

    @Override
    public void updateIdea(Long id, IdeaModifyArgs args) {
        this.commonCommand.update(id, args);
    }

    @Override
    public void removeIdea(Long id) {
        this.commonCommand.removeById(id);
    }

    @Override
    public IdeaResponse findIdea(Long id) {
        return this.commonQuery.findById(id);
    }

    @Override
    public PageResponse<IdeaResponse> pageIdea(IdeaPageQueryArgs query) {
        return this.commonQuery.findPage(query);
    }

}
