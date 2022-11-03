package info.ideaworlds.server.idea.infra.data;

import dev.simpleframework.crud.BaseModel;
import lombok.Data;

@Data
public class Idea implements BaseModel<Idea> {

    private Long id;

}
