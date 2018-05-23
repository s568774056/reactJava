package routine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import routine.domain.PaperTopic;
import routine.domain.Result;
import routine.service.PaperTopicService;
import routine.utils.ResultUtil;

import javax.validation.Valid;

@RestController
@RequestMapping("/paperTopic")
public class PaperTopicController {


	private final static Logger logger = LoggerFactory.getLogger(PaperTopicController.class);


	@Autowired
	private PaperTopicService service;

	/**
	 * @return
	 * @Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid PaperTopic paper, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return service.insert(paper);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.insert(null);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(PaperTopic paper, @PathVariable("id") Integer id) {
		paper.setId(id);
		return service.update(paper);
	}


	/**
	 * 根據條件查询
	 */
	@PostMapping(value = "/select")
	public Result select(PaperTopic paper, String name, String  subjectId, @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(paper, name,subjectId,page, size);
	}

	@PostMapping(value = "/selectTopic")
	public Result selectTopic(PaperTopic paper, String name, String  subjectId, @RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "15")Integer size)  {
		return service.selectTopic(paper, name,subjectId,page, size);
	}
}