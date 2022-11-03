package info.ideaworlds.server.idea.infra.exception;

/**
 * 异常：Idea 不存在
 */
public class IdeaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IdeaNotFoundException(Long id) {
        super(String.format("%s [%s] cannot be found", "Idea", id));
    }

}
