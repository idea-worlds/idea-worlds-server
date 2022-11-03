package info.ideaworlds.server.idea.infra.config;

import dev.simpleframework.crud.spring.ModelScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "info.ideaworlds.server.idea.infra.data.mapper")
@ModelScan(basePackages = "info.ideaworlds.server.idea.infra.data")
public class IdeaConfig {

}
