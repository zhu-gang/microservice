/**
 * 全局变量
 */
var saveUrl = ipPort + '/user',
	deleteUrl = ipPort + '/user',
	putUrl = ipPort + '/userInfo/state';
 
/**
 * 初始化加载
 */
$( function(){
	var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?e2af8415b6ffbaeb52de4d080cb4ba85";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
})


/*
 * 表格初始化
 */
var editObj=null,ptable=null,treeGrid=null,tableId='treeTable',layer=null;
layui.config({
    base: '/jsPackage/web/design/extend/'
}).extend({
    treeGrid:'treeGrid'
}).use(['jquery','treeGrid','layer'], function(){
    var $=layui.jquery;
    treeGrid = layui.treeGrid;//很重要
    layer=layui.layer;
    ptable=treeGrid.render({
        id:tableId
        ,elem: '#'+tableId
        ,url:ipPort +'/user/list'
        ,cellMinWidth: 100
        ,idField:'usernum'//必須字段
        ,treeId:'usernum'//树形id字段名称
        ,treeUpId:'parent_id'//树形父id字段名称
        ,treeShowName:'name'//以树形式显示的字段
        ,heightRemove:[".dHead",10]//不计算的高度,表格设定的是固定高度，此项不生效
        ,height:'80%'
        ,isFilter:false
        ,iconOpen:true//是否显示图标【默认显示】
        ,isOpenDefault:false//节点默认是展开还是折叠【默认展开】
        ,loading:true
        ,method:'post'
        ,isPage:false
        ,cols: [[
            {type:'numbers'}
            ,{type:'radio'}
            ,{type:'checkbox',sort:true}
            ,{field:'name', width:400, title: '水果名称',edit:'text',sort:true}
            ,{field:'usernum',width:200, title: 'id',sort:true}
            ,{field:'parent_id',width:150, title: 'pid',sort:true}
            ,{field:'remark1',width:100, title: '状态',templet: '#userState'}
            ,{width:300,title: '操作', align:'center'/*toolbar: '#barDemo'*/
                ,templet: function(d){
                    var html='';
                    var addBtn='<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                    var delBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                    var saveBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="save">保存</a>';
                    var openBtn='<a class="layui-btn layui-btn-xs" lay-event="open">启用</a>';
                    return addBtn+delBtn+saveBtn+openBtn;
                }
            }
        ]]
        ,parseData:function (res) {//数据加载后回调
            return res;
        }
        ,onClickRow:function (index, o) {
            console.log(index,o,"单击！");

        }
        ,onDblClickRow:function (index, o) {
            console.log(index,o,"双击");
        }
        ,onCheck:function (obj,checked,isAll) {//复选事件
            console.log(obj,checked,isAll);
        }
        ,onRadio:function (obj) {//单选事件
            console.log(obj);
        }
    });
	//操作按钮监听
    treeGrid.on('tool('+tableId+')',function (obj) {
        if(obj.event === 'del'){//删除行
            del(obj);
        }else if(obj.event==="add"){//添加行
            add(obj);
        }else if(obj.event==="save"){//保存
        	save(obj);
        }else if(obj.event==="open"){//启用
        	open(obj);
        }
    });
});

/**
 * 启用用户
 * @param {} obj
 */
function open( rowWholeData ){
	console.log( rowWholeData );	
	console.log( rowWholeData.tr[0] );	
	
	/*
	 * 前后端异步启禁用
	 */
	var trObj = rowWholeData.tr[0],
		$tdObj = $(trObj).find('td[data-field="remark1"]'),
		stateName = $tdObj.find('p').text(),
		usernum = $.trim( rowWholeData.data.usernum ),
		state = $.trim( rowWholeData.data.remark1 );
		if( !usernum ){
			layer.msg( '获取用户唯一标示失败,启用或禁用失败', {icon:4} );
			return;
		}
	if( $.trim(stateName) == '启用'){
		//后端禁用		
		//ajax( 'put', putUrl + "/" + usernum, {"state":state}, putCallBack );		
		//前端禁用
		$tdObj.find('p').text('禁用').css({'color':'#666666','font-weight':'bold'});
					
	}else if( $.trim(stateName) == '禁用'){
		//后端启用	
		//ajax( 'put', putUrl + "/" + usernum, {"state":state}, putCallBack );
		//前端启用
		$tdObj.find('p').text('启用').css({'color':'#F581B1','font-weight':'bold'});
	}else{
		console.log( '点错了' );
	}
}

