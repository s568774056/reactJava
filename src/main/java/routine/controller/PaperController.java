package routine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import routine.domain.Paper;
import routine.domain.Result;
import routine.service.PaperService;
import routine.utils.ResultUtil;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/paper")
public class PaperController {

	private final static Logger logger = LoggerFactory.getLogger(PaperController.class);
	@Value("${wechat.app_id}")
	private String app_id;//从配置文件中获取值

	@Autowired
	private PaperService service;

	@GetMapping(value = "/test")
	public Result<?> test() throws Exception {
		service.test();
		return ResultUtil.success("");
	}


	//更新  /girls/23?cupSize=b&&age=2
/* 【   @PathVariable("id") Integer id,
    @RequestParam("cupSize") String cupSize,
    @RequestParam("age") Integer age】等同于 Girl girl
*/    @PutMapping(value = "/girls/{id}")
	public Result<?> girlUpdate(@PathVariable("id") Integer id,
                                @RequestParam("cupSize") String cupSize,
                                @RequestParam("age") Integer age) {
		Paper girl = new Paper();

		return service.insert(girl);
	}

	/**
	 * Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid Paper paper, BindingResult bindingResult) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		paper.setCreateDate(df.format(new Date()));
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return service.insert(paper);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.delete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(Paper paper, @PathVariable("id") Integer id) {
		paper.setId(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		paper.setUpdateDate(df.format(new Date()));
		return service.update(paper);
	}

	/**
	 * 根據條件查询
	 */
	@PostMapping(value = "/select")
	public Result select(Paper paper, @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(paper, page, size);
	}

}
