package rest.api.design.controller

import com.sun.org.apache.xpath.internal.operations.Bool
import grails.converters.JSON
import groovy.json.internal.Byt
import rest.api.design.domain.Comment
import rest.api.design.domain.User
import rest.api.design.service.CommentService
import sun.misc.BASE64Decoder

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
        def result = [:]
        try{
        def commentResponse = commentService.getCommentList(commentId)
            result.put("data",commentResponse)
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

    def insertComment(){
        def params = request.JSON
        def commentObject = new Comment()
        def userObject = new User()
        def result = [:]
        def decoder = new BASE64Decoder()
        try {
        commentObject.id = 0 //because this is autoincrement in database. it is fill with new id once it's save om database
        commentObject.parentCommentId = params.parentCommentId as Integer
        commentObject.description = params.description as String
        commentObject.isCommentResolve = params.isCommentResolve as Boolean
        commentObject.createdAt = new Date()
        def imageString = params.image as String
        imageString = imageString.replace("data:image/png;base64,"," ")
        def imageByte = decoder.decodeBuffer(imageString)
        commentObject.image = imageByte
        userObject.id = params.userId as Integer
        commentObject.commentedBy = userObject
        def insertObject = commentService.insertComment(commentObject)
            result.put("status","Ok")
            result.put("data",insertObject)
            result.put("message","Comment inserted successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while inserting comment")
        }catch(Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while inserting comment")
        }finally{
            render result as JSON
        }
    }

    def updateComment(){
        def params = request.JSON
        def commentObject = new Comment()
        def result = [:]
        try {
            commentObject.id = params.id as Integer //because this is autoincrement in database. it is fill with new id once it's save om database
            commentObject.description = params.description as String
            commentObject.isCommentResolve = params.isCommentResolve as Boolean
            commentService.updateComment(commentObject,commentObject.id)
            result.put("status","Ok")
            result.put("message","Comment updating successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while updating comment")
        }catch(Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while updating comment")
        }finally{
            render result as JSON
        }
    }

    def deleteComment(){
        def commentId = params.commentId as Integer
        def result = [:]
        try {
            commentService.deleteComment(commentId)
            result.put("status","Ok")
            result.put("message","Comment deleted successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while delete comment")
        }catch (Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while delete comment")
        }
        finally{
            render  result as JSON
        }
    }
}
