package gfakefood

class BootStrap {

    def init = { servletContext ->

        new User(userName: 'abe', password: 'abe').save()
        new User(userName: 'shadow', password: 'shadow').save()
        new User(userName: 'sonic', password: 'tails').save()

        new Item(name: 'Nachos', price: 5 ).save()
        new Item(name: 'Pizza', price: 10).save()
        new Item(name:  'Tacos', price: 2.5).save()





    }
    def destroy = {
    }
}
