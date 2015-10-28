package rest.api.design.domain

class User {

    int id
    String name
    String email
    boolean isExternal

    static constraints = {
        id blank: false
    }
}
