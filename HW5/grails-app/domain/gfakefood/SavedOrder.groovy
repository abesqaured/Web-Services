package gfakefood

import grails.persistence.*

@Entity
class SavedOrder {
    String userName
    Item[] items
    float price


    static constraints = {
        userName maxSize: 50



    }
}
