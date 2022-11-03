package info.ideaworlds.server.idea.app.converter;

import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import info.ideaworlds.server.idea.model.IdeaResponse;
import info.ideaworlds.server.idea.infra.data.Idea;

/**
 * 数据转换器
 */
public final class IdeaConverter {

    public static IdeaResponse toDto(Idea data) {
        IdeaResponse result = new IdeaResponse();
        result.setId(data.getId());
        // todo  data -> dto
        return result;
    }

    public static Idea toData(IdeaModifyArgs args) {
        Idea result = new Idea();
        // todo  args -> data
        return result;
    }

}
