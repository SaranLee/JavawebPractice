<%@ page import="scu.demo.demo.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="scu.demo.demo.domain.Emp" %>
<%@ page import="scu.demo.demo.domain.Dept" %>
<%@ page import="scu.demo.common.Constant" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/31
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>主 页|员工管理</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700"
          rel="stylesheet">
    <!-- layer -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/modules/layer/default/layer.css">
</head>
<body class="sidebar-mini" style="height: auto;">
<div class="wrapper">
    <jsp:include page="aside.jsp"/>

    <!-- Content Wrapper. 包含页面内容 -->
    <div class="content-wrapper" style="min-height: 1200.88px;">
        <!-- 内容标题（页面标题） -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">员工管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- 主体内容 -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <!--员工表格-->
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">所有员工</h3>
                                <div class="card-tools">
                                    <button id="del_batch" type="button" class="btn btn-outline-danger btn-sm" style="margin-right: 60px;">批量删除</button>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap" style="text-align: center">
                                    <thead>
                                    <tr>
                                        <th><input type="checkbox" id="checkAll">序号</th>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>职位</th>
                                        <th>上级</th>
                                        <th>工资</th>
                                        <th>部门</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!--获取员工信息-->
                                    <%--<%--%>
                                        <%--List<Emp> emps = (List<Emp>) request.getAttribute("emps");--%>
                                        <%--int i = 0;--%>
                                        <%--Iterator<Emp> itr = emps.iterator();--%>
                                        <%--while (itr.hasNext()) {--%>
                                            <%--Emp emp = itr.next();--%>
                                            <%--if(emp.getDept() == null)--%>
                                                <%--emp.setDept(new Dept());--%>
                                            <%--if(emp.getMgrEmp() == null)--%>
                                                <%--emp.setMgrEmp(new Emp());--%>
                                            <%--System.out.println(emp);--%>
                                    <%--%>--%>
                                    <%--<tr>--%>
                                        <%--<td><%=++i%></td>--%>
                                        <%--<td><%=emp.getEmpNo()%></td>--%>
                                        <%--<td><%=emp.getEName()%></td>--%>
                                        <%--<td><%=emp.getJob()%></td>--%>
                                        <%--<td><%=emp.getMgrEmp().getEName()%></td>--%>
                                        <%--<td><%=emp.getSal()%></td>--%>
                                        <%--<td><%=emp.getDept().getDName()%></td>--%>
                                        <%--<td>--%>
                                            <%--<button type="button" class="btn btn-danger btn-sm btn_del col-sm-5 btn_del"--%>
                                                    <%--id="del_<%=emp.getEmpNo()%>">删&nbsp&nbsp除--%>
                                            <%--</button>--%>
                                            <%--<button type="button" class="btn btn-primary btn-sm col-sm-5 btn_mod"--%>
                                                    <%--id="mod_<%=emp.getEmpNo()%>">修&nbsp&nbsp改--%>
                                            <%--</button>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                    <%--<%--%>
                                        <%--}--%>
                                    <%--%>--%>
                                    <c:forEach items="${requestScope.pageInfo.list}" var="emp" varStatus="status">
                                        <tr id="slkfjsfj">
                                            <td><input type="checkbox" class="checkBox" id="check_${emp.empNo}">${status.count + (requestScope.pageInfo.pageNo-1)*requestScope.pageInfo.pageSize}</td>
                                            <td id="empNo_${emp.empNo}">${emp.empNo}</td>
                                            <td id="eName_${emp.empNo}">${emp.EName}</td>
                                            <td id="job_${emp.empNo}">${emp.job}</td>
                                            <td id="mgr_${emp.empNo}">${emp.mgrEmp.EName}<span style="visibility: hidden">${emp.mgr}</span></td>
                                            <td id="sal_${emp.empNo}">${emp.sal}</td>
                                            <td id="dept_${emp.empNo}">${emp.dept.DName}<span style="visibility: hidden">${emp.dept.deptNo}</span></td>
                                            <td>
                                                <button type="button" class="btn btn-danger btn-sm btn_del col-sm-5 btn_del"
                                                        id="del_${emp.empNo}">删&nbsp&nbsp除</button>
                                                <button type="button" class="btn btn-primary btn-sm col-sm-5 btn_mod"
                                                        id="mod_${emp.empNo}">修&nbsp&nbsp改</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div style="text-align: center; vertical-align: center; margin-bottom: 10px;margin-top: 10px">
                                    <!--每页记录数-->
                                    <div class="form-group" style="display: inline-block; float: left; margin-left: 50px">
                                        <label for="setPageSize" class="col-form-label font-weight-light">每页记录数</label>
                                        <select id="setPageSize" class="form-control" style="display: inline-block; width: 80px;">
                                            <option value="10">10条</option>
                                            <option value="20">20条</option>
                                            <option value="50">50条</option>
                                            <option value="100">100条</option>
                                        </select>
                                    </div>
                                    <!--页码-->
                                    <nav aria-label="Page navigation example" style="display: inline-block; vertical-align: middle">
                                        <ul id="empPaging" class="pagination" style="margin: 0px">
                                            <!--前一页-->
                                            <c:if test="${requestScope.pageInfo.hasPrev}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${requestScope.pageInfo.prev}&ps=${requestScope.pageInfo.pageSize}">Previous</a></li>
                                            </c:if>
                                            <c:if test="${!requestScope.pageInfo.hasPrev}">
                                                <li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${requestScope.pageInfo.prev}&ps=${requestScope.pageInfo.pageSize}">Previous</a></li>
                                            </c:if>
                                            <!--首页-->
                                            <c:if test="${requestScope.pageInfo.showFirst > 1}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=1&ps=${requestScope.pageInfo.pageSize}">1</a></li>
                                            </c:if>
                                            <!--省略号-->
                                            <c:if test="${requestScope.pageInfo.showFirst > 2}">
                                                <li class="page-item"><span class="page-link">...</span></li>
                                            </c:if>
                                            <c:forEach items="${requestScope.pageInfo.showNos}" var="showNo" varStatus="index">
                                                <c:if test="${requestScope.pageInfo.pageNo == showNo}">
                                                    <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${showNo}&ps=${requestScope.pageInfo.pageSize}">${showNo}</a></li>
                                                </c:if>
                                                <c:if test="${requestScope.pageInfo.pageNo != showNo}">
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${showNo}&ps=${requestScope.pageInfo.pageSize}">${showNo}</a></li>
                                                </c:if>
                                            </c:forEach>
                                            <!--省略号-->
                                            <c:if test="${requestScope.pageInfo.showLast < requestScope.pageInfo.totalPage - 1}">
                                                <li class="page-item"><span class="page-link">...</span></li>
                                            </c:if>
                                            <!--尾页-->
                                            <c:if test="${requestScope.pageInfo.showLast < requestScope.pageInfo.totalPage}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${requestScope.pageInfo.totalPage}&ps=${requestScope.pageInfo.pageSize}">${requestScope.pageInfo.totalPage}</a></li>
                                            </c:if>
                                            <!--后一页-->
                                            <c:if test="${requestScope.pageInfo.hasNext}">
                                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${requestScope.pageInfo.next}&ps=${requestScope.pageInfo.pageSize}">Next</a></li>
                                            </c:if>
                                            <c:if test="${!requestScope.pageInfo.hasNext}">
                                                <li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/emp?method=list&pn=${requestScope.pageInfo.next}&ps=${requestScope.pageInfo.pageSize}">Next</a></li>
                                            </c:if>
                                        </ul>
                                    </nav>
                                    <!--页面跳转-->
                                    <div class="form-group" style="display: inline-block; float: right; margin-right: 50px;">
                                        <input type="number" name="jump" class="form-control" style="display: inline-block; width: 80px;">
                                        <button name="jump" type="button" class="btn btn-sm btn-outline-success">Go</button>
                                    </div>
                                </div>

                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                    <!-- /.col-md-6 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- 控制侧边栏内容在这里 -->
        <div class="p-3 control-sidebar-content"><h5>自定义 AdminLTE</h5>
            <hr class="mb-2">
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>无导航栏边框</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>页面小号字体</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>导航栏小号字体</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>侧边栏小号字体</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>底部小号字体</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>侧边栏平面样式</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>侧边栏传统样式</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>紧凑侧边栏</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>侧边栏子级缩进</span></div>
            <div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>主侧边栏禁用悬停/获得焦点时自动展开</span></div>
            <div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>品牌小号字体</span></div>
            <h6>导航栏颜色</h6>
            <div class="d-flex">
                <div class="d-flex flex-wrap mb-3">
                    <div class="bg-primary elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-secondary elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-info elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-success elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-danger elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-indigo elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-purple elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-pink elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-navy elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-lightblue elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-teal elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-cyan elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-dark elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-gray-dark elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-gray elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-light elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-warning elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-white elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                    <div class="bg-orange elevation-2"
                         style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                </div>
            </div>
            <h6>强调颜色</h6>
            <div class="d-flex"></div>
            <div class="d-flex flex-wrap mb-3">
                <div class="bg-primary elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-warning elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-info elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-danger elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-success elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-indigo elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lightblue elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-navy elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-purple elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-fuchsia elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-pink elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-maroon elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-orange elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lime elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-teal elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-olive elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
            </div>
            <h6>暗色侧边栏颜色</h6>
            <div class="d-flex"></div>
            <div class="d-flex flex-wrap mb-3">
                <div class="bg-primary elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-warning elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-info elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-danger elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-success elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-indigo elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lightblue elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-navy elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-purple elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-fuchsia elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-pink elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-maroon elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-orange elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lime elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-teal elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-olive elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
            </div>
            <h6>亮色侧边栏颜色</h6>
            <div class="d-flex"></div>
            <div class="d-flex flex-wrap mb-3">
                <div class="bg-primary elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-warning elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-info elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-danger elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-success elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-indigo elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lightblue elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-navy elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-purple elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-fuchsia elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-pink elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-maroon elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-orange elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lime elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-teal elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-olive elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
            </div>
            <h6>品牌 LOGO 颜色</h6>
            <div class="d-flex"></div>
            <div class="d-flex flex-wrap mb-3">
                <div class="bg-primary elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-secondary elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-info elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-success elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-danger elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-indigo elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-purple elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-pink elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-navy elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-lightblue elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-teal elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-cyan elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-dark elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-gray-dark elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-gray elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-light elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-warning elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-white elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <div class="bg-orange elevation-2"
                     style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
                <a href="javascript:void(0)">清除</a></div>
        </div>
    </aside>
    <!-- /.control-sidebar -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <strong>Copyright © 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong>
        保留所有权利。
        <div class="float-right d-none d-sm-inline-block">
            <b>版本</b> 3.0.5
        </div>
    </footer>
    <div id="sidebar-overlay"></div>

    <!--修改员工信息的模态对话框-->
    <%--员工详情模态框--%>
    <div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">员工详情</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group row">
                            <label for="empNo" class="col-sm-3 col-form-label font-weight-normal">员工编号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="empNo" disabled>
                            </div>
                        </div>
                        <div class="form-group row ">
                            <label for="eName" class="col-sm-3 col-form-label font-weight-normal">员工姓名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="eName">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="job" class="col-sm-3 col-form-label font-weight-normal">职&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp位</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="job">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mgr" class="col-sm-3 col-form-label font-weight-normal">上&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp级</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="mgr">
                                    <!---->
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="sal" class="col-sm-3 col-form-label font-weight-normal">工&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp资</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="sal">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="dept" class="col-sm-3 col-form-label font-weight-normal">所在部门</label>
                            <div class="col-sm-9">
                                <select id="dept" class="form-control">
                                    <!---->
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <div class="container-fluid">
                        <div class="row" style="text-align: center;margin: auto">
                            <button type="button" class="btn btn-sm btn-secondary col-sm-3 offset-2" data-dismiss="modal">返回
                            </button>
                            <button type="button" class="btn btn-sm btn-primary col-sm-3 offset-2" id="btn_modify">修改信息</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>

