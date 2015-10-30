package rest.api.design.service

import com.lowagie.text.pdf.codec.Base64
import grails.transaction.Transactional
import rest.api.design.domain.Comment
import rest.api.design.domain.User

@Transactional
class CommentService {

    def getCommentList() {

        def commentList = new ArrayList<Comment>()
        def result = Comment.createCriteria().list {
            eq('parentCommentId',0)
        }

        result.each { eachComment ->
            def comment = new Comment()
            comment.setId(eachComment.getId())
            comment.setParentCommentId(eachComment.getParentCommentId())
            comment.setDescription(eachComment.getDescription())
            comment.setIsCommentResolve(eachComment.getIsCommentResolve())
            comment.setImage(eachComment.getImage())
            comment.setCreatedAt(eachComment.getCreatedAt())
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
            comment.setCreatedAt(eachComment.getCreatedAt())
            commentResponses << comment
        }
        commentResponses
    }
}
