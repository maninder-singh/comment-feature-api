package rest.api.design.domain

class User {

    int id
    String name
    String email
    boolean isExternal

    static constraints = {
        id blank: false
    }

    static mapping = {
        table "user"
        columns {
            id column: "id"
            name column: "name"
            email column: "email"
            isExternal column: "is_external"
        }
    }
}
