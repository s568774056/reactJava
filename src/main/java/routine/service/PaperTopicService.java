package routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import routine.dao.PaperTopicDao;
import routine.domain.PaperTopic;
import routine.domain.Result;
import routine.enums.ResultEnum;
import routine.utils.ResultUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Song
 */
@Service
public class PaperTopicService {

    @Autowired
    private PaperTopicDao paperDao;

    @Transactional
    public Result insert(PaperTopic paper) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
       int size=  paperDao.countSelectPaper(map);
        if(size>0){
            return ResultUtil.error(ResultEnum.INSERT_TOPICDATA);
        }
        try {
            return ResultUtil.success(paperDao.insert(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.INSERT_NODATA);
        }
    }


    @Transactional
    public Result update(PaperTopic paper) {
        try {
            return ResultUtil.success(paperDao.update(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(PaperTopic paper, String name, String subjectId, Integer page, Integer size) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("name",name);
        map.put("subjectId",subjectId);
        map.put("page",page*size);
        map.put("size",size);
        List<Map> maps = paperDao.selectPaper(map);

        return ResultUtil.success(paperDao.countSelectPaper(map),maps);
    }

    public Result selectTopic(PaperTopic paper, String name, String subjectId, Integer page, Integer size) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("name",name);
        map.put("subjectId",subjectId);
        map.put("page",page*size);
        map.put("size",size);
        List<Map> maps = paperDao.selectTopic(map);
        return ResultUtil.success(paperDao.countSelectTopic(map),maps);
    }

}