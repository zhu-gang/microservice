/**
 * 全局变量
 */

/**
 * 页面初始化
 */
$( function(){
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
            ,idField:'id'
            ,url:'/jsPackage/web/data2.json'
            ,cellMinWidth: 100
            ,treeId:'id'//树形id字段名称
            ,treeUpId:'pId'//树形父id字段名称
            ,treeShowName:'name'//以树形式显示的字段
            ,cols: [[
                {width:100,title: '操作', align:'center'/*toolbar: '#barDemo'*/
                    ,templet: function(d){
                    var html='';
                    var addBtn='<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                    var delBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                    return addBtn+delBtn;
                }
                }
                ,{field:'name', edit:'text',width:300, title: '水果名称'}
                ,{field:'id',width:100, title: 'id'}
                ,{field:'pId', title: 'pid'}
            ]]
            ,page:false
        });

        treeGrid.on('tool('+tableId+')',function (obj) {
            if(obj.event === 'del'){//删除行
                del(obj);
            }else if(obj.event==="add"){//添加行
                add(obj.data);
            }
        });
    });

    function del(obj) {
        layer.confirm("你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title:'提示'},
            function(index){//确定回调
                obj.del();
                layer.close(index);
            },function (index) {//取消回调
               layer.close(index);
            }
        );
    }


    var i=1000;
    //添加
    function add(pObj) {
        var param={};
        param.name='水果'+Math.random();
        param.id=++i;
        param.pId=pObj?pObj.id:0;
        treeGrid.addRow(tableId,pObj?pObj.LAY_TABLE_INDEX+1:0,param);
    }

    function print() {
        console.log(treeGrid.cache[tableId]);
        var loadIndex=layer.msg("对象已打印，按F12，在控制台查看！", {
            time:3000
            ,offset: 'auto'//顶部
            ,shade: 0
        });
    } "/microservice-userCenter/src/main/resources/static/jsPackage/web/data2.json"
})	

/**
 * 事件绑定
 */
$( function(){
	
})