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
<div class="layui-card">
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
                <button class="layui-btn layuiadmin-btn-useradmin" lay-submit="" lay-filter="LAY-user-front-search">
                    <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                </button>
            </div>
        </div>
    </div>


    <div class="layui-card-body">

        <table id="LAY-user-manage" lay-filter="LAY-user-manage"></table>
        <div class="layui-form layui-border-box layui-table-view" lay-filter="LAY-table-9" lay-id="LAY-user-manage" style="height: 135px;">
            <div class="layui-table-box">
                <div class="layui-table-header">
                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table">

                      <thead>
                       <tr>


                        <th data-field="id" data-key="9-0-1" class=" layui-unselect">
                             <div class="layui-table-cell laytable-cell-9-0-1">
                                 <span>ID</span>
                            <span class="layui-table-sort layui-inline">
                            <i class="layui-edge layui-table-sort-asc" title="升序"></i>
                            <i class="layui-edge layui-table-sort-desc" title="降序"></i>
                             </span>
                             </div>
                        </th>

                        <th data-field="username" data-key="9-0-2" data-minwidth="100" class="">
                            <div class="layui-table-cell laytable-cell-9-0-2">
                             <span>用户名</span>
                            </div>
                        </th>


                        <th data-field="email" data-key="9-0-3" class="">
                            <div class="layui-table-cell laytable-cell-9-0-5">
                                <span>邮箱</span>
                            </div>
                        </th>

                        <th data-field="sex" data-key="9-0-4" class="">
                            <div class="layui-table-cell laytable-cell-9-0-6">
                                <button type="button" class="btn btn-primary" onclick="resetpass()">密码重置</button>
                            </div>
                        </th>

                        <th data-field="9" data-key="9-0-5" class=" layui-table-col-special">
                            <div class="layui-table-cell laytable-cell-9-0-9" align="center">
                                <span>操作</span>
                            </div>
                        </th>

                      </tr>
                    </thead>

                  </table>
                </div>



                <div class="layui-table-body layui-table-main" style="height: 54px;">
                    <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
                        <tbody>
                        <tr data-index="0" class="">

                            <%--用户编号--%>
                            <td data-field="id" data-key="9-0-1" class="">
                                <div class="layui-table-cell laytable-cell-9-0-1">001</div>
                            </td>
                            <%--电话--%>
                            <td data-field="username" data-key="9-0-2" data-minwidth="100" class="">
                                <div class="layui-table-cell laytable-cell-9-0-2">123456</div>
                             </td>

                       <%--邮箱--%>

                            <td data-field="email" data-key="9-0-3" class="">
                                <div class="layui-table-cell laytable-cell-9-0-5">11111@qq.com</div>
                            </td>
                          <%-- 密码重置
                            <td data-field="repass" data-key="9-0-4" class="">
                                <div class="layui-table-cell laytable-cell-9-0-6">男</div>
                            </td>--%>


                            <td data-field="9" data-key="9-0-5" align="center" data-off="true" class="layui-table-col-special">
                                <div class="layui-table-cell laytable-cell-9-0-9">
                                    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">
                                        <i class="layui-icon layui-icon-edit"></i>编辑</a>
                                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">
                                        <i class="layui-icon layui-icon-delete"></i>删除</a>
                                </div>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/html" id="imgTpl">
            <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script>
        <script type="text/html" id="table-useradmin-webuser">
            <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">
                <i class="layui-icon layui-icon-edit"></i>编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">
                <i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
    </div>
</div>

<%--获取tel,email,发送ajax--%>

</body>
</html>
