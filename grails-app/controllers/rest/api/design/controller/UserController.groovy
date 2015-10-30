package rest.api.design.controller

import grails.converters.JSON
import rest.api.design.domain.User
import rest.api.design.service.UserService

class UserController {

    UserService userService

    def index() { }

    def getUsers(){

        def userList = userService.getUserList()
        def result = [data : userList]
        render result as JSON
    }

    def getUserById(){
        def userId = params.id as int
        def user = userService.getUserById(userId)
        def result = [data: user]
        render result as JSON
    }

    def insertUser(){
        def params = request.JSON
        def name = params.name as String
        def email = params.email as String
        def isExternal = params.isExternal as boolean

        def user = new User()
        user.setName(name)
        user.setEmail(email)
        user.setIsExternal(isExternal)

        def status = userService.insertUser(user)
    }
}