/**
 * 修改状态成功回调函数
 * @param {} obj
 */
function putCallBack( jsonData ){
	console.log( '修改状态成功回调函数' );
	layer.msg( jsonData.data.message, {icon:3} );
	
}

/**
 * 删除用户
 * @param {} obj
 */
function del( obj ) {
	console.log( obj );
    layer.confirm( "你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title:'提示'},
        function( index ){//确定回调
        	//删除前端
            obj.del();
            layer.close( index );
            //删除后端
            if( !obj.data ){
            	var usernum = obj.data.usernum;
            	if( usernum ){
            		ajax( 'delete', deleteUrl + "/" + usernum, {}, deleteCallBack );
            	}else{
            		layer.msg( '删除失败，获取用户唯一标示失败', {icon:4} );
           	 	}
            }else{
            	layer.msg( '删除失败，获取用户信息失败', {icon:4} );
            }
        },function ( index ) {//取消回调
			layer.close( index );
        }
    );
}

/**
 * 删除用户成功回调函数
 * @type Number
 */
function deleteCallBack( jsonData ){
	console.log( '删除户成功回调函数' );
	layer.msg( '删除用户成功', {icon:1} );
}

/**
 * 前端操作新增数据
 * @type Number
 */
var i=1000;
function add(pObj) {
    var pdata=pObj?pObj.data:null;
    var param={};
    param.name='新增'+Math.random();
    param.usernum='请输入用户唯一编号';
    param.parent_id=pdata?pdata.usernum:null;
    treeGrid.addRow(tableId,pdata?pdata[treeGrid.config.indexName]+1:0,param);
}

/**
 * 请求后端保存增加用户
 */
function save( rowWholeData ){
	console.log( '----请求后端保存增加用户-----------' );
	console.log( rowWholeData);
	var rowData = rowWholeData?rowWholeData:null,
	data = {};
	data.name = $.trim( rowData.data.name );
	//验证名字
	console.log( '后端保存增加名字:name-' + data.name);
	if( !data.name && !/[\u4e00-\u9fa5]+/g.test(data.name) ){
		layer.msg( '新增失败,数据不合法', {icon:2} );
		return;
	}
	data.parent_id = $.trim( rowData.data.parent_id );	
	data.usernum = $.trim( rowData.data.usernum );
	console.log( '后端保存增加用户:usernum-' + data.usernum);
	//验证标识
	if( ! data.parent_id ){
		layer.msg( '新增失败,用户唯一标示不正确', {icon:2} );
		return;
	}	
	//设置默认密码
	data.user_password = '123';
	ajaxByJson( 'post', saveUrl, JSON.stringify(data), saveCallBack );
}

/**
 * 新增用户成功回调函数
 */
function saveCallBack( jsonData ){
	console.log( '新增用户成功回调函数' );
	layer.msg( '新增用户成功', {icon:1} );
}

function print() {
    console.log(treeGrid.cache[tableId]);
    var loadIndex=layer.msg("对象已打印，按F12，在控制台查看！", {
        time:3000
        ,offset: 'auto'//顶部
        ,shade: 0
    });
}

function openorclose() {
    var map=treeGrid.getDataMap(tableId);
    var o= map['102'];
    treeGrid.treeNodeOpen(tableId,o,!o[treeGrid.config.cols.isOpen]);
}


function openAll() {
    var treedata=treeGrid.getDataTreeList(tableId);
    treeGrid.treeOpenAll(tableId,!treedata[0][treeGrid.config.cols.isOpen]);
}

function getCheckData() {
    var checkStatus = treeGrid.checkStatus(tableId)
        ,data = checkStatus.data;
    layer.alert(JSON.stringify(data));
}
function radioStatus() {
    var data = treeGrid.radioStatus(tableId)
    layer.alert(JSON.stringify(data));
}
function getCheckLength() {
    var checkStatus = treeGrid.checkStatus(tableId)
        ,data = checkStatus.data;
    layer.msg('选中了：'+ data.length + ' 个');
}

function reload() {
    treeGrid.reload(tableId,{
        page:{
            curr:1
        }
    });
}
function query() {
    treeGrid.query(tableId,{
        where:{
            name:'sdfsdfsdf'
        }
    });
}

function test() {
    console.log(treeGrid.cache[tableId],treeGrid.getClass(tableId));


    /*var map=treeGrid.getDataMap(tableId);
    var o= map['102'];
    o.name="更新";
    treeGrid.updateRow(tableId,o);*/
}


