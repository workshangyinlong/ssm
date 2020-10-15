<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>查看所有车型</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
    <script type="text/javascript">   </script>
</head>

<body>
<div class="row" style="width: 100%;">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">所有车型列表列表</div>
            <div class="panel-body">
                <!-- 条件查询 -->
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group form-inline">
                            <span>车名</span>
                            <input  id="cheming" type="text" name="username" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                            <div class="form-group form-inline">
                                <span>服务站</span>
                                <input  id="fuwuzhanming" type="text" name="username" class="form-control">
                            </div>
                        </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <button onclick="edit3()" type="button" class="btn btn-primary" id="search" ><span class="glyphicon glyphicon-search"></span></button>
                    </div>
                </div>
                <!-- 列表显示 -->
                <table id="tb_list" class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>type</th>
                        <th>sitnum</th>
                        <th>所述服务站</th>
                        <th>price</th>
                        <th>number</th>
                        <th>图片展示</th>
                        <th>Action</th>
                    </tr>
                    <tr v-for="user in userList">
                        <td>{{user.id}}</td>
                        <td>{{user.name}}</td>
                        <td>{{user.type}}</td>
                        <td>{{user.sitnum}}</td>
                        <td>{{user.city.name}}</td>
                        <td>{{user.price}}</td>
                        <td>{{user.number}}</td>
                        <td><img :src="user.picture" style="width:50px" style="height:50px "></td>
                        <td><button @click="edit(user.id)">修改</button><button @click="del(user.id)">删除</button></td>
                    </tr>
                </table>


            </div>
        </div>
    </div>
</div>
<!--修改的model窗体-->
<div class="modal fade" id="modalModify">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">X</button>
                <h4 class="modal-title">车辆信息修改：</h4>
            </div>
            <div class ="modal-body" >
                <div class="input-group">
                    <span class="input-group-addon">ID:</span>
                    <input class="input-sm" type="text" id="mid" placeholder="1" v-model="userInfo.id"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">车辆姓名:</span>
                    <input class="input-sm" type="text" id="mname" placeholder="1" v-model="userInfo.name"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">type:</span>
                    <input class="input-sm" type="text" id="mtype" placeholder="1" v-model="userInfo.type"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">setnum:</span>
                    <input class="input-sm" type="text" id="msetnum" placeholder="1" v-model="userInfo.setnum"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">所属服务站名:</span>
                    <input class="input-sm" type="text" id="mcityname" placeholder="1" v-model="userInfo.city.name"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">price:</span>
                    <input class="input-sm" type="text" id="mprice" placeholder="1" v-model="userInfo.price"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">number热度:</span>
                    <input class="input-sm" type="text" id="mnumber" placeholder="1" v-model="userInfo.number"/>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">图片地址picture:</span>
                    <input class="input-sm" type="text" id="mpicture" placeholder="1" v-model="userInfo.picture"/>
                </div>

            </div>
            <div class = "modal-footer">
                <button type="button" class="btn btn-default" data-dismiss ="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="edit2()" id="modify">修改</button>
            </div>
        </div>
    </div>
</div>
</div>
    <script>
        var mb2 = new Vue({
            el:'#modalModify',
            data:{
                userInfo:[]
            },

        });


        var mb1 =new Vue({
            el:'#tb_list',
            data:{
                userList:[]
            },
            methods:{
                edit:function (id) {
                    $.ajax({
                        type:'get',
                        url:'${pageContext.request.contextPath}/admincar/getcar?id='+id,
                        dataType:'json',
                        success:function (data){
                            if (data!=null) {
                                mb2.userInfo=data;
                            }
                    },
                    })
                    $("#modalModify").modal("show");
                },

                del:function (id) {
                    $.ajax({
                        type:'get',
                        url:'${pageContext.request.contextPath}/admincar/delcar?id='+id,
                        dataType:'json',
                        success:function (data) {
                            if(data!=null){
                                alert(data.msg);
                                init();
                            }else{
                                alert(data.msg)
                            }
                        },
                        error : function(){
                            alert("ajax加载失败");
                        }
                    })
                }

            }
        });

        function edit2(){
            alert("确认")
//        向后端发出修改请求后，获得成功信息，再关闭模态窗体
            $.ajax({
                type:'PUT',
                url:'${pageContext.request.contextPath}/admincar/setcar',
//            请求数据 ,将json对象转为字符串
                data: JSON.stringify(mb2.userInfo),
//            定义发送请求数据类型
                contentType:'application/json',
//            定义接收的相应数据类型
                dataType:'json',
                success:function(result){
                        alert(result.msg);
//                    重新加载数据列表
                        init();
                    }
                })
            $("#modalModify").modal("hide");
            };


    </script>
    <script>
        $(function () {
            init();
        });

        function init() {
          $.ajax({
              type:'get',
              url:'${pageContext.request.contextPath}/admincar/getallcar',
              dataType:'json',
              success:function (data){
                if (data!=null) {
                    mb1.userList=data;
                }
              },
              error : function(){
                  alert("ajax加载失败");
              }
          });
        }
    </script>
    <script>
        function edit3(){
           var cm= $("#cheming").val();
           var fm=$("#fuwuzhanming").val();
           $.ajax({
               type:'get',
               url:'${pageContext.request.contextPath}/admincar/selectcar?carName='+cm+'&serviceName='+fm,
               data:'json',
               success:function (data) {
                   if (data!=null) {
                       mb1.userList=data;

                   }
               },
               error : function(){
                   alert("ajax加载失败");
               }
           })
        }

    </script>


</body>
</html>
