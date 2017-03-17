package com.online.cms.read.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.online.cms.read.service.ElectronBookService;
import com.online.cms.read.domain.ElectronBook;
/**
 * 电子书Controller类
 * @author willdas
 *
 */
@RestController
@RequestMapping("/eBook")
public class ElectronBookController {
	/**
	 * 打印日志
	 */
	private final Logger log = LoggerFactory.getLogger(ElectronBookController.class);
	
	@Autowired
	private ElectronBookService electroBookService;
	
	/**
	 * 查找单个电子书信息
	 */
	@RequestMapping(value="/getEBookById/{id}")
	public ElectronBook getEBookById(@PathVariable("id") String id){
		return electroBookService.findOne(id);
	}
	
	/**
	 * 添加电子书
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addEBook",method=RequestMethod.POST)
	public int addEBook(ElectronBook electronBook){
		int count;
		ElectronBook eBook = electroBookService.save(electronBook);
		if(eBook != null){
			count = 1;
		}else{
			count = 0;
		}
		return count;
	}
	
	/**
	 * 删除电子书
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delEBook/{id}")
	public int delEBook(@PathVariable("id") String id){
		return electroBookService.delete(id);
	}
	
	/**
	 * 修改电子书
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateEBook",method=RequestMethod.POST)
	public int updateEBook(ElectronBook electroBook){
		int count;
		ElectronBook eBook = electroBookService.update(electroBook);
		if(eBook != null){
			count = 1;
		}else{
			count = 0;
		}
		return count;
	}
	
}
