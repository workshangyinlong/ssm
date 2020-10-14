<%--
  Created by IntelliJ IDEA.
  User: Dannimeiyou
  Date: 2020/10/14
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加服务点</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagehome.register.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
<div style="width:800px;margin-top: 100px">


                <h3 data-v-676ecf83="" style="text-align: center">注册新城市</h3>

                <form id="cityform"class="layui-form" method="post" style="margin-left: 150px">
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width:130px">服务区名称</label>
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="cityname" lay-verify="cityname" autocomplete="off" placeholder="服务点名称/顶级城市名称" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item" id="citypid">
                        <label class="layui-form-label" style="width:130px">所属城市选择</label>
                        <div class="layui-input-inline">
                            <select name="pid" style="width:300px">

                                <option value="0">为直属城市，非服务点</option>
                                <option v-for="city in citys" :value="city.id">服务点所属为：{{city.name}}</option>
                            </select>
                        </div>

                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="margin-left: 100px">
                            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="demo1">立即提交</button>
                        </div>
                    </div>

                </form>
</div>
</body>

<script>
    var vm = new Vue({
        el:'#citypid',
        data:{
            citys : [],
        },
    });

    $(function(){
        loadfirst(0);
    });

    function loadfirst(pid){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/city/position?pid="+pid,
            dataType:"json",
            success:function(data){
                //id为0时为父类
                if(pid==0){
                    vm.citys=data;
                }
            }
        });
    }


    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        form.on('submit(demo1)', function(data){
            $.ajax({
                url:"${pageContext.request.contextPath}/admincity/addcity",
                type:"GET",
                data:$("#cityform").serialize(),
                dataType:'json',
                success:function(res) {
                    if(res.code == 1) {
                        alert("添加成功！");
                        loadfirst(0)
                    }else {
                        layer.alert(res.msg);
                    }
                },
                error: function() {
                    alert("未知错误");
                }
            });
            return false;

        });
        form.render();
    });




</script>
</html>
