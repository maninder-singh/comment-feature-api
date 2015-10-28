package rest.api.design.domain

class Comment {

    int id
    int parentCommentId
    String description
    boolean isCommentResolve
    byte[] image
    Date createdAt

    static belongsTo = [commentedBy : User]

    static constraints = {
        id blank:false
    }
}
