package rest.api.design.controller

import grails.converters.JSON
import rest.api.design.service.CommentService

import java.sql.SQLException

class CommentController {

    CommentService commentService

    def index() { }

    def getCommentList(){
        def result = [:]
        try {
            def commentList = commentService.getCommentList()
            result.put("data",commentList)
            result.put("status","Ok")
            result.put("message","Fetching comment's list successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while fetching comment's list")
        }
        catch (Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while fetching comment's list")
        }finally{
            render result as JSON
        }
    }

    def getCommentResonsesById(){
        def commentId = params.commentId as int
        def commentResponse = commentService.getCommentList(commentId)
        def result = [data: commentResponse]
        render result as JSON
    }
}
