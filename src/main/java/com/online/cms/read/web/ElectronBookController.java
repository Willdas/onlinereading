package com.online.cms.read.web;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.online.cms.read.service.ElectronBookService;
import com.online.cms.read.domain.ElectronBook;
import com.online.commons.util.DateFormat;

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
	 * 添加电子书
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addEBook",method=RequestMethod.POST)
	public int addEBook(HttpServletRequest request){
		int count = 0;
		try {
			String bookName = request.getParameter("bookName");
			String type = request.getParameter("bookType");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String publishDate = request.getParameter("publishDate");
			String describes = request.getParameter("describes");
			ElectronBook electroBook = new ElectronBook();
			electroBook.setBookName(bookName);
			electroBook.setType(type);
			electroBook.setAuthor(author);
			electroBook.setPrice(Double.valueOf(price));
			electroBook.setPublishDate(DateFormat.stringToDate(publishDate));
			electroBook.setDescribe(describes);
			ElectronBook eBook = electroBookService.save(electroBook);
			if(eBook != null){
				count = 1;
			}else{
				count = 0;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
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
		int count = electroBookService.delete(id);
		return count;
	}
	
	/**
	 * 修改电子书
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateEBook")
	public int updateEBook(HttpServletRequest request){
		int count = 0;
		try {
			String bookName = request.getParameter("bookName");
			String type = request.getParameter("bookType");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String publishDate = request.getParameter("publishDate");
			String describes = request.getParameter("describes");
			ElectronBook electroBook = new ElectronBook();
			electroBook.setBookName(bookName);
			electroBook.setType(type);
			electroBook.setAuthor(author);
			electroBook.setPrice(Double.valueOf(price));
			electroBook.setPublishDate(DateFormat.stringToDate(publishDate));
			electroBook.setDescribe(describes);
			ElectronBook eBook = electroBookService.update(electroBook);
			if(eBook != null){
				count = 1;
			}else{
				count = 0;
			}
		} catch (ParseException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
	
	
}
