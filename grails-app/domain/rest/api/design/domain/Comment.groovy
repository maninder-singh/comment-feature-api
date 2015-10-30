package rest.api.design.domain

class Comment {

    int id
    int parentCommentId
    String description
    boolean isCommentResolve = false
    byte[] image
    Date createdAt

    static belongsTo = [commentedBy : User]
    static constraints = {
        id blank:false
        image nullable: true
    }

    static mapping = {
        table "comment"
        version false
        columns {
            id column: "id"
            parentCommentId column: "parent_comment_id"
            description column: "description"
            isCommentResolve column: "is_comment_resolve"
            image column: "webpage",sqlType: "blob"
            createdAt column: "created_at"
            commentedBy column: "commented_by"
        }
    }
}
