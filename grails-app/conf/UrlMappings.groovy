import rest.api.design.controller.UserController

class UrlMappings {

	static mappings = {

        "/user"(controller: "user" ,parseRequest: true) {
                action = [
                        GET: "getUsers",
                        POST : "insertUser"
                ]
        }
        "/user/$id"(controller: "user" , parseRequest: true){
            action = [
                    GET: "getUserById"
            ]
        }
        "/comment"(controller: "comment" , parseRequest: true){
                action = [
                        GET : "getCommentList"
                ]
        }
        "/comment/$commentId"(controller: "comment",parseRequest: true){
                action = [
                        GET : "getCommentResonsesById"
                ]
        }
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
