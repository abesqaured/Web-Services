package gfakefood

import grails.persistence.*

@Entity
class User {
    String userName
    String password
    static hasMany = [savedorders: SavedOrder]

    static constraints = {
        id unique: true
        userName maxSize: 20, unique: true
        password maxSize: 20, unique: true
    }

    static mapping = {
        table 'users'
        userName column: 'userName'
        passowrd column: 'password'


    }
}
