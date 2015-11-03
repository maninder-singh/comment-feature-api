package rest.api.design.service

import com.lowagie.text.pdf.codec.Base64
import grails.transaction.Transactional
import groovy.sql.Sql
import rest.api.design.domain.Comment
import rest.api.design.domain.User

import java.sql.SQLException

@Transactional
class CommentService {

    def getCommentList(def parentCommentId = 0) throws SQLException,Exception{

        def resultMap = [:]
        def commentList = new ArrayList<Comment>()
        def userList = new ArrayList<User>()
        def dateFormat = "yyyy-MM-dd HH:mm:ss.S"
        def result = Comment.createCriteria().list{
            eq("parentCommentId",parentCommentId)
        }
        result.each{ eachComment ->
            def comment = new Comment()
            def user = new User()
            comment.setId(eachComment.getId())
            comment.setParentCommentId(eachComment.getParentCommentId())
            comment.setDescription(eachComment.getDescription())
            comment.setIsCommentResolve(eachComment.getIsCommentResolve())
            comment.setImage(eachComment.getImage())
            comment.setCreatedAt(Date.parse(dateFormat,eachComment.getCreatedAt().toString()))
            comment.setCommentedBy(eachComment.getCommentedBy())
            userList << eachComment.getCommentedBy()
            commentList << comment
        }
        resultMap.put("comments",commentList)
        resultMap.put("users",userList)
        resultMap
    }

    def insertComment(def comment) throws SQLException,Exception{
        def commentObject = new Comment()
        commentObject.setParentCommentId(comment.getParentCommentId())
        commentObject.setDescription(comment.getDescription())
        commentObject.setIsCommentResolve(comment.getIsCommentResolve())
        commentObject.setImage(comment.getImage())
        commentObject.setCreatedAt(comment.getCreatedAt())
        commentObject.setCommentedBy(comment.getCommentedBy())
        commentObject.save(flush: true)
        commentObject
    }

    def updateComment(def comment,def commentId) throws SQLException,Exception{
        def commentObject = Comment.findById(commentId)
        commentObject.setDescription(comment.getDescription())
        commentObject.setIsCommentResolve(commentObject.getIsCommentResolve())
        commentObject.save(flush: true)
    }

    def deleteComment(def commentId) throws SQLException,Exception{
        def comment = Comment.findById(commentId)
        comment.delete(flush: true)
    }
}
