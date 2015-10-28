import rest.api.design.controller.UserController

class UrlMappings {

	static mappings = {

        "user"(controller: UserController,action: [
                GET : "getUsers"
        ])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
