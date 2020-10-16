<%--
  Created by IntelliJ IDEA.
  User: yanghuiyi
  Date: 2020/10/15
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mymain.mymain.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
    <style>
        .control-label{
            float: left;
            width: 60px;
        }
        .content{
            margin-left:70px;
        }
        #app, body, html {
            width: 100%;
            min-width: auto;
        }
        .col-md-4{
            float: left;
            width: 33.333%;
        }
        .col-md-12{
            float: left;
            width: 100%;
        }
    </style>
</head>
<body>

<div style="margin-top: 20px;">
<!--模糊查询-->
    <div class="" id="dqsel">
        <div class="col-md-12" >
            <div class="col-md-12">
                <div class="col-md-4">
                    <div class="form-group form-horizontal">
                        <label for="tel" class="control-label">用户名:</label>
                        <div class="content">
                            <input type="text" name="tel" placeholder="请输入" autocomplete="off" class="layui-input form-control">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group form-horizontal">
                        <label for="carName" class="control-label">车型:</label>
                        <div class="content">
                            <input type="text" name="carName" placeholder="请输入" autocomplete="off" class="layui-input form-control">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group form-horizontal">
                        <label for="getCity" class="control-label">取车点</label>
                        <div class="content">
                            <select id="getCity" class="form-control">
                                <option value="0">请选择:</option>
                                <option v-for="mc in mcs" :value="mc.id">{{mc.pname}}--{{mc.name}}</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
            <div class="col-md-4">
                <div class="form-group form-horizontal">
                    <label for="backCity" class="control-label">还车点</label>
                    <div class="content">
                        <select id="backCity" class="form-control">

                            <option value="0">请选择:</option>
                            <option v-for="mc in mcs" :value="mc.id">{{mc.pname}}--{{mc.name}}</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group form-horizontal">
                    <label for="inputPassword3" class="control-label">状态</label>
                    <div class="content">
                        <select id="state" class="form-control">
                            <option value="0">请选择:</option>
                            <option >已预订</option>
                            <option >已归还</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group form-horizontal">
                    <label for="inputPassword3" class="control-label"></label>
                    <div class="content">
                        <button @click="find()" data-type="auto" class="layui-btn layui-btn-normal">查询</button>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
<!--订单展示-->
<div class="layui-card"  >
    <div >
        <table class="table table-hover"  id="orderlis" >
            <thead>
            <tr>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>订单id</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>车型</span>
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
                            <span>取车地</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>还车地</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>价格</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemUserMsg left">
                        <p class="u1">
                            <span>状态</span>
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
            <tbody  v-for="order in obj">
            <tr>
                <td>
                    <div class="itemOrderMsg left" >
                        <p class="o1">
                            <span>{{order.id}}</span>
                        </p>

                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">

                                <span>{{order.carName}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">

                                <span>{{order.tel}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">
                                <span>{{order.getcity}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">
                                <span>{{order.backcity}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">
                                <span>{{order.oprice}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemOrderMsg left">
                        <div class="itemOrderMsgC left">
                            <p class="o1">
                                <span>{{order.status}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemBtn left">
                        <button class="butt" @click="deleteNews(order.id)" >删除</button>
                    </div>

                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script>
    var vm=new Vue({
        el:"#orderlis",
        data:{
            obj:[],
        },

        methods:{
            deleteNews:function(idx) {

                  $.ajax({
                      Type:"DELETE",
                      url:"${pageContext.request.contextPath}/orderAdmin/delete",
                      data:{"id":idx},
                      dataType:"json",
                      success:function(data){
                          if(data.code==1){
                              alert("删除成功")
                              find();
                          }else{
                              alert(data.msg)
                          }
                      },
                      error:function(){
                          alert("ajax错误！");
                      }
                  })
              },
          }

    })

    function find() {
                var tel=$("input[name='tel']").val();
                var carName=$("input[name='carName']").val();
                var backid=$("#backCity option:selected").val();
                var getid=$("#getCity option:selected").val();
                var status=$("#state").val();

                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/orderAdmin/getOrder",
                    dataType:"json",
                    data:{
                        "tel":tel,
                        "carName":carName,
                        "getcity":getid,
                        "backcity":backid,
                        "status":status
                    },
                    async: false,
                    success:function(data){
                        if(data.code==1){
                            vm.obj=data.orders;
                        } else{
                            alert("没有订单信息");
                        }
                    },
                    error:function () {
                        alert("ajax加载错误");
                    }
                })
    }

    $(function () {
        loadData();
    })
    function loadData() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/orderAdmin/getAll?",
            dataType:"json",
            async: false,
            success:function(data){

                if(data.code==1){
                    vm.obj=data.orders;
                } else{
                    alert("没有订单信息");
                }
            },
            error:function () {
                alert("ajax加载错误");
            }
        })
    }
</script>
<script>
    var vm1 = new Vue({
        el:'#dqsel',
        data:{
            mcs : [],
        },
    });

    $(function () {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/admincity/allcity",
            dataType:"json",
            success:function (data)
            {
                vm1.mcs=data;
            },
            error:function () {
                alert("未请求到初始数据");
            }
        })
    })
</script>
    <script>

    </script>
</div>
</body>
</html>
