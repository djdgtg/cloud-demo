<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <link href="plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">

    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <script src="js/jquery-2.1.1.min.js"></script>

    <script src="js/bootstrap.min.js"></script>

    <script src="plugins/bootstrap-select/bootstrap-select.min.js"></script>

    <script src="plugins/bootbox/bootbox.min.js"></script>

    <script>
        function api(api) {
            $.ajax({
                type: 'get',
                url: "api/" + api,
                success: function (result) {
                    bootbox.alert(result)
                },
                error: function (response) {
                    if (response.status === 401) {
                        bootbox.alert(response.responseJSON.error)
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="boxed">

    <div id="content-container">
        <div id="page-content">

            <div class="col-sm-6">
                <div class="panel">
                    <!--Horizontal Form-->
                    <!--===================================================-->
                    <form class="form-horizontal">
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" for="demo-hor-inputemail">欢迎，${user.name}</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="demo-hor-inputpass">Api</label>
                                <div class="col-sm-8">
                                    <button class="btn btn-primary" type="button" onclick="api('hello')">
                                        <i class="fa fa-search"></i> Hello
                                    </button>
                                    <button class="btn btn-warning" type="button" onclick="api('test')">
                                        <i class="fa fa-search"></i> Test
                                    </button>
                                    <button class="btn btn-danger" type="button" onclick="api('admin')">
                                        <i class="fa fa-search"></i> Admin
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!--===================================================-->
                    <!--End Horizontal Form-->

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>