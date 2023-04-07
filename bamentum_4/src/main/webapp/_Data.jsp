<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 가정 : DB, 데이터를 취합
String name = "성춘향";
int age = 16;
String birth = "09/03/12";

String json = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\" }"; 

System.out.println(json);  // 이클립스 콘솔에 찍어보기

out.println(json);
%> 