<!-- 载入脚本 -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/chart.js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/pages/dashboard3.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/lay/modules/layer.js"></script>
<!-- 自己的js -->
<script src="${pageContext.request.contextPath}/static/js/my.js"></script>

<script>
    setHighlightAndMenuOpen("员工管理", "员工列表");
    //显示初始每页记录数
    $("#setPageSize").val(${requestScope.pageInfo.pageSize});

    var $empNo, $eName, $job, $mgr, $mgrNo, $sal, $dept, $deptNo;
    //点击修改按钮
    $(".btn_mod").click(function () {
        var id = $(this).attr("id");
        var empNo = id.split("_")[1];
        //显示模态框
        $("#info").modal("show");
        //装填数据
        $dept = $(this).parent().prev();
        $sal = $dept.prev();
        $mgr = $sal.prev();
        $mgrNo = $mgr.children();
        console.info($mgrNo.text());
        $job = $mgr.prev();
        $eName = $job.prev();
        $empNo = $eName.prev();
        $deptNo = $dept.children();
        console.info($deptNo.text());
        $("#empNo").val($empNo.text());
        $("#eName").val($eName.text());
        $("#job").val($job.text());
        //$("#mgr").val($mgr.text());
        var mgrs = ${requestScope.mgrs};
        var depts = $(${requestScope.depts});
        console.info(mgrs);
        console.info(depts);
        $("#mgr").empty();
        for(var i = 0;i < mgrs.length;i++) {
            $("#mgr").append($("<option value='" + mgrs[i].empNo + "'>" + mgrs[i].eName + "</option>"));
        }
        $("#dept").empty();
        depts.each(function(i, dept){
           $("#dept").append($("<option value='" + dept.deptNo + "'>" + dept.dName + "</option>"));
        });
        $("#sal").val($sal.text());
        $("#mgr").val($mgrNo.text());
        $("#dept").val($deptNo.text());

        console.info($empNo.text());
        console.info($("#empNo").val());
        console.info($("#eName").val());
        console.info($("#job").val());
        console.info($("#sal").val());
        //保存修改员工信息
        $("#btn_modify").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/emp?method=modify",
                type:'post',
                data:{
                    oldEmpNo:$empNo.text(),
                    empNo:$("#empNo").val(),
                    eName:$("#eName").val(),
                    job:$("#job").val(),
                    sal:$("#sal").val(),
                    mgr:$("#mgr").val(),
                    deptNo:$("#dept").val()
                },
                success: function(rtnText){
                    if(rtnText === "ok") {
                        //模态框消失
                        $("#info").modal("hide");
                        layer.msg("修改成功", {time: 1000, offset: ['50%', '50%']}, function () {
                            window.location = "${pageContext.request.contextPath}/emp?method=list";
                        });
                    }
                }
            });
        })
    });
    //点击删除按钮
    $(".btn_del").click(function () {
        var id = $(this).attr("id");
        var empNo = id.split("_")[1];
        var eName = $("#eName_" + empNo).text().trim();
        layer.confirm("确定删除员工 " + eName + " 吗？", {icon:0, offset: ['40%', '40%']}, function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/emp?method=delete",
                type:"post",
                data:{empNo:empNo},
                success:function (rtnText) {
                    if(rtnText === "ok")
                        layer.msg("删除成功", {time:1000, offset: ['50%', '50%']}, function(){
                            window.location = "${pageContext.request.contextPath}/emp?method=list";
                        });
                }
            });
        });
    });

    var empNos = "";    //所有被选中的emp的empNo
    var count = 0;      //被选中的emp个数
    //选中全选
    $("#checkAll").click(function(){
        $(".checkBox").prop("checked", $(this).prop("checked"));
    });
    //点击复选框时，统计有多少个被选中；同时将选中员工的empNo以字符串形式存储下来
    $(".checkBox, #checkAll").change(function () {
        count = 0;
        var checkBoxs = $(".checkBox");
        empNos="";
        checkBoxs.each(function(i, checkBox){
            if($(checkBox).prop("checked")) {
                count++;
                empNos = empNos + $(checkBox).parent().next().text().trim() + ", ";
            }
        });
        empNos += "-1";
        $("#del_batch").text("批量删除" + (count==0?"":count));
    });
    //点击批量删除按钮
    $("#del_batch").click(function () {
        //没有选择任何员工时，提示
        if(count == 0)
            layer.msg("请至少选择一个员工", {time: 2000, offset: ['35%', '40%'], anim: 6});
        else {
            layer.confirm("确定删除这 " + count + " 个员工吗？", {icon: 0, offset: ['40%', '40%']}, function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/emp?method=deleteBatch",
                    type:"post",
                    data:{empNos:empNos},
                    success:function (rtnMsg) {
                        if(rtnMsg === "<%=Constant.RESP_SUCCESS%>")
                            layer.msg("删除成功", {time:1000, offset: ['50%', '50%']}, function(){
                                window.location = "${pageContext.request.contextPath}/emp?method=list";
                            });
                    }
                })
            });
        }
    });
    //每页记录数改变时
    $("#setPageSize").change(function () {
        var pageSize = ${requestScope.pageInfo.pageSize};
        var pageNo = ${requestScope.pageInfo.pageNo};
        var newPageSize = $(this).val();
        var product = pageSize*pageNo;
        var remainder = product % newPageSize;
        var quotient = (product - remainder) / newPageSize;
        var newPageNo = (remainder == 0) ? quotient:(parseInt(product/newPageSize) + 1);
        window.location = "${pageContext.request.contextPath}/emp?method=list&pn=" + newPageNo + "&ps=" + newPageSize;
    });
    //点击跳转按钮时
    $("button[name='jump']").click(function () {
        var pageNo = $("input[name='jump']").val();
        if(pageNo < 1)
            pageNo = 1;
        if(pageNo > ${requestScope.pageInfo.totalPage})
            pageNo = ${requestScope.pageInfo.totalPage};
        window.location = "${pageContext.request.contextPath}/emp?method=list&pn=" + pageNo + "&ps=" + ${requestScope.pageInfo.pageSize};
    });
</script>