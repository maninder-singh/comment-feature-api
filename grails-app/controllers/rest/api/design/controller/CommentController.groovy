package rest.api.design.controller

import grails.converters.JSON
import rest.api.design.service.CommentService

class CommentController {

    CommentService commentService

    def index() { }

    def getCommentList(){

        def commentList = commentService.getCommentList()
        def result = [data : commentList]
        render result as JSON
    }

    def getCommentResonsesById(){
        def commentId = params.commentId as int
        def commentResponse = commentService.getCommentResonsesById(commentId)
        def result = [data: commentResponse]
        render result as JSON
    }
}
