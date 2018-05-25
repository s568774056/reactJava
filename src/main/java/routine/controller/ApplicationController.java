package routine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import routine.domain.Application;
import routine.domain.Paper;
import routine.domain.Result;
import routine.service.ApplicationService;
import routine.service.PaperService;
import routine.utils.ResultUtil;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/application")
public class ApplicationController {

	private final static Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	private ApplicationService service;

	/**
	 * Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PutMapping(value = "/add")
	public Result<?> add(@RequestParam(value = "mBrName",required=false) String mBrName) {

		return service.insert(null);
	}

    @PutMapping(value = "/girls/{id}")
	public Result<?> update(@Valid Application app, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return service.insert(app);
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
