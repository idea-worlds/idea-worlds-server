package info.ideaworlds.server.idea.adapter.controller;

import info.ideaworlds.server.idea.api.IdeaApi;
import info.ideaworlds.server.idea.model.IdeaModifyArgs;
import info.ideaworlds.server.idea.model.IdeaPageQueryArgs;
import info.ideaworlds.server.idea.model.IdeaResponse;
import dev.simpleframework.core.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class IdeaController {
    private final IdeaApi api;

    @GetMapping(value = "/{id}")
    public IdeaResponse get(@PathVariable Long id) {
        return this.api.findIdea(id);
    }

    @GetMapping(value = "/page")
    public PageResponse<IdeaResponse> page(@ModelAttribute IdeaPageQueryArgs query) {
        return this.api.pageIdea(query);
    }

    @PostMapping(value = "")
    public Long add(@RequestBody IdeaModifyArgs args) {
        return this.api.addIdea(args);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody IdeaModifyArgs args) {
        this.api.updateIdea(id, args);
        return id;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        this.api.removeIdea(id);
        return id;
    }

}
