package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception{
		logger.info("register get.............");
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, /*Model model*/  RedirectAttributes rttr) throws Exception{
		logger.info("register post.............");
		logger.info(board.toString());
		
		service.regist(board);
		
		//model.addAttribute("result", "SUCCESS");
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		/* return "/board/success";
		 * 실제 경로 '/WEB-INF/views/board/success.jsp
		 */
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll" , method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show all list.............");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/read" , method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.info("show read .............");
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		logger.info("remove .............");
		/**
		 * addFlashAttrubute URI 저장, 동일한 URI을 '새로 고침'하면 경고창은 뜨지 않는다. 
		 */
		rttr.addFlashAttribute("msg", "SUCCESS");
			
		return "redirect:/board/listAll";		
	}
	
	@RequestMapping(value="/modify" , method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		logger.info("to modify .............");
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify" , method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		logger.info("modify post .............");
		logger.info(board.toString());
		
		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	
	/* 아래와 같이 value, method 속성은 둘 다 배열로 여러 가지 속성값을 지정할 수 있다.
	 * @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST})
	 * 
	 * */
	
}
