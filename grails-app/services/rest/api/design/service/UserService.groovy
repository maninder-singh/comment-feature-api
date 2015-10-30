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
}
