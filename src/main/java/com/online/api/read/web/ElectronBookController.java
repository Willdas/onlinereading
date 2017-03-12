package com.online.api.read.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.online.api.read.domain.ElectronBook;
import com.online.api.read.service.ElectronBookService;
import com.online.commons.util.DateFormat;

/**
 * 电子书Controller类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/eBook")
public class ElectronBookController {
	/**
	 * 打印日志
	 */
	private final Logger log = LoggerFactory.getLogger(ElectronBookController.class);
	
	@Autowired
	private ElectronBookService electroBookService;
	
	@RequestMapping("/addEBook")
	@ResponseBody
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
			log.info("添加电子书成功");
		} catch (Exception e) {
			log.error("添加电子书失败");
		}
		return count;
	}
	
	
	
	
}
