/**  
 * @Title: Dept.java
 * @Package cn.zg.springcloud.entities
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2018年12月28日
 * @version V1.0  
 */

        
package cn.zg.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Dept
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhugang
 * @date 2018年12月28日
 *
 */

@SuppressWarnings( "serial" )
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class Dept implements Serializable{
	private Long  deptno;   //主键
	private String  dname;   //部门名称
	private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

}
