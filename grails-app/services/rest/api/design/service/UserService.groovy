package rest.api.design.service

import grails.transaction.Transactional
import rest.api.design.domain.User

@Transactional
class UserService {

    def getUserList() {
        def userList = new ArrayList<User>()
        def result = User.executeQuery("select id,name,email,isExternal from User")

        result.each {
            def user = new User()
            user.setId(it[0])
            user.setEmail(it[1])
            user.setName(it[2])
            user.setIsExternal(it[3])
            userList << user
        }
        return userList
    }
}
