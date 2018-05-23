package routine.repository;

import routine.domain.PaperTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperTopicRepository extends JpaRepository<PaperTopic, Integer> {

}
