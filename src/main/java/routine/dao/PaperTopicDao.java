package routine.dao;

import routine.dao.impl.BaseDao;

import java.util.List;
import java.util.Map;

public interface PaperTopicDao extends BaseDao {

	List<Map> selectPaper(Map map);
	int countSelectPaper(Map map);

	List<Map> selectTopic(Map map);
	int countSelectTopic(Map map);
}
