package routine.dao;

import routine.dao.impl.BaseDao;

import java.util.List;
import java.util.Map;

public interface PaperDao extends BaseDao {

	List<Map> selectPaper(Map map);
	int countSelectPaper(Map map);

}
