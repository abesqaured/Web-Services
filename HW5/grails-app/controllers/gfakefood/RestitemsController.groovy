package gfakefood


class RestitemsController {
    static responseFormats = ['json']

    def show = {
        if(params.id && Item.exists(params.id)){
            render Item.findById(params.id)
        }else{
            render Item.list()
        }
    }

    def save = {
        def Item = new Item(params['Item'])

        if(Item.save()){
            render Item
        }else{
            "500"(view:'/error')
        }
    }
}
