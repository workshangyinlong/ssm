<%--
  Created by IntelliJ IDEA.
  User: Dannimeiyou
  Date: 2020/10/16
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车辆增加</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagehome.index.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
<h2 style="margin-left: 300px;display: block;color:red">车辆添加页面</h2>
<form class="form-horizontal" method="post" enctype="multipart/form-data" id="car" style="width: 400px; margin-left: 200px;margin-top: 40px ">
    <div class="form-group">
        <label for="carname" class="col-sm-2 control-label">车辆名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="carname" id="carname" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="type" class="col-sm-2 control-label">类型</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="type" id="type" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="sitnum" class="col-sm-2 control-label">座位数</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="sitnum" id="sitnum" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">价格</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="price" id="price" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="number" class="col-sm-2 control-label">热度级别</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="number" id="number" placeholder="">
        </div>
    </div>

    <div class="form-group">
        <label for="pic" class="col-sm-2 control-label">图片</label>
        <div class="col-sm-10">
            <input type="file" class="form-control" name="pic" id="pic" placeholder="">
        </div>
    </div>


    <div class="form-group">
        <label for="dqsel" class="col-sm-2 control-label">城市</label>
            <div class="col-sm-10">
                <select class="form-control" id="dqsel">
                    <option >请选择</option>
                    <option v-for="mc in mcs" :value="mc.id">{{mc.name}}</option>
                </select>
            </div>
    </div>

    <div class="form-group">
        <label for="tom2" class="col-sm-2 control-label">服务点</label>
        <div class="col-sm-10" >

            <select class="form-control" name="cid" id="tom2">
                <option value="7">请选择</option>
                <option v-for="city in citys" :value="city.id">{{city.name}}</option>
            </select>
        </div>
    </div>
</form>

<div class="" style="margin-left: 300px;width: 300px" >
    <div class="col-sm-offset-2 col-sm-10">
        <button class="btn btn-default" style="background: #00FFFF" id="subadd">立即提交</button>
    </div>
</div>

<script>
    var vmchild= new Vue({
        el: "#tom2",
        data: {
            citys: [],
        }
    })

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

    $(function () {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/admincity/pidcity",
            data:{"pid":"1"},
            dataType:"json",
            success:function (data) {
                vmchild.citys=data;
            },
            error:function () {
                alert("未请求到该城市的数据！")
            }
        })
    })

    function find(){
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/admincity/pidcity",
            data:{"pid":$("#dqsel").children('option:selected').val()},
            dataType:"json",
            success:function (data) {
                vmchild.citys=data;
            },
            error:function () {
                alert("未请求到该城市的数据！")
            }
        })
    }


    var vm1= new Vue({
        el: "#dpsel2",
        data: {
            citys: [],
        }
    })

    $("#dqsel").change(function () {
        find();

    })


    $("#subadd").click(function(){
        var formdata=new FormData(document.getElementById("car"));
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/admincar/addcar",
            data:formdata,
            contentType:false,
            cache:false,
            processData:false,
            dataType:"json",
            success:function(data){
                if(data.code==1){
                    alert("添加成功");
                    window.location.reload();
                }else{
                    alert(data.msg)
                }
            }
        });
    })

</script>
</body>
</html>
