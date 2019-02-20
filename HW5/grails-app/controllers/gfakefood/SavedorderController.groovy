package gfakefood


class SavedorderController {
    static responseFormats = ['json']

    def show = {
        if(params.id && User.exists(params.id)){
            render User.findById(params.id)
        }else{
            render User.list()
        }
    }

    def save = {
        def User = new User(params['User'])

        if(User.save()){
            render User
        }else{
            "500"(view:'/error')
        }
    }
}
