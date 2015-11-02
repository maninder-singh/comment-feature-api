package rest.api.design.controller

import grails.converters.JSON
import rest.api.design.domain.User
import rest.api.design.service.UserService

import java.sql.SQLException

class UserController {

    UserService userService

    def index() { }

    def getUsers() {
        def result = [:]
        try {
            def userList = userService.getUserList()
            result.put("data",userList)
            result.put("status","Ok")
            result.put("message","Fetching users successfully")
        }catch (Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while fetching user list")
        }finally{
            render result as JSON
        }
    }

    def getUserById(){
        def userId = params.id as int
        def result = [:]
        try {
            def user = userService.getUserById(userId)
            result.put("data",user)
            result.put("status","Ok")
            result.put("message","Fetching user successfully")
        }catch (Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while fetching user")
        }finally{
            render result as JSON
        }
    }

    def insertUser(){
        def params = request.JSON
        def name = params.name as String
        def email = params.email as String
        def isExternal = params.isExternal as boolean

        def result = [:]
        try {
            def user = new User()
            user.setName(name)
            user.setEmail(email)
            user.setIsExternal(isExternal)
            def insertUser = userService.insertUser(user)
            result.put("status","Ok")
            result.put("data",insertUser)
            result.put("message","User updated successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while updating user")
        }catch(Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while updating user")
        }finally{
            render result as JSON
        }
    }

    def updatedUser(){
        def params = request.JSON
        def id = params.id as Integer
        def name = params.name as String
        def email = params.email as String
        def isExternal = params.isExternal as boolean

        def result = [:]
        try {
            def user = new User()
            user.setId(id)
            user.setName(name)
            user.setEmail(email)
            user.setIsExternal(isExternal)
            userService.updateUser(id, user)
            result.put("status","Ok")
            result.put("message","User updated successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while updating user")
        }catch(Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while updating user")
        }finally{
            render result as JSON
        }
    }

    def deleteUser(){
        def userId = params.id as Integer
        def result = [:]
        try {
            userService.deleteUser(userId)
            result.put("status","Ok")
            result.put("message","User deleted successfully")
        }catch (SQLException sqlException){
            result.put("status","Error")
            result.put("type","SqlException")
            result.put("stacktrace",sqlException)
            result.put("message","Error occur while delete user")
        }catch (Exception exception){
            result.put("status","Error")
            result.put("type","Exception")
            result.put("stacktrace",exception)
            result.put("message","Error occur while delete user")
        }
        finally{
            render  result as JSON
        }
    }
}
