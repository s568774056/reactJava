package routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import routine.dao.PaperDao;
import routine.domain.Paper;
import routine.domain.Result;
import routine.enums.ResultEnum;
import routine.exception.SoftwareException;
import routine.utils.ResultUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Song
 */
@Service
public class PaperService {

    @Autowired
    private PaperDao dataDao;

    @Transactional
    public Result test() throws Exception{
        int s=1/0;
        return ResultUtil.success("");
    }

    @Transactional
    public Result insert(Paper paper) {

            return ResultUtil.success(dataDao.insert(paper));
    }

    public void getAge(Integer id) throws Exception{
        int age = dataDao.insert(null);
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new SoftwareException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new SoftwareException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    @Transactional //@Transactional事务注解
    public Result<?> delete(Integer id) {

        try {
            dataDao.insert(null);
            return ResultUtil.success("");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    @Transactional
    public Result update(Paper paper) {
        try {
            return ResultUtil.success(dataDao.update(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(Paper paper, Integer page, Integer size) {


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("page",page*size);
        map.put("size",size);
        List<Map> list = dataDao.selectPaper(map);
        return ResultUtil.success(dataDao.countSelectPaper(map),list);
    }
}