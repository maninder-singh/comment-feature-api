package rest.api.design.service

import grails.transaction.Transactional
import rest.api.design.domain.User

@Transactional
class UserService {

    def getUserList() {
        def userList = new ArrayList<User>();
        def user = new User()
        user.setId(1)
        user.setName("Maninder Singh")
        user.setEmail("maninder.singh@comment.com")
        user.setIsExternal(true)
        userList << user
        user = new User()
        user.setId(2)
        user.setName("Bhuvneshwar Sharma")
        user.setEmail("bhuvneshwar.sharma@comment.com")
        user.setIsExternal(true)
        userList << user
        user.setId(1)
        user.setName("Pankaj Kumar")
        user.setEmail("pankaj.kumar@comment.com")
        user.setIsExternal(true)
        userList << user
    }
}
