<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from www.themeon.net/nifty/v2.3/pages-login.ftlh by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 01 Mar 2016 16:53:39 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8"/><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page | Nifty - Responsive admin template.</title>

    <!--STYLESHEET-->
    <!--=================================================-->
    <!--Bootstrap Stylesheet [ REQUIRED ]-->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href="css/nifty.min.css" rel="stylesheet">

    <!--Font Awesome [ OPTIONAL ]-->
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!--Demo [ DEMONSTRATION ]-->
    <link href="css/demo/nifty-demo.min.css" rel="stylesheet">

    <!--SCRIPT-->
    <!--=================================================-->

    <!--Page Load Progress Bar [ OPTIONAL ]-->
    <link href="plugins/pace/pace.min.css" rel="stylesheet">
    <script src="plugins/pace/pace.min.js"></script>
    <!--validator [ OPTIONAL ]-->
    <link href="plugins/bootstrap-validator/bootstrapValidator.min.css" rel="stylesheet"/>


</head>

<!--TIPS-->
<!--You may remove all ID or Class names which contain "demo-", they are only used for demonstration. -->

<body>
<div id="container" class="cls-container">

    <!-- BACKGROUND IMAGE -->
    <!--===================================================-->
    <div id="bg-overlay" class="bg-img img-balloon"></div>

    <!-- HEADER -->
    <!--===================================================-->
    <div class="cls-header cls-header-lg">
        <div class="cls-brand">
            <a class="box-inline" href="index">
                <!-- <img alt="Nifty Admin" src="img/logo.png" class="brand-icon"> -->
                <span class="brand-title">Cloud-demo <span class="text-thin">boot-shiro</span></span>
            </a>
        </div>
    </div>
    <!--===================================================-->


    <!-- LOGIN FORM -->
    <!--===================================================-->
    <div class="cls-content">
        <div class="cls-content-sm panel">
            <div class="panel-body">
                <p class="pad-btm">Login</p>
                <form id="loginForm">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                            <input type="text" class="form-control" placeholder="Username" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="fa fa-asterisk"></i></div>
                            <input type="password" class="form-control" placeholder="Password" name="password">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div class="form-group">
                                <button class="btn btn-success text-uppercase" type="submit" id="login">Sign In</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--===================================================-->


</div>
<!--===================================================-->
<!-- END OF CONTAINER -->

<!--JAVASCRIPT-->
<!--=================================================-->

<!--jQuery [ REQUIRED ]-->
<script src="js/jquery-2.1.1.min.js"></script>

<!--BootstrapJS [ RECOMMENDED ]-->
<script src="js/bootstrap.min.js"></script>

<!--Fast Click [ OPTIONAL ]-->
<script src="plugins/fast-click/fastclick.min.js"></script>

<!--Nifty Admin [ RECOMMENDED ]-->
<script src="js/nifty.min.js"></script>

<!--Background Image [ DEMONSTRATION ]-->
<script src="js/demo/bg-images.js"></script>

<!--Page Load Progress Bar [ OPTIONAL ]-->
<script src="plugins/pace/pace.min.js"></script>

<!--validator [ OPTIONAL ]-->
<script src="plugins/bootstrap-validator/bootstrapValidator.min.js"></script>

<!--bootbox [ OPTIONAL ]-->
<script src="plugins/bootbox/bootbox.min.js"></script>
<script>
    $(function () {
        $('#loginForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'fa fa-check-circle fa-lg text-success',
                invalid: 'fa fa-times-circle fa-lg',
                validating: 'fa fa-refresh'
            },
            fields: {
                'username': {
                    message: '用户名不能为空',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空.'
                        }
                    }
                },
                'password': {
                    message: '密码不能为空',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空.'
                        }
                    }
                }
            }
        }).on('success.field.bv', function (e, data) {
            var $parent = data.element.parents('.form-group');
            $parent.removeClass('has-success');
        }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target);
            $form.data('bootstrapValidator');
            login();
        });
    })

    function login() {
        $.ajax({
            url: 'user/login',
            method: 'get',
            data: $('#loginForm').serialize(),
            success: function (result) {
                window.location.href = 'index';
            },
            error: function (response) {
                bootbox.alert("账号或者密码不正确")
            }
        });
    }
</script>


</body>

</html>
