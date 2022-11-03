package info.ideaworlds.server.idea.infra.repo.impl;

import info.ideaworlds.server.idea.domain.IdeaEntity;
import info.ideaworlds.server.idea.infra.data.Idea;
import info.ideaworlds.server.idea.infra.exception.IdeaNotFoundException;
import info.ideaworlds.server.idea.infra.repo.IdeaRepo;
import dev.simpleframework.crud.core.Page;
import dev.simpleframework.crud.core.QueryConfig;
import org.springframework.stereotype.Component;

@Component
public class IdeaRepoImpl implements IdeaRepo {
    private static final Idea dao = new Idea();

    @Override
    public IdeaEntity findEntity(Long id) {
        Idea data = this.findById(id);
        if(data == null) {
            throw new IdeaNotFoundException(id);
        }
        return IdeaEntity.create(id, data);
    }

    @Override
    public void save(IdeaEntity entity) {
        Idea data = entity.data();
        if (entity.isNew()) {
            data.insert();
        } else {
            data.updateById();
        }
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Idea findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Page<Idea> pageByConditions(int pageNum, int pageSize, QueryConfig config) {
        return dao.pageByConditions(pageNum, pageSize, config);
    }

}
