
	/**  
     * @Title: ApplicationApi.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月14日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.userCenter.Entity.headResult.ResultJson;

/**
  * @ClassName: ApplicationApi
  * @Description: 项目api说明
  * @author zhugang
  * @date 2019年1月14日
  */

@RestController
@RequestMapping("/application")
public class ApplicationApi {
	
	@GetMapping("/api")
	public ResultJson<String> introductionContr(){
		String url = "";
		String result = "";
		String introduce = "";
		
		return null;
	}
}
