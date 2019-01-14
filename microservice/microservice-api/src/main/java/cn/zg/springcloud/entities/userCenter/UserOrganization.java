/**  
 * @Title: UserOrganization.java
 * @Package cn.zg.springcloud.entities.userCenter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月9日
 * @version V1.0  
 */

        
package cn.zg.springcloud.entities.userCenter;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: UserOrganization
 * @Description: 用户中心实体类-用户组织
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class UserOrganization implements Serializable{
	private Integer orgid;
	private String name;
	private Integer parent_id;
	private Integer usernum;
	private String user_password;
	private Integer is_parent;
	private String note;
	private Integer remark1;
	private String remark2;
	
	public UserOrganization(String name, Integer parent_id, Integer usernum, String user_password, 
			Integer is_parent, String note, Integer remark1, String remark2) {
		this.name = name;
		this.parent_id = parent_id;
		this.usernum = usernum;
		this.user_password = user_password;
		this.is_parent = is_parent;
		this.note = note;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}
	public UserOrganization(String name, Integer parent_id, Integer usernum, String user_password, 
			Integer is_parent, String note) {
		this.name = name;
		this.parent_id = parent_id;
		this.usernum = usernum;
		this.user_password = user_password;
		this.is_parent = is_parent;
		this.note = note;
	}
}
