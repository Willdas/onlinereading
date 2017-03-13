package com.online.cms.read.web;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.online.cms.read.service.ElectronBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.cms.read.domain.ElectronBook;
import com.online.commons.util.DateFormat;
import com.online.commons.util.UniversalPage;

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
	 * 分页电子书
	 * @param pageNum
	 * @param pageSize
	 * @param map
	 * @return
	 */
	@RequestMapping("/page/getEBooks")
	public String getEBook(Integer pageNum,Integer pageSize,Map<String,Object> map){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNum,pageSize);
		List<ElectronBook> listEBooks = electroBookService.findAll();
		PageInfo<ElectronBook> eBookPage = UniversalPage.pageInfo(listEBooks);
		map.put("total",eBookPage.getPages());
		map.put("pageNum",eBookPage.getPageNum());
		map.put("eBookList",eBookPage.getList());
		
		System.out.println(eBookPage.getPages());
		System.out.println(eBookPage.getPageNum());
		System.out.println(eBookPage.getList());

		return "managePage/showEBooks";
		
	}
	
	@RequestMapping(value="/getEBookById/{id}")
	public String getEBookById(@PathVariable("id") String id){
		
		electroBookService.findOne(id);
		return "";
		
		
	}
	
	
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
	public int updateEBook(HttpServletRequest request,ElectronBook electroBook){
		int count = 0;
		try {
			/*String bookName = request.getParameter("bookName");
			String type = request.getParameter("bookType");
			String author = request.getParameter("author");
			String describes = request.getParameter("describes");
			ElectronBook electroBook = new ElectronBook();
			electroBook.setBookName(bookName);
			electroBook.setType(type);
			electroBook.setAuthor(author);
			electroBook.setDescribe(describes);
			*/
			String price = request.getParameter("price");
			String publishDate = request.getParameter("publishDate");
			electroBook.setPrice(Double.valueOf(price));
			electroBook.setPublishDate(DateFormat.stringToDate(publishDate));
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
