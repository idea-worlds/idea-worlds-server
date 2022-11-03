package info.ideaworlds.server.idea.app.executor;

import info.ideaworlds.server.idea.app.converter.IdeaConverter;
import info.ideaworlds.server.idea.model.IdeaPageQueryArgs;
import info.ideaworlds.server.idea.model.IdeaResponse;
import info.ideaworlds.server.idea.infra.data.Idea;
import info.ideaworlds.server.idea.infra.repo.IdeaRepo;
import dev.simpleframework.core.PageResponse;
import dev.simpleframework.crud.core.Page;
import dev.simpleframework.crud.core.QueryConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 通用查询（简单查询）执行器
 */
@Component
@RequiredArgsConstructor
public class IdeaCommonQuery {
    private final IdeaRepo repo;

    public IdeaResponse findById(Long id) {
        Idea data = this.repo.findById(id);
        return IdeaConverter.toDto(data);
    }

    public PageResponse<IdeaResponse> findPage(IdeaPageQueryArgs query) {
        QueryConfig config = QueryConfig.of();
        // todo  query -> config
        // config.addCondition();
        Page<Idea> page = this.repo.pageByConditions(query.getPageNum(), query.getPageSize(), config);
        return page.toResponse(IdeaConverter::toDto);
    }

}
