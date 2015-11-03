import rest.api.design.controller.UserController

class UrlMappings {

	static mappings = {

        "/user"(controller: "user" ,parseRequest: true) {
                action = [
                        GET: "getUsers",
                        POST : "insertUser",
                        PUT : "updatedUser"
                ]
        }
        "/user/$id"(controller: "user" , parseRequest: true){
            action = [
                    GET: "getUserById",
                    DELETE : "deleteUser"
            ]
        }
        "/comment"(controller: "comment" , parseRequest: true){
                action = [
                        GET : "getCommentList",
                        POST : "insertComment",
                        PUT: "updateComment"
                ]
        }
        "/comment/$commentId"(controller: "comment",parseRequest: true){
                action = [
                        GET : "getCommentResonsesById",
                        DELETE: "deleteComment"
                ]
        }
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
