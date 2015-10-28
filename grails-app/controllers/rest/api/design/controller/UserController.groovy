package rest.api.design.controller

import grails.converters.JSON
import rest.api.design.service.UserService

class UserController {

    UserService userService

    def index() { }

    def getUsers(){

        def userList = userService.getUserList()
        def result = [data : userList]
        render result as JSON
    }
}
