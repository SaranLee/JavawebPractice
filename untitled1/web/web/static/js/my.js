/**
 * 设置列表的高亮和展开
 * menu和list都为名字
 * @param menu 父级菜单，展开并且高亮
 * @param list 高亮的菜单项
 */
var setHighlightAndMenuOpen = function(menu, list){
    $("li:contains(\'" + menu + "\')").addClass("menu-open");
    $("a:contains(\'" + menu + "\')").addClass("active");
    $("a:contains(\'" + list + "\')").addClass("active");
};

// /**
//  * 设置导航菜单项的链接
//  * @param addrPrefix 链接地址的前缀，jsp中传入${pageContext.request.contextPath}
//  */
// var setNavHref = function (addrPrefix) {
//     $("a:contains('用户列表')").attr("href", addrPrefix + "/user?method=list");
//     $("a:contains('添加用户')").attr("href", addrPrefix + "/viewpage?pageName=addUser.jsp");
//     $("a:contains('员工列表')").attr("href", addrPrefix + "/emp?method=list");
//
// };