package gfakefood

import grails.persistence.*

@Entity
class Item {
    String name
    float price

    static constraints = {
        id unique: true
        name maxSize: 20
    }

    static mapping = {
        table 'items'
        name column = 'name'
        price column = 'price'

    }
}
