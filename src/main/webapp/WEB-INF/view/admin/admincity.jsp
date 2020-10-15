<%--
  Created by IntelliJ IDEA.
  User: Dannimeiyou
  Date: 2020/10/14
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有城市信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagehome.index.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
    <div style="margin-right: 600px">

        <table class="table table-hover" >
            <tr>
                <td>

                </td>
                <td>
                    <div v-cloak>
                        <b style="color: red;">城市:</b>
                        <select id="dqsel"><!-- @change="getCity(cityId)" v-model="cityId"-->

                            <option value="0">请选择:</option>
                            <option v-for="mc in mcs" :value="mc.id">{{mc.name}}</option>
                        </select>
                    </div>
                </td>
                <td>
                    <div  v-cloak>
                        &nbsp;&nbsp;<button onclick="find()" data-type="auto" class="layui-btn layui-btn-normal">查询</button>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div style="margin-right: 600px">
        <table class="table table-hover" id="citylis">
            <thead>
            <tr>
                <th>
                    <div class="itemCityMsg left">
                        <p class="p1">
                            <span>服务点id</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemCityMsg left">
                        <p class="p1">
                            <span>服务点名称</span>
                        </p>
                    </div>
                </th>
                <th>
                    <div class="itemCityMsg left">
                        <div class="itemCityMsgC left">
                            <p class="p1">
                                <span>所属城市</span>
                            </p>
                        </div>
                    </div>
                </th>
                <th colspan="2">
                    <div class="itemCityMsg left">
                        <div class="itemCityMsgC left">
                            <p class="p1">
                                <span>操作</span>
                            </p>
                        </div>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody  v-for="city in citys">
            <tr>
                <td>
                    <div class="itemCityMsg left" >
                        <p class="p1">
                            <span>{{city.id}}</span>
                        </p>

                    </div>
                </td>
                <td>
                    <div class="itemCityMsg left">
                        <div class="itemCityMsgC left">
                            <p class="p1">

                            <span>{{city.name}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemCityMsg left">
                        <div class="itemCityMsgC left">
                            <p class="p1">
                                <span>{{city.pname}}</span>
                            </p>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="itemBtn left">
                        <button class="butt" @click="deleteCity(city.id)" >删除</button>
                    </div>
                </td>
                <td>
                    <div class="itemBtn left">
                        <button class="butt" @click="update(city.id)" >修改</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>





    <div class="modal fade" id="modalModify">
        <div class="modal-dialog" >
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">X</button>
                    <h4 class="modal-title">信息修改：</h4>
                </div>
                <div class ="modal-body" >
                    <div class="input-group">
                        <span class="input-group-addon"></span>
                        <input class="input-sm" type="text" id="cid" placeholder="" v-model="city.id" onfocus=this.blur() />
                    </div>
                    <br/>
                    <div class="input-group">
                        <span class="input-group-addon">id:</span>
                        <input class="input-sm" type="text" id="cname" placeholder="1" v-model="city.name"/>
                    </div>

                </div>
                <div class = "modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss ="modal">取消</button>
                    <button type="button" class="btn btn-primary" @click="updateM()" id="modify">修改</button>
                </div>
            </div>
        </div>
    </div>





<%--Vue--%>

<%--获得城市选择--%>
<script>
    var vm = new Vue({
        el:'#dqsel',
        data:{
            mcs : [],
        },
    });

    $(function(){
        loadfirst(0);
    });

    function sub(id){
        loadfirst(id);
    }

    function loadfirst(pid){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/city/position?pid="+pid,
            dataType:"json",
            success:function(data){
                //id为0时为父类
                if(pid==0){
                    vm.mcs=data;
                }
            }
        });
    }

    function find(){
       $.ajax({
           type:"GET",
           url:"${pageContext.request.contextPath}/admincity/pidcity",
           data:{"pid":$("#dqsel").children('option:selected').val()},
           dataType:"json",
           success:function (data) {
               vm1.citys=data;
           },
           error:function () {
               alert("未请求到该城市的数据！")
           }
       })
    }



    var vm1= new Vue({
        el:"#citylis",
        data:{citys:[]},
        methods:{
            deleteCity:function(id) {
                $.ajax({
                    Type:"DELETE",
                    url:"${pageContext.request.contextPath}/admincity/deletecity",
                    data:{"id":id},
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
                        alert("未知错误！");
                    }
                })
            },
            update:function (id) {
                $.ajax({
                    type:'GET',
                    url:'${pageContext.request.contextPath}/admincity/getcity?cid='+id,
                    dataType:'json',
                    success:function (data) {
                        vuemodal.city=data;
                        $("#modalModify").modal("show");
                    }
                })
            }
        }
    })
    $(function () {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/admincity/allcity",
            dataType:"json",
            success:function (data)
            {
                vm1.citys=data;
            },
            error:function () {
                alert("未请求到初始数据");
            }
        })
    })
</script>


<script>
    var vuemodal=new Vue({
        el:"#modalModify",
        data:{
            city:''
        },methods:{
            updateM:function(){
                $.ajax({
                    type:"GET",
                    url:"${pageContext.request.contextPath}/admincity/updatecity",
                    data:{"cid":$("#cid").val(),"cname":$("#cname").val()},
                    dataType:"json",
                    success:function(data){
                        if(data.code==1){
                            alert("修改成功！")
                            $("#modalModify").modal("hide");
                            find();
                        }else{
                            alert(data.msg)
                        }
                    }
                })
            }
        }
    })
</script>
</body>
</html>
