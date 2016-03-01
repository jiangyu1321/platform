<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
  <meta name="renderer" content="webkit">
  
  <!-- <link rel="shortcut icon" type="image/ico" href="assets/images/favicon.ico"> -->
  <title>platform</title>

  <script type="text/javascript" src="assets/javascripts/angular-1.2.19/angular.js"></script>
  <script type="text/javascript" src="assets/javascripts/angular-1.2.19/angular-route.js"></script>

  <link rel="stylesheet" type="text/css" href="assets/stylesheets/bootstrap.min.css">
  
  <script type="text/javascript" src="assets/javascripts/module/module.auth.js"></script>
  <script type="text/javascript" src="assets/javascripts/module/module.base.route.js"></script>
  <script type="text/javascript" src="assets/javascripts/module/module.myApp.js"></script>
  
  <script type="text/javascript" src="assets/javascripts/ctrl/ctrl.home.js"></script>
  <script type="text/javascript" src="assets/javascripts/ctrl/ctrl.index.js"></script>
</head>

<body>
    <!-- 视图 -->
    <div ng-view></div>

</body>
</html>