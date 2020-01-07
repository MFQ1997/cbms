;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    layui.form;
    /*教师管理模块*/
    i.render({
        elem: "#LAY-teacher-list",
        url: "/teacher",
        cols: [
            [
                {type: "checkbox", fixed: "left"},
                {field: "id", width: 100, title: "ID", sort: !0},
                {field: "name",title: "用户名",minWidth: 100},
                {field: "phone",title: "手机"},
                {field: "email", title: "邮箱"},
                {field: "sex", width: 80, title: "性别"},
                {title: "操作",width: 150,align: "center",fixed: "right", toolbar: "#table-teacher-list"}
            ]
        ],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-teacher-list)", function (e) {
        e.data;
        var id = e.data.id;
        console.log(e.data);
        if ("del" === e.event) layer.confirm("确定删除？", function (t) {
            e.del(), layer.close(t)
        }); else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑",
                content: "/teacher/edit?id="+id,
                data:[""],
                area: ["1000px", "480px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = t.find("iframe").contents().find("#LAY-user-role-submit");
                    l.layui.form.on("submit(LAY-user-role-submit)", function (t) {
                        t.field;
                        i.reload("LAY-teacher-list"), layer.close(e)
                    }), r.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }),
        /*课程管理模块*/
        i.render({
            elem: "#LAY-teacher-list",
            url: "/teacher",
            cols: [
                [
                    {type: "checkbox", fixed: "left"},
                    {field: "id", width: 100, title: "ID", sort: !0},
                    {field: "name",title: "用户名",minWidth: 100},
                    {field: "phone",title: "手机"},
                    {field: "email", title: "邮箱"},
                    {field: "sex", width: 80, title: "性别"},
                    {title: "操作",width: 150,align: "center",fixed: "right", toolbar: "#table-teacher-list"}
                ]
            ],
            page: !0,
            limit: 30,
            height: "full-220",
            text: "对不起，加载出现异常！"
        }), i.on("tool(LAY-teacher-list)", function (e) {
        e.data;
        var id = e.data.id;
        console.log(e.data);
        if ("del" === e.event) layer.confirm("确定删除此角色？", function (t) {
            e.del(), layer.close(t)
        }); else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑角色",
                content: "/teacher/edit?id="+id,
                data:[""],
                area: ["1000px", "480px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = t.find("iframe").contents().find("#LAY-user-role-submit");
                    l.layui.form.on("submit(LAY-user-role-submit)", function (t) {
                        t.field;
                        i.reload("LAY-teacher-list"), layer.close(e)
                    }), r.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }),e("cbms", {})
});