package info.ideaworlds.server.idea.infra.repo;

import info.ideaworlds.server.idea.domain.IdeaEntity;
import info.ideaworlds.server.idea.infra.data.Idea;
import dev.simpleframework.crud.core.Page;
import dev.simpleframework.crud.core.QueryConfig;

/**
 * 仓储接口
 */
public interface IdeaRepo {

    /**
     * 根据 id 查询
     */
    IdeaEntity findEntity(Long id);

    /**
     * 保存（无 id 新增，有 id 修改）
     *
     * @param entity 实体
     */
    void save(IdeaEntity entity);

    /**
     * 根据 id 删除
     */
    void deleteById(Long id);

    /**
     * 根据 id 查询
     */
    Idea findById(Long id);

    /**
     * 根据条件查询分页
     */
    Page<Idea> pageByConditions(int pageNum, int pageSize, QueryConfig config);

}
