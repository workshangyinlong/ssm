<%--
  Created by IntelliJ IDEA.
  User: yanghuiyi
  Date: 2020/10/14
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mymain.mymain.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
</head>
<body>
<div class="layui-card" style="margin-right: 600px" id="userlis">
    <div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="layadmin-userfront-formlist">
        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">tel</label>
                <div class="layui-input-block">
                    <input type="text" name="tel" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">email</label>
                <div class="layui-input-block">
                    <input type="text" name="email" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <button id="click" class="layui-btn layuiadmin-btn-useradmin" href="javascript:void(0)">
                    <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                </button>
            </div>
        </div>
    </div>


    <div style="margin-right: 600px">
        <table class="table table-hover"  style="width: 600px" >
            <thead>
            <tr>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>用户id</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>用户名</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                            <p class="u1">
                                <span>邮箱</span>
                            </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>邀请码</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>密码</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <div class="itemUserMsgC left">
                            <p class="p1">
                                <span>操作</span>
                            </p>
                        </div>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody  v-for="user in obj" >
            <tr>
                <td>
                    <div class="itemUserMsg left" >
                        <p class="u1">
                            <span>{{user.id}}</span>
                        </p>

                    </div>
                </td>
                <td>
                    <div class="itemUserMsg left">
                        <div class="itemUserMsgC left">
                            <p class="u1">

                                <span>{{user.tel}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemUserMsg left">
                        <div class="itemCityMsgC left">
                            <p class="u1">
                                <span>{{user.email}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemUserMsg left">
                        <div class="itemCityMsgC left">
                            <p class="u1">
                                <span>{{user.invitation}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemUserMsg left">
                        <div class="itemCityMsgC left">
                            <p class="u1">
                                <button  data-type="auto" class="reclick":val="user.id" >密码重置</button>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemBtn left">
                        <button class="butt" @click="deleteUser(user.id)" >删除</button>
                    </div>
                    <div class="itemBtn left">
                        <botton class="butt" @click="openmodal(user.id)" >修改</botton>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <%--修改模态框--%>
        <div class="modal fade" id="modalModify">
            <div class="modal-dialog" >
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">X</button>
                        <h4 class="modal-title">用户信息修改：</h4>
                    </div>
                    <div class ="modal-body" >
                        <div class="input-group">
                            <span class="input-group-addon">id:</span>
                            <input class="input-sm" type="text" id="id" placeholder="1" v-model="relid"/>
                        </div>
                        <br/>
                        <div class="input-group">
                            <span class="input-group-addon">TEL:</span>
                            <input class="input-sm" type="text" id="tel" placeholder="1" v-model="reltel"/>
                        </div>
                        <br/>

                        <div class="input-group">
                            <span class="input-group-addon">EMAIL:</span>
                            <input class="input-sm" type="text" id="email" placeholder="1" v-model="relemail"/>
                        </div>
                        <br/>
                        <div class="input-group">
                            <span class="input-group-addon">invitation:</span>
                            <input class="input-sm" type="text" id="invitation" placeholder="1" v-model="relinvitation"/>
                        </div>

                    </div>
                    <div class = "modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss ="modal">取消</button>
                        <button type="button" class="btn btn-default" onclick="edit()" id="modify">修改</button>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <%--打开模态修改--%>



    <script>
        function edit(){
            if(confirm("确认要修改吗?")){
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/user/update",
                    data:{"tel":vm.reltel,"email":vm.relemail,"id":vm.relid,"invitation":vm.relinvitation},
                    dataType:"json",
                    success:function(data){

                        if(data.code==1){
                            alert("tan!!!")
                            $("#modalModify").modal("hide");
                            alert(data.msg);
                            alert("tan!!!")
                        }else{
                            alert(data.msg);
                        }
                    }
                });
            }
        }
    </script>



<%--获取tel,email,发送ajax--%>
<script type="text/javascript">
    var vm=new Vue({
        el:'#userlis',
        data:{
            obj:[],
            id:'',
            tel:'',
            email:'',
            invitation:'',
            relid:'',
            reltel:'',
            relemail:'',
            relinvitation:''
        },
        methods:{
            openmodal:function(event) {
                var that=this;

                $.ajax({
                    url:"${pageContext.request.contextPath}/user/selectById",
                        dataType:"json",
                        data:{id:event},
                        success:function (data) {
                        alert(data.tel)

                            that.reltel=data.tel;
                        alert(that.reltel)
                            that.relemail=data.email;
                            that.relid=data.id;
                            that.relinvitation=data.invitation
                        }
                    });
                    $("#modalModify").modal("show");
            },
            deleteUser:function(idx){
                var that = this;
                alert(idx)
                //ajax,每次点击删除,往后台传 idx idx是id
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/user/delete",
                    data:{id:idx},
                    datatype:"json",
                    success:function (data){
                        if(data.code==1){
                           alert(data.msg)
                            loadData()
                        }else{
                            alert(data.msg)
                        }
                }
                })
            }

        }
        });

   $(function () {
        loadData();
    })

    function loadData() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/user/getUser",
            dataType:"json",
            async: false,
            success:function(data){
                vm.obj=data;
            },
            error:function () {
                alert("ajax加载错误");
            }
        })
    }

    $(function () {
        $("#click").click(function () {
            //email 输入框的文字
            var eText = $("input[name='email']").val();
            //tel 输入框的文字
            var tText = $("input[name='tel']").val();

            alert(eText);
            alert(tText);

            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/user/getUserList",
                dataType:"json",
                data:{tel:tText,email:eText},
                success:function(data) {
                   vm.obj=data;
                }
            })
        })
    })

   /* 密码重置*/
    $(function () {
        $(".reclick").click(function () {
            var id=$(this).attr("val")

            alert(id);

            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/user/repassword",
                dataType:"json",
                data:{id:id},
                success:function(data) {
                    if(data.code==1){
                       alert(data.msg)
                    }else{
                        alert(data.msg)
                    }

                }
            })
        })
    })


</script>
</body>
</html>
