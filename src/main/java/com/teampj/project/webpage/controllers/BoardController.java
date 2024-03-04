package com.teampj.project.webpage.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.services.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    
    @GetMapping("board")
    public String board() {
        return "board/list";
    }

    @GetMapping("boardEdit")
    public String board_edit() {
        return "board/edit";
    }

    @PostMapping("/board/insert")
	public ResponseEntity<Map<String, Object>> insert(Model model,@RequestBody Map<String, Object> param, HttpServletRequest req, HttpSession session){
		ResponseEntity<Map<String, Object>> res = null;
		System.out.println(param.toString());
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		int isPosted;
		try {
			isPosted = BoardService.insert(param);
			result.put("insertCnt", isPosted);
            log.info(result.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			result.put("result", false);
			res = new ResponseEntity<Map<String,Object>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			return res;
		}
		
		result.put("result", true);
		res = new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
		return res;
	}

    // @PostMapping("/board/insert")
	// // public ResponseEntity<String> insert(@RequestBody BoardModel boardModel) {
	// // 	String board = boardModel.getDcmtTitle()+" "+boardModel.getDcmtText();
	// // 	log.info(board.toString());
	// // 	return ResponseEntity.status(HttpStatus.OK).body(board);
	// // }
	// public String insert(ModelMap model) throws Exception {
	// 	List<BoardEntity> board = boardService.insert();        
	// 	model.addAttribute("board", board);
	// 	log.info(board.toString());
	// 	return "jsonView"; //model에 담은 데이터를 json화 한다고 생각하면 편하다(bean에 jsonview 선언)
	// }
    // @PostMapping("/board/insert")
    // public @ResponseBody void save() {
        
    //     System.out.println("ok");
    //     // return new ResponseModel<>(true, "정상적으로 저장되었습니다", null);
    // }

    // @PostMapping("/board/insert")
    // public @ResponseBody void save() {
        
    //     System.out.println("ok");
    //     // return new ResponseModel<>(true, "정상적으로 저장되었습니다", null);
    // }
    
    
    
}
