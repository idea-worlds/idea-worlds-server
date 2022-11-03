package info.ideaworlds.server.idea.api;

import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import info.ideaworlds.server.idea.model.IdeaPageQueryArgs;
import info.ideaworlds.server.idea.model.IdeaResponse;
import dev.simpleframework.core.PageResponse;

/**
 * 接口
 */
public interface IdeaApi {

    /**
     * 新增
     */
    Long addIdea(IdeaModifyArgs args);

    /**
     * 修改
     */
    void updateIdea(Long id, IdeaModifyArgs args);

    /**
     * 删除
     */
    void removeIdea(Long id);

    /**
     * 根据 id 查询
     */
    IdeaResponse findIdea(Long id);

    /**
     * 分页查询
     */
    PageResponse<IdeaResponse> pageIdea(IdeaPageQueryArgs query);

}
