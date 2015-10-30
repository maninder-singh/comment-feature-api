package rest.api.design.service

import grails.transaction.Transactional
import rest.api.design.domain.User

@Transactional
class UserService {

    def getUserList() {
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

    def getUserById(def userId){
        def user = User.get(userId)
        user
    }

    def insertUser(def user){
        def userObject = new User()
        userObject.setEmail(user.getEmail())
        userObject.setName(user.getName())
        userObject.setIsExternal(user.getIsExternal())

        if(userObject.save()){
            // when the userObject is save in the database
            1
        }else{
            // when the userObject is not save in the database. The error occured while saving
            0
        }
    }
}
