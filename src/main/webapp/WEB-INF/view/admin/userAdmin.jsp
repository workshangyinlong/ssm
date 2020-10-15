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
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
<div class="layui-card" style="margin-right: 600px">
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
        <table class="table table-hover" id="userlis" style="width: 600px" >
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
            <tbody  v-for="user in obj" id="demo">
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
                        <button class="butt" @click="updateUser(user.id)" >修改</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>




<%--获取tel,email,发送ajax--%>
<script type="text/javascript">
    var vm=new Vue({
        el:'#userlis',
        data:{
            obj:[],
        },
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
