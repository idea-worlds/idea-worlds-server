package info.ideaworlds.server.idea.domain;

import info.ideaworlds.server.idea.infra.data.Idea;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IdeaEntity {

    private boolean isNew = true;
    private Long id;
    private Idea data;

    public static IdeaEntity create() {
        return new IdeaEntity();
    }

    public static IdeaEntity create(Long id, Idea data) {
        IdeaEntity entity = new IdeaEntity();
        entity.isNew = false;
        entity.id = id;
        entity.data = data;
        return entity;
    }

    public Long id() {
        if (this.id == null && this.data != null) {
            this.id = this.data.getId();
        }
        return this.id;
    }

    public Idea data() {
        return this.data;
    }

    public IdeaEntity data(Idea data) {
        data.setId(this.id);
        if(this.data == null) {
            this.data = data;
            return this;
        }
        // todo set fields
        // this.data = data;
        return this;
    }

    public boolean isNew() {
        return this.isNew;
    }

}
