package rest.api.design.service

import grails.transaction.Transactional
import groovy.sql.Sql
import rest.api.design.domain.User

import java.sql.SQLException

@Transactional
class UserService {

    def getUserList() throws Exception{
        def userList = new ArrayList<User>()
        def result = User.list()

        result.each { eachUser ->
            def user = new User()
            user.setId(eachUser.getId())
            user.setEmail(eachUser.getEmail())
            user.setName(eachUser.getName())
            user.setIsExternal(eachUser.getIsExternal())
            userList << user
        }
        userList
    }

    def getUserById(def userId) throws Exception{
        def user = User.get(userId)
        user
    }

    def insertUser(def user) throws SQLException,Exception{
        def userObject = new User()
        userObject.setEmail(user.getEmail())
        userObject.setName(user.getName())
        userObject.setIsExternal(user.getIsExternal())
        userObject.save(flush: true)
        userObject
    }

    def updateUser(def userId ,def user) throws SQLException,Exception{
        def userObject = User.findById(userId)
        userObject.setEmail(user.getEmail())
        userObject.setName(user.getName())
        userObject.setIsExternal(user.getIsExternal())
        userObject.save(flush: true)
    }

    def deleteUser(def userId) throws SQLException,Exception{
        def userObject = User.findById(userId)
        userObject.delete(flush: true)
    }
}
