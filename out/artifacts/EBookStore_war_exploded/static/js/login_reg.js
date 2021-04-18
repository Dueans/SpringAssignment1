//验证用户名是否已经存在
function checkUser(obj) {
    $.ajax({
        url: contextPath + "/user/checkUsername",
        data: {"username": obj.value},
        method: "post",
        success: function (data) {
            $("#msg").css("display", "block");
            const tip = $("#tip");
            if (data === '102') {//用户存在
                tip.html("用户名已存在");
                tip.removeClass("alert-success");
                tip.addClass("alert-danger");
            } else {
                tip.html("用户名可以注册");
                tip.removeClass("alert-danger");
                tip.addClass("alert-success");
            }
        }
    })
}

//用户注册
function register() {
    var datas = $("#regForm").serialize();
    $.ajax({
        url: contextPath + "/user/register",
        data: datas,
        method: "post",
        success: function (data) {
            console.log(data)
            if (data === 'success') {
                alert("注册成功，请登录！");
                $("#register").modal('hide');
            } else {
                alert("注册失败");
            }
        }
    })
}

//用户登录
function login() {
    var datas = $("#loginForm").serialize();
    $.ajax({
        url: contextPath + "/user/login",
        data: datas,
        method: "post",
        success: function (data) {
            $("#userTip").css("display", "none");
            $("#pwdTip").css("display", "none");
            if (data === '100') {
                $("#loginModal").modal('hide');
                window.location.href = contextPath + "/index";
            } else if (data === '101') {
                $("#userTip").css("display", "block");
            } else {
                $("#pwdTip").css("display", "block");
            }
        }
    })
}