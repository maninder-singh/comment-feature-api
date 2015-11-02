package rest.api.design.service

import com.lowagie.text.pdf.codec.Base64
import grails.transaction.Transactional
import rest.api.design.domain.Comment
import rest.api.design.domain.User

import java.sql.SQLException

@Transactional
class CommentService {

    def getCommentList(def parentCommentId = 0) throws SQLException,Exception{

        def commentList = new ArrayList<Comment>()
        def dateFormat = "yyyy-MM-dd HH:mm:ss.S"
//        def result = Comment.createCriteria().list {
//            eq('parentCommentId',0)
//        }
//        result.each { eachComment ->
//            def comment = new Comment()
//            comment.setId(eachComment.getId())
//            comment.setParentCommentId(eachComment.getParentCommentId())
//            comment.setDescription(eachComment.getDescription())
//            comment.setIsCommentResolve(eachComment.getIsCommentResolve())
//            comment.setImage(eachComment.getImage())
//            comment.setCreatedAt(eachComment.getCreatedAt())
//            commentList << comment
//        }

        def result = Comment.createCriteria().list {
            createAlias("commentedBy","user")
            projections{
                property('id')
                property('parentCommentId')
                property('description')
                property('isCommentResolve')
                property('image')
                property('createdAt')
                property('user.id')
                property('user.name')
                property('user.email')
                property('user.isExternal')
            }
            and{
                eq('parentCommentId',parentCommentId)
            }
        }
        result.each {
            def comment = new Comment()
            def user = new User()
            comment.setId(it[0])
            comment.setParentCommentId(it[1])
            comment.setDescription(it[2])
            comment.setIsCommentResolve(it[3])
            comment.setImage(it[4])
            comment.setCreatedAt(Date.parse(dateFormat,it[5].toString()))
            user.setId(it[6])
            user.setName(it[7])
            user.setEmail(it[8])
            user.setIsExternal(it[9])
            comment.setCommentedBy(user)
            commentList << comment
        }
        commentList
    }

    def getCommentResonsesById(def commentId){
        def commentResponses = new ArrayList<Comment>()

        def result = Comment.createCriteria().list {
            eq('parentCommentId',commentId)
        }

        result.each { eachComment ->
            def comment = new Comment()
            comment.setId(eachComment.getId())
            comment.setParentCommentId(eachComment.getParentCommentId())
            comment.setDescription(eachComment.getDescription())
            comment.setIsCommentResolve(eachComment.getIsCommentResolve())
            comment.setImage(eachComment.getImage())
            comment.setCommentedBy(eachComment.getCommentedBy)
            comment.setCreatedAt(eachComment.getCreatedAt())
            commentResponses << comment
        }
        commentResponses
    }
}
